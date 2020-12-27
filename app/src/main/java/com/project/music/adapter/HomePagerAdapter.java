package com.project.music.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.project.music.model.CHANNEL;
import com.project.music.views.discory.DiscoryFragment;
import com.project.music.views.friend.FriendFragment;
import com.project.music.views.mine.MineFragment;

//FragmentPagerAdapter  PagerAdapter 的区别
public class HomePagerAdapter extends FragmentPagerAdapter {
    private CHANNEL[] mList;

    public HomePagerAdapter(@NonNull FragmentManager fm, CHANNEL[] list) {
        super(fm);
        mList = list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        //滑动到哪一页加载哪一页数据
        int type = mList[position].getValue();
        switch (type) {
            case CHANNEL.MINE_ID:
                return MineFragment.newInstance();
            case CHANNEL.DISCORY_ID:
                return DiscoryFragment.newInstance();
            case CHANNEL.FRIEND_ID:
                return FriendFragment.newInstance();
        }
        return FriendFragment.newInstance();
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        int type = mList[position].getValue();
        switch (type) {
            case CHANNEL.MINE_ID:
                return "我的";
            case CHANNEL.DISCORY_ID:
                return "发现";
            case CHANNEL.FRIEND_ID:
                return "朋友";
        }
        return "朋友";
    }
}
