package com.example.multimedia.juniorseoul.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.multimedia.juniorseoul.Adapter.ReplyListAdapter;
import com.example.multimedia.juniorseoul.R;

import java.util.ArrayList;

public class TabFragmentReply  extends Fragment {
    private ListView listView;
    private ReplyListAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_fragment_reply, container, false);

        ArrayList<String> replyIdList = getArguments().getStringArrayList("replyIdList");
        ArrayList<String> replyContentList = getArguments().getStringArrayList("replyContentList");
        ArrayList<String> replyDateList = getArguments().getStringArrayList("replyDateList");

        listView = (ListView)view.findViewById(R.id.reply_listview);
        adapter = new ReplyListAdapter();

        listView.setAdapter(adapter);

        for(int i=0; i<replyIdList.size(); i++){
            adapter.addItem(replyIdList.get(i), replyContentList.get(i), replyDateList.get(i));
            Log.d("datedata", replyDateList.get(i));
        }
        return view;
    }
}
