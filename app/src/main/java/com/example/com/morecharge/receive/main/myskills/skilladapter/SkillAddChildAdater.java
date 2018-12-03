package com.example.com.morecharge.receive.main.myskills.skilladapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.com.common.util.LogUtils;
import com.example.com.morecharge.R;
import com.example.com.morecharge.receive.main.myskills.AddSkillsDetailActivity;
import com.example.com.morecharge.receive.main.myskills.MySkillsAddActivity;
import com.example.com.morecharge.receive.main.myskills.entity.SkillsResponseEntry;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SkillAddChildAdater extends RecyclerView.Adapter<SkillAddChildAdater.SkillChildViewHolder> {

    private Context mContext;
    private List<SkillsResponseEntry.DataBean.GroupValBean> mChildDatas;
    private int mParentPos;


    public SkillAddChildAdater(Context mContext, int parentPos, List<SkillsResponseEntry.DataBean.GroupValBean> mChildDatas) {
        this.mContext = mContext;
        this.mParentPos = parentPos;
        this.mChildDatas = mChildDatas;
    }

    @NonNull
    @Override
    public SkillChildViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.view_skill_add_child_item, viewGroup, false);

        return new SkillChildViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final SkillChildViewHolder holder, final int i) {

        final SkillsResponseEntry.DataBean.GroupValBean groupValBean = mChildDatas.get(i);

        holder.skillsAddChildItem.setText(groupValBean.getName());

        final String isHave = groupValBean.getIsHave();
        if (isHave.equalsIgnoreCase("Y")) {
            holder.skillAddChildBgRl.setBackgroundResource(R.drawable.bg_skill_child_selected_item);
        } else {
            holder.skillAddChildBgRl.setBackgroundResource(R.drawable.bg_skill_child_normal_item);
        }

        holder.skillAddChildBgRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if (isHave.equalsIgnoreCase("Y")) {
//                    groupValBean.setIsHave("N");
//                } else {
//                    groupValBean.setIsHave("Y");
//                }
//                mChildDatas.set(i, groupValBean);
//                notifyItemChanged(i);

//                LogUtils.i(new Gson().toJson(mChildDatas));

//                AddSkillsDetailActivity.actionStart(mContext,mParentPos,i,groupValBean);

            }
        });




    }


    @Override
    public int getItemCount() {
        return mChildDatas == null ? 0 : mChildDatas.size();
    }

    public class SkillChildViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.skills_add_child_item)
        TextView skillsAddChildItem;
        @BindView(R.id.skill_add_child_bg_rl)
        RelativeLayout skillAddChildBgRl;
        @BindView(R.id.skill_add_child_delete_iv)
        ImageView skillAddChildDeleteIv;

        public SkillChildViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
