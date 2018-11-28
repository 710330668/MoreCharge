package com.example.com.morecharge.receive.main.scan;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.com.common.BaseActivity;
import com.example.com.morecharge.R;
import com.example.com.morecharge.receive.main.scan.entity.ScanRecordEntity;
import com.example.com.morecharge.receive.main.scan.scanadapter.ScanRecordAuthAdapter;
import com.example.com.morecharge.receive.main.scan.scanfilterdown.Dic;
import com.example.com.morecharge.receive.main.scan.scanfilterdown.DropDownMenu;
import com.example.com.morecharge.receive.main.scan.scanfilterdown.Madapter;
import com.example.com.morecharge.receive.main.scan.scanfilterdown.ScreenUtils;
import com.example.com.morecharge.receive.main.scan.scanfilterdown.SearchAdapter;
import com.example.com.morecharge.receive.main.scan.widget.SwipeItemLayout;
import com.example.com.morecharge.ui.widget.TopBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ScanRecordActivity extends BaseActivity {

    @BindView(R.id.scan_record_topbar)
    TopBar scanRecordTopbar;
    @BindView(R.id.scan_record_year_tv)
    TextView scanRecordYearTv;
    @BindView(R.id.scan_record_year_ll)
    LinearLayout scanRecordYearLl;
    @BindView(R.id.scan_record_month_tv)
    TextView scanRecordMonthTv;
    @BindView(R.id.scan_record_month_ll)
    LinearLayout scanRecordMonthLl;
    @BindView(R.id.scan_record_day_tv)
    TextView scanRecordDayTv;
    @BindView(R.id.scan_record_day_ll)
    LinearLayout scanRecordDayLl;
    @BindView(R.id.scan_record_timebar_ll)
    LinearLayout scanRecordTimebarLl;
    @BindView(R.id.scan_record_recy)
    RecyclerView scanRecordRecy;

    @Override
    public int bindLayout() {

        return R.layout.activity_scan_record;

    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void setView(Bundle savedInstanceState) {

        initDropDown();


        initRecy();
    }

    private void initRecy() {


        List<ScanRecordEntity> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add(new ScanRecordEntity("userName" + i));
        }

        ScanRecordAuthAdapter authAdapter = new ScanRecordAuthAdapter(this, list);

        scanRecordRecy.addOnItemTouchListener(new SwipeItemLayout.OnSwipeItemTouchListener(this));
        scanRecordRecy.setLayoutManager(new LinearLayoutManager(this));
        scanRecordRecy.setAdapter(authAdapter);

    }

    private SearchAdapter yearAdapter;
    private SearchAdapter monthAdapter;
    private SearchAdapter dayAdapter;
    private DropDownMenu dropDownMenu;
    private View listItem;
    private View listView;

    private void initDropDown() {


        dropDownMenu = DropDownMenu.getInstance(this, new DropDownMenu.OnListCkickListence() {
            @Override
            public void search(String code, String type) {
                Log.i("scan", "======" + code + "=========" + type);
            }

            @Override
            public void changeSelectPanel(Madapter madapter, View view) {

            }
        });

//        dropDownMenu.setIndexColor(R.color.colorAccent);
        dropDownMenu.setShowShadow(true);
        dropDownMenu.setShowName("name");
        dropDownMenu.setSelectName("code");

        initData();


        listItem = getLayoutInflater().inflate(R.layout.item_listview, null, false);
        listView = getLayoutInflater().inflate(R.layout.pup_selectlist, null, false);


    }

    private void initData() {

        yearAdapter = new SearchAdapter(this);
        List<Dic> yearDatas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            yearDatas.add(new Dic(i + "", 2016 + i + ""));
        }
        yearAdapter.setItems(yearDatas);

        monthAdapter = new SearchAdapter(this);
        List<Dic> monthDatas = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            monthDatas.add(new Dic(i + "", i + 1 + ""));
        }
        monthAdapter.setItems(monthDatas);

        dayAdapter = new SearchAdapter(this);

        List<Dic> dayDatas = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            dayDatas.add(new Dic(i + "", i + 1 + ""));
        }
        dayAdapter.setItems(dayDatas);


    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @OnClick({R.id.scan_record_year_ll, R.id.scan_record_month_ll, R.id.scan_record_day_ll})
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.scan_record_year_ll:

                dropDownMenu.showSelectList(ScreenUtils.getScreenWidth(this),
                        ScreenUtils.getScreenHeight(this), yearAdapter,
                        listView, listItem, scanRecordTimebarLl, scanRecordYearTv, "year", true);

                break;
            case R.id.scan_record_month_ll:

                dropDownMenu.showSelectList(ScreenUtils.getScreenWidth(this),
                        ScreenUtils.getScreenHeight(this), monthAdapter,
                        listView, listItem, scanRecordTimebarLl, scanRecordMonthTv, "month", true);

                break;
            case R.id.scan_record_day_ll:
                dropDownMenu.showSelectList(ScreenUtils.getScreenWidth(this),
                        ScreenUtils.getScreenHeight(this), dayAdapter,
                        listView, listItem, scanRecordTimebarLl, scanRecordDayTv, "day", true);
                break;


        }

    }


}
