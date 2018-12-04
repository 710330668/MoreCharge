package com.example.com.morecharge.receive.main.myskills;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.com.common.BaseActivity;
import com.example.com.common.util.LogUtils;
import com.example.com.morecharge.R;
import com.example.com.morecharge.receive.main.myskills.entity.SkillPosSelect;
import com.example.com.morecharge.receive.main.myskills.entity.SkillsResponseEntry;
import com.example.com.morecharge.ui.widget.TopBar;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddSkillsDetailActivity extends BaseActivity {
    @BindView(R.id.add_skill_detail_topbar)
    TopBar addSkillDetailTopbar;
    @BindView(R.id.add_skill_detail_ll)
    LinearLayout addSkillDetailLl;
    @BindView(R.id.add_skill_detail_cv)
    CardView addSkillDetailCv;
    @BindView(R.id.add_skill_detail_sure)
    Button addSkillDetailSure;

    @BindView(R.id.add_skill_detail_title)
    TextView addSkillDetailTitle;
    @BindView(R.id.add_skill_detail_content)
    TextView addSkillDetailContent;

    private static int mParentPos, mChildPos;

    private static SkillsResponseEntry.DataBean.GroupValBean mGroupValBean;


    public static void actionStart(Context context, int parentPos, int childPos, SkillsResponseEntry.DataBean.GroupValBean groupValBean) {
        mParentPos = parentPos;
        mChildPos = childPos;
        mGroupValBean = groupValBean;
        Intent intent = new Intent(context, AddSkillsDetailActivity.class);
        context.startActivity(intent);

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_add_skill_details;
    }

    @Override
    public void initParams(Bundle params) {


        LogUtils.i(new Gson().toJson(mGroupValBean));

    }

    @Override
    public void setView(Bundle savedInstanceState) {

        initTopBar();
        setVlueToView();

    }


    private void setVlueToView() {

        addSkillDetailTitle.setText(mGroupValBean.getName());

        Object text = mGroupValBean.getText();

        if (text != null) {
            addSkillDetailContent.setText(((String) text));
        }

    }

    @Override
    public void doBusiness(Context mContext) {

    }


    @OnClick({R.id.add_skill_detail_sure})
    public void onClick(View view) {

        EventBus.getDefault().post(new SkillPosSelect(mParentPos, mChildPos));

        onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initTopBar() {

        addSkillDetailTopbar.setOnTopBarClickListener(new TopBar.OnTopBarClickListener() {
            @Override
            public void onTopBarRightClick(View v) {

            }

            @Override
            public void onTopBarLeftClick(View v) {
                onBackPressed();
            }
        });

    }

}
