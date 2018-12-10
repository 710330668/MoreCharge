package com.example.hdd.morecharge.receive.main.integrate.integrateadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.hdd.common.util.ToastUtils;
import com.example.hdd.imageloader.LoaderManager;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.receive.main.goodsdetail.GoodsDetailActivity;
import com.example.hdd.morecharge.receive.main.integrate.MyIntegrateActivity;
import com.example.hdd.morecharge.receive.main.integrate.entity.IntegGoodsListResponse;
import com.example.hdd.morecharge.receive.main.myskills.TempConstant;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IntegrateAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context mContext;
    private List<IntegGoodsListResponse.DataBean.RecordsBean> goodsListDatas;

    // 普通布局
    private final int TYPE_ITEM = 1;
    // 脚布局
    private final int TYPE_FOOTER = 2;

    // 当前加载状态，默认为加载完成
    private int loadState = 2;
    // 正在加载
    public final int LOADING = 1;
    // 加载完成
    public final int LOADING_COMPLETE = 2;
    // 加载到底
    public final int LOADING_END = 3;

    public IntegrateAdapter(Context mContext, List<IntegGoodsListResponse.DataBean.RecordsBean> goodsListDatas) {
        this.mContext = mContext;
        this.goodsListDatas = goodsListDatas;
    }

    @Override
    public int getItemViewType(int position) {

        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        if (viewType == TYPE_ITEM) {

            View view = LayoutInflater.from(mContext).inflate(R.layout.view_integrade_item, parent, false);

            return new IntegrateViewHolder(view);
        } else if (viewType == TYPE_FOOTER) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_refresh_footer, parent, false);
            return new FootViewHolder(view);
        }
        return null;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        if (holder instanceof IntegrateViewHolder) {

            IntegrateViewHolder integrateViewHolder = (IntegrateViewHolder) holder;

            setItemViewHolder(integrateViewHolder, position);

        } else if (holder instanceof FootViewHolder) {
            FootViewHolder footViewHolder = (FootViewHolder) holder;
            switch (loadState) {
                case LOADING: // 正在加载
                    footViewHolder.pbLoading.setVisibility(View.VISIBLE);
                    footViewHolder.tvLoading.setVisibility(View.VISIBLE);
                    footViewHolder.llEnd.setVisibility(View.GONE);
                    break;

                case LOADING_COMPLETE: // 加载完成
                    footViewHolder.pbLoading.setVisibility(View.INVISIBLE);
                    footViewHolder.tvLoading.setVisibility(View.INVISIBLE);
                    footViewHolder.llEnd.setVisibility(View.GONE);
                    break;

                case LOADING_END: // 加载到底
                    footViewHolder.pbLoading.setVisibility(View.GONE);
                    footViewHolder.tvLoading.setVisibility(View.GONE);
                    footViewHolder.llEnd.setVisibility(View.VISIBLE);
                    break;

                default:
                    break;
            }
        }


    }

    private void setItemViewHolder(IntegrateViewHolder holder, final int pos) {

        final IntegGoodsListResponse.DataBean.RecordsBean recordsBean = goodsListDatas.get(pos);
        List<IntegGoodsListResponse.DataBean.RecordsBean.HeadImgBean> headImg = recordsBean.getHeadImg();

        if (headImg != null) {
            LoaderManager.getLoader().loadNet(holder.integradeItemIv, headImg.get(0).getFileUrl());
        }

        holder.integradeItemTitleTv.setText(recordsBean.getName());
        holder.integradeItemDescTv.setText(recordsBean.getExplainText());
        holder.integradeItemNumTv.setText(recordsBean.getIntegral() + "积分");
        holder.integradeItemExchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int needsInt = recordsBean.getIntegral();

                BigDecimal myInte = new BigDecimal(TempConstant.MY_INTEGRATE);
                BigDecimal needsInte = new BigDecimal(needsInt);

                BigDecimal canChangeNum = myInte.divide(needsInte, BigDecimal.ROUND_DOWN);


                int compareTo = canChangeNum.compareTo(BigDecimal.ONE);


                if (compareTo != -1) {

//                    initBottomSheetDialog(canChangeNum.intValue());
                    ((MyIntegrateActivity) mContext).initBottomSheetDialog(recordsBean,pos,canChangeNum,needsInte);

                } else {
                    ToastUtils.showShort(mContext, "您的积分不足");

                }

            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = recordsBean.getId();

                if (TextUtils.isEmpty(id)) {
                    ToastUtils.showShort(mContext, "获取信息有误");
                } else {

                    GoodsDetailActivity.actionStart(mContext, id);
                }


            }
        });


    }


    @Override
    public int getItemCount() {
        return goodsListDatas == null ? 1 : goodsListDatas.size() + 1;
    }

    public class IntegrateViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.integrade_item_iv)
        ImageView integradeItemIv;
        @BindView(R.id.integrade_item_title_tv)
        TextView integradeItemTitleTv;
        @BindView(R.id.integrade_item_desc_tv)
        TextView integradeItemDescTv;
        @BindView(R.id.integrade_item_num_tv)
        TextView integradeItemNumTv;
        @BindView(R.id.integrade_item_root_cv)
        CardView integradeItemRootCv;

        @BindView(R.id.integrade_item_exchange)
        Button integradeItemExchange;

        public IntegrateViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private class FootViewHolder extends RecyclerView.ViewHolder {

        ProgressBar pbLoading;
        TextView tvLoading;
        LinearLayout llEnd;

        FootViewHolder(View itemView) {
            super(itemView);
            pbLoading = (ProgressBar) itemView.findViewById(R.id.pb_loading);
            tvLoading = (TextView) itemView.findViewById(R.id.tv_loading);
            llEnd = (LinearLayout) itemView.findViewById(R.id.ll_end);
        }
    }


    /**
     * 设置上拉加载状态
     *
     * @param loadState 0.正在加载 1.加载完成 2.加载到底
     */
    public void setLoadState(int loadState) {
        this.loadState = loadState;
        notifyDataSetChanged();
    }


    /**
     * 末未添加数据
     */
    public void addData(@NonNull Collection<IntegGoodsListResponse.DataBean.RecordsBean> newData) {
        goodsListDatas.addAll(newData);
        notifyItemRangeInserted(goodsListDatas.size() - newData.size(), newData.size());
        compatibilityDataSizeChanged(newData.size());
    }

    /**
     * 通知 更新
     */
    private void compatibilityDataSizeChanged(int size) {
        final int dataSize = goodsListDatas == null ? 0 : goodsListDatas.size();
        if (dataSize == size) {
            notifyDataSetChanged();
        }
    }


}
