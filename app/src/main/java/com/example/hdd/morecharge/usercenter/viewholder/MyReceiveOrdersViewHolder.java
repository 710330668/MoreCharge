package com.example.hdd.morecharge.usercenter.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.hdd.common.adapter.BaseViewHolder;
import com.example.hdd.common.adapter.ItemData;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.usercenter.response.MyReceiveOrdersResponse;

/**
 * Created by 71033 on 2018/11/21.
 */
public class MyReceiveOrdersViewHolder extends BaseViewHolder {

    private TextView tvTitle , tvName , tvLocation , tvTime ,tvSalary ;

    private Button btnStatus , btnComplete;

    private onCompleteOrderListener completeOrderListener;

    private onCancelOrderListener cancelOrderListener;

    private onAppraiseOrderListener appraiseOrderListener;

    /**
     * TODO
     * single view may be direct construction, eg: TextView view = new TextView(context);
     *
     * @param parent current no use, may be future use
     * @param view
     */
    public MyReceiveOrdersViewHolder(ViewGroup parent, View view) {
        super(parent, view);
    }

    @Override
    public void findViews() {
        tvTitle = itemView.findViewById(R.id.tv_title);
        tvName = itemView.findViewById(R.id.tv_name);
        tvLocation = itemView.findViewById(R.id.tv_location);
        tvTime = itemView.findViewById(R.id.tv_time);
        tvSalary = itemView.findViewById(R.id.tv_salary);
        btnStatus = itemView.findViewById(R.id.btn_give_up);
        btnComplete = itemView.findViewById(R.id.btn_complete);
    }

    @Override
    public void onBindViewHolder(Object data, int position) {
        final MyReceiveOrdersResponse.DataBean.RecordsBean recordsBean = (MyReceiveOrdersResponse.DataBean.RecordsBean) ((ItemData)data).data;
        tvTitle.setText(recordsBean.getOrderInfo().getOrderTypeName());
        tvName.setText(recordsBean.getOrderInfo().getLinkman());
        tvLocation.setText(recordsBean.getOrderInfo().getAddress());
        tvTime.setText(recordsBean.getOrderInfo().getModifyTime());
        tvSalary.setText(recordsBean.getOrderInfo().getSalary()+"元");
        switch (recordsBean.getWorkerInfo().getOrderState()){
            case "GET":
                //进行中
                btnComplete.setVisibility(View.VISIBLE);
                btnStatus.setVisibility(View.VISIBLE);
                btnComplete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //完成
                        completeOrderListener.completeOrder(recordsBean);
                    }
                });
                btnStatus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //放弃
                        cancelOrderListener.cancelOrder(recordsBean);
                    }
                });
                break;
            case "FINISH":
                //已完成
                btnComplete.setVisibility(View.INVISIBLE);
                btnStatus.setText("已完成");
                break;
            case "COMMENT":
                //待评价
                btnComplete.setVisibility(View.INVISIBLE);
                btnStatus.setText("评价");
                btnStatus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        appraiseOrderListener.appraiseOrder(recordsBean);
                    }
                });
                break;
                default:
                    btnComplete.setVisibility(View.INVISIBLE);
                    break;

        }
    }

    public interface onCompleteOrderListener{
        void completeOrder(MyReceiveOrdersResponse.DataBean.RecordsBean recordsBean);
    }

    public interface onCancelOrderListener{
        void cancelOrder(MyReceiveOrdersResponse.DataBean.RecordsBean recordsBean);
    }

    public interface onAppraiseOrderListener{
        void appraiseOrder(MyReceiveOrdersResponse.DataBean.RecordsBean recordsBean);
    }

    public void setOnCompleteOrderListener(onCompleteOrderListener completeOrderListener){
        this.completeOrderListener = completeOrderListener;
    }

    public void setOnCancelOrderListener(onCancelOrderListener cancelOrderListener){
        this.cancelOrderListener = cancelOrderListener;
    }

    public void setOnAppraiseOrderListener(onAppraiseOrderListener appraiseOrderListener){
        this.appraiseOrderListener = appraiseOrderListener;
    }
}
