package com.example.hdd.morecharge.receive.main.myskills.skilladapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hdd.common.util.ToastUtils;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.receive.main.myskills.AddSkillsDetailActivity;
import com.example.hdd.morecharge.receive.main.myskills.MySkillsCheckActivity;
import com.example.hdd.morecharge.receive.main.myskills.TempConstant;
import com.example.hdd.morecharge.receive.main.myskills.entity.SkillResetResponse;
import com.example.hdd.morecharge.receive.main.myskills.entity.SkillsResponseEntry;
import com.example.hdd.morecharge.receive.main.myskills.entity.SkillsSelectedCode;
import com.example.hdd.morecharge.remote.Injection;
import com.example.hdd.morecharge.utils.GsonUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class SkillCheckChildAdater extends RecyclerView.Adapter<SkillCheckChildAdater.SkillChildViewHolder> {

    private Context mContext;
    private List<SkillsResponseEntry.DataBean.GroupValBean> mChildDatas;
    private int mParentPos;
    private boolean isShow = false;


    public SkillCheckChildAdater(Context mContext, int parentPos, List<SkillsResponseEntry.DataBean.GroupValBean> mChildDatas) {
        this.mContext = mContext;
        this.mParentPos = parentPos;
        this.mChildDatas = mChildDatas;
    }

    public void setShowDeleteIcon(boolean isShow) {
        this.isShow = isShow;
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


        if (isShow) {
            holder.skillAddChildDeleteIv.setVisibility(View.VISIBLE);
        } else {
            holder.skillAddChildDeleteIv.setVisibility(View.INVISIBLE);
        }

        holder.skillAddChildDeleteIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                删除 用户技能
                removeUserSkill(groupValBean.getCode(), i);


            }
        });


    }

    @SuppressLint("CheckResult")
    private void removeUserSkill(String code, final int pos) {

        if (TextUtils.isEmpty(code)) {
            return;
        }

        Injection.provideApiService().removeSkill(TempConstant.token, GsonUtil.getRequestBody(new SkillsSelectedCode(code)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SkillResetResponse>() {
                    @Override
                    public void accept(SkillResetResponse skillResetResponse) throws Exception {
                        mChildDatas.remove(pos);
                        notifyItemRemoved(pos);
                        ToastUtils.showShort(mContext, skillResetResponse.getMsg());

                        if (mChildDatas.size() == 0) {
                            ((MySkillsCheckActivity) mContext).deleteEndPos(mParentPos);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        ToastUtils.showShort(mContext, throwable.getMessage());
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
