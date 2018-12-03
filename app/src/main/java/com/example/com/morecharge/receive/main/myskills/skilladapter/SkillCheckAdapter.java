package com.example.com.morecharge.receive.main.myskills.skilladapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.com.morecharge.R;
import com.example.com.morecharge.receive.main.myskills.entity.SkillsResponseEntry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SkillCheckAdapter extends RecyclerView.Adapter<SkillCheckAdapter.SkillAddViewHolder> {


    private Context mContext;

    private List<SkillsResponseEntry.DataBean> datas;

    public SkillCheckAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public SkillCheckAdapter(Context mContext, List<SkillsResponseEntry.DataBean> data) {
        this.mContext = mContext;
        this.datas = data;
    }

    @NonNull
    @Override
    public SkillAddViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.view_skill_check_item, viewGroup, false);

        return new SkillAddViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SkillAddViewHolder holder, int i) {

        holder.skillsCheckTitle.setText(datas.get(i).getGroupName());

        holder.skillsCheckChildRecy.setHasFixedSize(true);
        holder.skillsCheckChildRecy.setLayoutManager(new GridLayoutManager(mContext, 2));

        final SkillCheckChildAdater childAdater = new SkillCheckChildAdater(mContext, i, datas.get(i).getGroupVal());
        holder.skillsCheckChildRecy.setAdapter(childAdater);

        holder.skillsCheckEditLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String editStr = holder.skillsCheckEdit.getText().toString().trim();
                if (editStr.equals("编辑")) {
                    holder.skillsCheckEdit.setText("完成");
                    childAdater.setShowDeleteIcon(true);
                    childAdater.notifyDataSetChanged();
                } else {
                    holder.skillsCheckEdit.setText("编辑");
                    childAdater.setShowDeleteIcon(false);
                    childAdater.notifyDataSetChanged();
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public class SkillAddViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.skills_check_title)
        TextView skillsCheckTitle;
        @BindView(R.id.skills_check_edit)
        TextView skillsCheckEdit;
        @BindView(R.id.skills_check_edit_ll)
        LinearLayout skillsCheckEditLl;
        @BindView(R.id.skills_check_child_recy)
        RecyclerView skillsCheckChildRecy;
        @BindView(R.id.skills_check_root_cv)
        CardView skillsCheckRootCv;

        public SkillAddViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    public List<SkillsResponseEntry.DataBean> getDatas() {

        if (datas == null) {
            return new ArrayList<>();
        }
        return datas;

    }

    /**
     * 末未添加数据
     */
    public void addData(@NonNull Collection<SkillsResponseEntry.DataBean> newData) {
        datas.addAll(newData);
        notifyItemRangeInserted(datas.size() - newData.size(), newData.size());
        compatibilityDataSizeChanged(newData.size());
    }

    /**
     * 通知 更新
     */
    private void compatibilityDataSizeChanged(int size) {
        final int dataSize = datas == null ? 0 : datas.size();
        if (dataSize == size) {
            notifyDataSetChanged();
        }
    }

}
