package com.scrollablelayout.simple;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scrollablelayout.ScrollableLayout;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, PtrHandler, View.OnClickListener {

    private PtrClassicFrameLayout pfl_root;
    private ScrollableLayout sl_root;
    private ViewPager vp_scroll;
    private TextView tv_title;
    private TextView tv_right;
    private ImageView iv_spit;
    private TextView tv_name;
    private TextView tv_signature;
    private ImageView iv_avatar;
    private RelativeLayout ly_page1;
    private TextView tv_page1;
    private RelativeLayout ly_page2;
    private TextView tv_page2;

    private float titleMaxScrollHeight;
    private float hearderMaxHeight;
    private float avatarTop;
    private float maxScrollHeight;
    private final List<BaseFragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        pfl_root = (PtrClassicFrameLayout) findViewById(R.id.pfl_root);
        sl_root = (ScrollableLayout) findViewById(R.id.sl_root);
        vp_scroll = (ViewPager) findViewById(R.id.vp_scroll);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_right = (TextView) findViewById(R.id.tv_right);
        iv_spit = (ImageView) findViewById(R.id.iv_spit);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_signature = (TextView) findViewById(R.id.tv_signature);
        iv_avatar = (ImageView) findViewById(R.id.iv_avatar);

        ly_page1 = (RelativeLayout) findViewById(R.id.ly_page1);
        tv_page1 = (TextView) findViewById(R.id.tv_page1);
        ly_page2 = (RelativeLayout) findViewById(R.id.ly_page2);
        tv_page2 = (TextView) findViewById(R.id.tv_page2);

        iv_spit.setVisibility(View.GONE);
        tv_title.setTranslationY(-1000);
        sl_root.setDamping(true);
        sl_root.computeScroll();
        sl_root.setOnScrollListener(new ScrollableLayout.OnScrollListener() {
            @Override
            public void onScroll(int translationY, int maxY) {
                Log.d("onScroll",translationY+"/"+maxY);
                translationY = -translationY;
                if (titleMaxScrollHeight == 0) {
                    //头部bar的高度
                    titleMaxScrollHeight = ((View) tv_title.getParent()).getBottom() - tv_title.getTop();
                    maxScrollHeight = hearderMaxHeight + titleMaxScrollHeight;
                }
                if (hearderMaxHeight == 0) {
                    hearderMaxHeight = tv_name.getTop();
                    maxScrollHeight = hearderMaxHeight + titleMaxScrollHeight;
                }
                if (avatarTop == 0) {
                    avatarTop = iv_avatar.getTop();
                }

                int alpha = 0;
                int baseAlpha = 60;
                if (0 > avatarTop + translationY) {
                    alpha = Math.min(255, (int) (Math.abs(avatarTop + translationY) * (255 - baseAlpha) / (hearderMaxHeight - avatarTop) + baseAlpha));
                    iv_spit.setVisibility(View.VISIBLE);
                } else {
                    iv_spit.setVisibility(View.GONE);
                }
                if (-translationY < hearderMaxHeight) {
                    iv_avatar.setScaleX((hearderMaxHeight+translationY)/hearderMaxHeight);
                    iv_avatar.setScaleY((hearderMaxHeight+translationY)/hearderMaxHeight);
                }

                iv_spit.getBackground().setAlpha(alpha);

                tv_title.setTranslationY(Math.max(0, maxScrollHeight + translationY));
            }
        });

        pfl_root.setPullToRefresh(false);
        pfl_root.setEnabledNextPtrAtOnce(true);
        pfl_root.setLastUpdateTimeRelateObject(this);
        pfl_root.setPtrHandler(this);
        pfl_root.setKeepHeaderWhenRefresh(true);

        CommonFragementPagerAdapter commonFragementPagerAdapter = new CommonFragementPagerAdapter(getSupportFragmentManager());
        fragmentList.add(RecyclerViewSimpleFragment.newInstance());
        fragmentList.add(RecyclerViewGridSimpleFragment.newInstance());
        vp_scroll.setAdapter(commonFragementPagerAdapter);
        vp_scroll.addOnPageChangeListener(this);
        sl_root.getHelper().setCurrentScrollableContainer(fragmentList.get(0));

        tv_right.setOnClickListener(this);
        tv_signature.setOnClickListener(this);
        ly_page1.setOnClickListener(this);
        ly_page2.setOnClickListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

    @Override
    public void onPageSelected(int position) {
        sl_root.getHelper().setCurrentScrollableContainer(fragmentList.get(position));
        if (position == 0) {
            ly_page1.setBackgroundResource(R.drawable.rectangle_left_select);
            tv_page1.setTextColor(Color.parseColor("#ffffff"));
            ly_page2.setBackgroundResource(R.drawable.rectangle_right);
            tv_page2.setTextColor(Color.parseColor("#435356"));
        } else {
            ly_page1.setBackgroundResource(R.drawable.rectangle_left);
            tv_page1.setTextColor(Color.parseColor("#435356"));
            ly_page2.setBackgroundResource(R.drawable.rectangle_right_select);
            tv_page2.setTextColor(Color.parseColor("#ffffff"));
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) { }

    @Override
    public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
        if (vp_scroll.getCurrentItem() == 0 && sl_root.isCanPullToRefresh()) {
            return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
        }
        return false;
    }

    @Override
    public void onRefreshBegin(PtrFrameLayout frame) {
        if (fragmentList.size() > vp_scroll.getCurrentItem()) {
            fragmentList.get(vp_scroll.getCurrentItem()).pullToRefresh();
        }
    }

    public void refreshComplete() {
        if (pfl_root != null) {
            pfl_root.refreshComplete();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_signature:
                Uri uri = Uri.parse(tv_signature.getText().toString());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.tv_right:
                startActivity(new Intent(MainActivity.this, TestActivity.class));
                break;
            case R.id.ly_page1:
                vp_scroll.setCurrentItem(0);
                break;
            case R.id.ly_page2:
                vp_scroll.setCurrentItem(1);
                break;
        }
    }

    public class CommonFragementPagerAdapter extends FragmentPagerAdapter {

        public CommonFragementPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return getCount() > position ? fragmentList.get(position) : null;
        }

        @Override
        public int getCount() {
            return fragmentList == null ? 0 : fragmentList.size();
        }
    }
}
