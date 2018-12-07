package com.example.com.morecharge.receive.main.integrate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.com.common.BaseActivity;
import com.example.com.common.util.LogUtils;
import com.example.com.common.util.ToastUtils;
import com.example.com.morecharge.R;
import com.example.com.morecharge.receive.main.goodsdetail.GoodsMoreActivity;
import com.example.com.morecharge.receive.main.goodsdetail.GoodsToPayActivity;
import com.example.com.morecharge.receive.main.goodsdetail.entry.EmptyRequestEntry;
import com.example.com.morecharge.receive.main.goodsdetail.widget.AmountView;
import com.example.com.morecharge.receive.main.integrate.entity.InteGoodsInfoEntity;
import com.example.com.morecharge.receive.main.integrate.entity.IntegGoodsListResponse;
import com.example.com.morecharge.receive.main.integrate.entity.IntegrateDelegate;
import com.example.com.morecharge.receive.main.integrate.entity.IntegrateEntity;
import com.example.com.morecharge.receive.main.integrate.entity.MyIntegrateResponseEntry;
import com.example.com.morecharge.receive.main.integrate.integrateadapter.IntegrateAdapter;
import com.example.com.morecharge.receive.main.integrate.listener.EndlessRecyclerOnScrollListener;
import com.example.com.morecharge.receive.main.myskills.TempConstant;
import com.example.com.morecharge.receive.main.myskills.entity.SkillResetResponse;
import com.example.com.morecharge.remote.Injection;
import com.example.com.morecharge.ui.widget.TopBar;
import com.example.com.morecharge.utils.GsonUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 我的 积分
 */
public class MyIntegrateActivity extends BaseActivity {
    @BindView(R.id.intgrade_topbar)
    TopBar intgradeTopbar;
    @BindView(R.id.intgrade_num_tv)
    TextView intgradeNumTv;
    @BindView(R.id.intgrade_num_fl)
    FrameLayout intgradeNumFl;
    @BindView(R.id.intgrade_divider_desc)
    LinearLayout intgradeDividerDesc;
    @BindView(R.id.intgrade_recy)
    RecyclerView intgradeRecy;
    @BindView(R.id.intgrade_num_unit)
    TextView intgradeNumUnit;
    @BindView(R.id.intgrade_more_tv)
    TextView intgradeMoreTv;

    private Context mContext;
    private IntegrateAdapter integrateAdapter;

    private List<IntegGoodsListResponse.DataBean.RecordsBean> goodsRecordsList;

    private int pageNum = 1;
    private int pageSize = 10;

    @Override
    public int bindLayout() {
        return R.layout.activity_my_integrate;
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void setView(Bundle savedInstanceState) {
        mContext = MyIntegrateActivity.this;

        topbarOnClick();
        initRecycler();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getSelfScore();
    }

    @Override
    public void doBusiness(Context mContext) {

//        getSelfScore();
        getGoodsList(pageNum);
    }

    @SuppressLint("CheckResult")
    private void getGoodsList(int pageNum) {
        Injection.provideApiService().getGoodsList(TempConstant.token, pageNum, pageSize, GsonUtil.getRequestBody(new EmptyRequestEntry()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<IntegGoodsListResponse>() {
                    @Override
                    public void accept(IntegGoodsListResponse goodsListResponse) throws Exception {

                        List<IntegGoodsListResponse.DataBean.RecordsBean> records = goodsListResponse.getData().getRecords();

                        if (records != null) {
                            integrateAdapter.addData(records);

                            if (records.size() < pageSize) {
                                integrateAdapter.setLoadState(integrateAdapter.LOADING_END);
                            } else {
                                integrateAdapter.setLoadState(integrateAdapter.LOADING_COMPLETE);

                            }

                        }


                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        ToastUtils.showShort(MyIntegrateActivity.this, throwable.getMessage());
                    }
                });


    }


    @SuppressLint("CheckResult")
    private void getSelfScore() {
        Injection.provideApiService().getSelefScore(TempConstant.token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MyIntegrateResponseEntry>() {
                    @Override
                    public void accept(MyIntegrateResponseEntry responseEntry) throws Exception {
                        setValueToScoreView(responseEntry);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        ToastUtils.showShort(MyIntegrateActivity.this, throwable.getMessage());
                    }
                });

    }

    private void setValueToScoreView(MyIntegrateResponseEntry responseEntry) {

        boolean success = responseEntry.isSuccess();

        if (success) {
            MyIntegrateResponseEntry.DataBean data = responseEntry.getData();

            if (data != null) {

                double score = data.getScore();
                TempConstant.MY_INTEGRATE = score;
                String scoreStr = new BigDecimal(score).toPlainString();
                intgradeNumTv.setText(scoreStr);
            } else {
                intgradeNumTv.setText("");
                intgradeNumUnit.setVisibility(View.INVISIBLE);
            }


        } else {
            ToastUtils.showShort(MyIntegrateActivity.this, responseEntry.getMsg());
        }

    }

    private void initRecycler() {

        goodsRecordsList = new ArrayList<>();
        intgradeRecy.setLayoutManager(new LinearLayoutManager(this));
        intgradeRecy.setHasFixedSize(true);
        integrateAdapter = new IntegrateAdapter(MyIntegrateActivity.this, goodsRecordsList);
        intgradeRecy.setAdapter(integrateAdapter);
        intgradeRecy.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            public void onLoadMore() {
                startLoadNextPage();
            }
        });

    }

