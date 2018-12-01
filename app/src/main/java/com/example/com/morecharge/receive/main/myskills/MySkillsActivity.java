package com.example.com.morecharge.receive.main.myskills;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.com.common.BaseActivity;
import com.example.com.morecharge.R;
import com.example.com.morecharge.ui.widget.TopBar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的 技能
 */
public class MySkillsActivity extends BaseActivity {
    @BindView(R.id.my_skills_topbar)
    TopBar mySkillsTopbar;
    @BindView(R.id.my_skills_add_rl)
    RelativeLayout mySkillsAddRl;
    @BindView(R.id.my_skills_check_rl)
    RelativeLayout mySkillsCheckRl;

    @Override
    public int bindLayout() {
        return R.layout.activity_my_skills;
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void setView(Bundle savedInstanceState) {


        initTopBar();


    }

    @Override
    public void doBusiness(Context mContext) {

    }


    @OnClick({R.id.my_skills_add_rl, R.id.my_skills_check_rl})
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.my_skills_add_rl:
                startActivity(MySkillsAddActivity.class);
                break;
            case R.id.my_skills_check_rl:
                startActivity(MySkillsCheckActivity.class);
                break;
            default:
                break;

        }

    }


    private void initTopBar() {

        mySkillsTopbar.setOnTopBarClickListener(new TopBar.OnTopBarClickListener() {
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
