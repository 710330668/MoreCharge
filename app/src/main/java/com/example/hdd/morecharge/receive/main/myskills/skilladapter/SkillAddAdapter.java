package com.example.hdd.morecharge.receive.main.myskills.skilladapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.receive.main.myskills.entity.SkillsResponseEntry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SkillAddAdapter extends RecyclerView.Adapter<SkillAddAdapter.SkillAddViewHolder> {


    private Context mContext;

    private List<SkillsResponseEntry.DataBean> datas;

    public SkillAddAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public SkillAddAdapter(Context mContext, List<SkillsResponseEntry.DataBean> data) {
        this.mContext = mContext;
        this.datas = data;
    }

    @NonNull
    @Override
    public SkillAddViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.view_skill_add_item, viewGroup, false);

        return new SkillAddViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillAddViewHolder holder, int i) {

        holder.skillsAddTitle.setText(datas.get(i).getGroupName());

        holder.skillsAddChildRecy.setHasFixedSize(true);
        holder.skillsAddChildRecy.setLayoutManager(new GridLayoutManager(mContext, 2));

        SkillAddChildAdater childAdater = new SkillAddChildAdater(mContext,i, datas.get(i).getGroupVal());
        holder.skillsAddChildRecy.setAdapter(childAdater);
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public class SkillAddViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.skills_add_title)
        TextView skillsAddTitle;
        @BindView(R.id.skills_add_child_recy)
        RecyclerView skillsAddChildRecy;
//        @BindView(R.id.skills_add_root_cv)
//        CardView skillsAddRootCv;

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
