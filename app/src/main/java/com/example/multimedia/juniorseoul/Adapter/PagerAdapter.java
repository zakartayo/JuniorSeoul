package com.example.multimedia.juniorseoul.Adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.example.multimedia.juniorseoul.Classess.ParcelBitmapList;
import com.example.multimedia.juniorseoul.Classess.ReplyList;
import com.example.multimedia.juniorseoul.Fragment.TabFragmentImage;
import com.example.multimedia.juniorseoul.Fragment.TabFragmentInfo;
import com.example.multimedia.juniorseoul.Fragment.TabFragmentReply;

import java.util.ArrayList;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    ArrayList<String> info = null;
    ParcelBitmapList list = new ParcelBitmapList();
    ArrayList<ReplyList> replyList = null;
    ArrayList<String> replyIdList, replyContentList, replyDateList;

    public PagerAdapter(FragmentManager fm, int NumOfTabs, ArrayList<String> info, ParcelBitmapList list, ArrayList<ReplyList> replyList) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.info = info;
        this.list = list;
        this.replyList = replyList;

        replyIdList = new ArrayList<String>();
        replyContentList = new ArrayList<String>();
        replyDateList = new ArrayList<String>();


        for(int i=0; i<replyList.size(); i++){
           replyIdList.add(replyList.get(i).getId());
            replyContentList.add(replyList.get(i).getContent());
            replyDateList.add(replyList.get(i).getDate());
        }
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabFragmentInfo tab1 = new TabFragmentInfo();
                Bundle bundle = new Bundle(1);
                bundle.putStringArrayList("info", info);
                tab1.setArguments(bundle);

                return tab1;
            case 1:
                TabFragmentImage tab2 = new TabFragmentImage();
                Bundle bundle1 = new Bundle(2);
                bundle1.putParcelableArrayList("image_datas",list);
                Log.d("이미지 번들", "이미지 번들");
                tab2.setArguments(bundle1);

                return tab2;
            case 2:
                TabFragmentReply tab3 = new TabFragmentReply();
                Bundle bundle2 = new Bundle(3);
                bundle2.putStringArrayList("replyIdList", replyIdList);
                bundle2.putStringArrayList("replyContentList", replyContentList);
                bundle2.putStringArrayList("replyDateList", replyDateList);

                tab3.setArguments(bundle2);
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
