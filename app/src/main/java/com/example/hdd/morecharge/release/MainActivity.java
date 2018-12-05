package com.example.hdd.morecharge.release;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.ImageView;

import com.example.hdd.common.BaseActivity;
import com.example.hdd.common.BaseFragment;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.release.main.ui.fragment.ArchitectureFragment;
import com.example.hdd.morecharge.release.main.ui.fragment.CleanKeepingFragment;
import com.example.hdd.morecharge.release.main.ui.fragment.DownWindFragment;
import com.example.hdd.morecharge.release.main.ui.fragment.PartTimeJobFragment;
import com.example.hdd.morecharge.usercenter.MineActivity;
import com.example.hdd.morecharge.view.CustomViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.iv_mine)
    ImageView mIvMine;
    @BindView(R.id.iv_code_scan)
    ImageView mIvCodeScan;
    @BindView(R.id.tab_main)
    TabLayout mTabMain;
    @BindView(R.id.tab_container)
    CustomViewPager mVpContainer;

    private String[] titles = {"顺风腿", "建筑工地", "兼职", "保洁"};
    private List<BaseFragment> fragmentList = new ArrayList<>();

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void setView(Bundle savedInstanceState) {
        mVpContainer.setScanScroll(false);
    }

    @Override
    public void doBusiness(Context mContext) {
        for (int i = 0; i < titles.length; i++) {
            mTabMain.addTab(mTabMain.newTab().setText(titles[i]));
        }
        initSubFragment();
    }

    @OnClick(R.id.iv_mine)
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.iv_mine:
                startActivity(MineActivity.class);
                break;
        }
    }


    /**
     * sub fragment
     */
    private void initSubFragment() {
        DownWindFragment downWindFragment = new DownWindFragment();
        fragmentList.add(downWindFragment);

        ArchitectureFragment architectureFragment = new ArchitectureFragment();
        fragmentList.add(architectureFragment);

        PartTimeJobFragment partTimeJobFragment = new PartTimeJobFragment();
        fragmentList.add(partTimeJobFragment);

        CleanKeepingFragment cleanKeepingFragment = new CleanKeepingFragment();
        fragmentList.add(cleanKeepingFragment);

        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Override
            public Fragment getItem(int i) {
                return fragmentList.get(i);
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        };

        mVpContainer.setAdapter(fragmentPagerAdapter);

        mTabMain.setupWithViewPager(mVpContainer);
        mTabMain.setTabsFromPagerAdapter(fragmentPagerAdapter);
    }
}