    public void startLoadNextPage() {

        integrateAdapter.setLoadState(integrateAdapter.LOADING);
        pageNum++;
        getGoodsList(pageNum);

    }

    BigDecimal payInte = new BigDecimal(0);
    private int needsAmount = 0;

    public void initBottomSheetDialog(final IntegGoodsListResponse.DataBean.RecordsBean recordsBean, final int pos, final BigDecimal titalNum, final BigDecimal needsInt) {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(mContext);

        View view = View.inflate(mContext, R.layout.view_goods_bottom, null);
        Button goodsChageBtn = view.findViewById(R.id.goods_bottom_sure_btn);
        AmountView amountView = view.findViewById(R.id.goods_bottom_amount_view);
        amountView.setGoods_storage(titalNum.intValue());
        amountView.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {
            @Override
            public void onAmountChange(View view, int amount) {

                needsAmount = amount;
                payInte = needsInt.multiply(new BigDecimal(amount));

                if (amount >= titalNum.intValue()) {
                    ToastUtils.showShort(mContext, "您最多兑换" + titalNum + "个");

                    needsAmount = amount;
                    payInte = needsInt.multiply(new BigDecimal(amount));
                }

            }
        });
        goodsChageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.hide();

                initBottomPayDialog(recordsBean, pos);
            }
        });
        bottomSheetDialog.setContentView(view);

        bottomSheetDialog.show();
    }

    public void initBottomPayDialog(IntegGoodsListResponse.DataBean.RecordsBean recordsBean, int pos) {

        final InteGoodsInfoEntity goodsInfoEntity = new InteGoodsInfoEntity();
        goodsInfoEntity.setItemId(recordsBean.getId());
        goodsInfoEntity.setItemCount(needsAmount);
        goodsInfoEntity.setItemFileUrl(recordsBean.getHeadImg().get(pos).getFileUrl());
        goodsInfoEntity.setItemIntege(recordsBean.getIntegral());
        goodsInfoEntity.setItemTitle(recordsBean.getName());
        goodsInfoEntity.setItemTotalIntege(payInte.toPlainString());

        final BottomSheetDialog bottomPayDialog = new BottomSheetDialog(mContext);

        View view = View.inflate(mContext, R.layout.view_goods_pay_bottom, null);
        Button goodsPayBtn = view.findViewById(R.id.goods_bottom_pay_btn);
        TextView needsInt = view.findViewById(R.id.goods_bottom_needs_num);
        needsInt.setText(payInte.toPlainString() + " 积分");
        goodsPayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomPayDialog.hide();
                GoodsToPayActivity.actionStart(MyIntegrateActivity.this, goodsInfoEntity);
            }
        });
        bottomPayDialog.setContentView(view);
        bottomPayDialog.show();

    }


    @OnClick({R.id.intgrade_more_tv})
    public void onClick() {
        startActivity(GoodsMoreActivity.class);
    }


    private void topbarOnClick() {

        intgradeTopbar.setOnTopBarClickListener(new TopBar.OnTopBarClickListener() {
            @Override
            public void onTopBarRightClick(View v) {
                ToastUtils.showLong(mContext, "左侧点击");
            }

            @Override
            public void onTopBarLeftClick(View v) {
                onBackPressed();
            }
        });

    }


}
