package com.example.hdd.morecharge.receive.main.scan.scanadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.receive.main.scan.entity.ScanRecordEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class ScanRecordAuthAdapter extends RecyclerView.Adapter<ScanRecordAuthAdapter.SacnCodeAuthViewHolder> {


    private Context mContext;
    private List<ScanRecordEntity> datas;

    public ScanRecordAuthAdapter(Context mContext, List<ScanRecordEntity> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @NonNull
    @Override
    public SacnCodeAuthViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View root = LayoutInflater.from(mContext).inflate(R.layout.view_scan_record_item, viewGroup, false);

        return new SacnCodeAuthViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull SacnCodeAuthViewHolder holder, final int i) {
        holder.scanRecordUsername.setText(datas.get(i).getUserName());

        holder.scanRecordDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                datas.remove(i);
                notifyItemRemoved(i);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public class SacnCodeAuthViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.scan_record_avatar_civ)
        CircleImageView scanRecordAvatarCiv;
        @BindView(R.id.scan_record_username)
        TextView scanRecordUsername;
        @BindView(R.id.scan_record_time)
        TextView scanRecordTime;
        @BindView(R.id.scan_record_delete)
        Button scanRecordDelete;

        public SacnCodeAuthViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
