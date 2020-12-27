package com.project.music;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.project.lib_common_ui.base.BaseActivity;
import com.project.music.adapter.HomePagerAdapter;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.project.music.model.CHANNEL;
public class HomeActivity extends BaseActivity {
    private static final CHANNEL[] CHANNELS = new CHANNEL[]{CHANNEL.MY, CHANNEL.DISCORY, CHANNEL.FRIEND};
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        this.initView();

    }

    public void initView(){

        this.viewPager.setAdapter( new HomePagerAdapter(getSupportFragmentManager(),CHANNELS));
        this.tabLayout.setupWithViewPager(this.viewPager);

    }
}