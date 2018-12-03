package com.example.com.morecharge.receive.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.com.common.adapter.BaseViewHolder;
import com.example.com.common.adapter.ItemData;
import com.example.com.morecharge.R;
import com.example.com.morecharge.receive.response.ReceiveOrdersResponse;

/**
 * Created by 71033 on 2018/11/21.
 */
public class ReceiveOrdersViewHolder extends BaseViewHolder {

    private TextView tvTitle,tvLocation,tvLocationName,tvTime,tvTimeLimit,tvSalary,tvGoDetail;

    private onMoreListener listener;

    /**
     * TODO
     * single view may be direct construction, eg: TextView view = new TextView(context);
     *
     * @param parent current no use, may be future use
     * @param view
     */
    public ReceiveOrdersViewHolder(ViewGroup parent, View view) {
        super(parent, view);
    }

    @Override
    public void findViews() {
        tvTitle = itemView.findViewById(R.id.tv_title);
        tvLocation = itemView.findViewById(R.id.tv_location);
        tvLocationName = itemView.findViewById(R.id.tv_location_name);
        tvTime = itemView.findViewById(R.id.tv_time);
        tvTimeLimit = itemView.findViewById(R.id.tv_time_limit);
        tvSalary = itemView.findViewById(R.id.tv_salary);
        tvGoDetail = itemView.findViewById(R.id.tv_go_detail);
    }

    @Override
    public void onBindViewHolder(Object data, final int position) {
        ReceiveOrdersResponse.DataBean dataBean = (ReceiveOrdersResponse.DataBean) ((ItemData)data).data;
        tvTitle.setText(dataBean.getOrderInfo().getOrderTypeName());
        tvLocationName.setText(dataBean.getOrderInfo().getAddress());
        tvTime.setText(dataBean.getOrderInfo().getCreateTime());
        tvSalary.setText(dataBean.getOrderInfo().getSalary()+"");
        tvGoDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.gotoOrderDetail(position);
            }
        });
    }

    public interface onMoreListener{

        void gotoOrderDetail(int position);

    }

    public void setOnMoreListener(onMoreListener listener){
        this.listener = listener;
    }
}
