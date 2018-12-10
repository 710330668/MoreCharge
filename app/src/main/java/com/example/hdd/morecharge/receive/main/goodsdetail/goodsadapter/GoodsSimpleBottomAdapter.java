package com.example.hdd.morecharge.receive.main.goodsdetail.goodsadapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class GoodsSimpleBottomAdapter extends FragmentPagerAdapter {

    private List<Fragment> mList;
    private List<String> mListString;
    private Context context;

    public GoodsSimpleBottomAdapter(FragmentManager fm, Context context, List<Fragment> mList, List<String> mListString) {
        super(fm);
        this.context = context;
        this.mList = mList;
        this.mListString = mListString;
    }

    @Override
    public Fragment getItem(int i) {
        return mList.get(i);
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mListString.get(position);
    }
}
