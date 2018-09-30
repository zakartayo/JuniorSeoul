package com.example.multimedia.juniorseoul.Fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.multimedia.juniorseoul.Adapter.DetailRecyclerAdapter;
import com.example.multimedia.juniorseoul.Classess.ParcelBitmap;
import com.example.multimedia.juniorseoul.Classess.ParcelBitmapList;
import com.example.multimedia.juniorseoul.R;

import java.util.ArrayList;

public class TabFragmentImage extends Fragment {
    private RecyclerView recyclerView;
    private ParcelBitmapList list;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<String> url_data;

    @Override
    public ViewGroup onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.tab_fragment_image, container, false);

        list = new ParcelBitmapList();
        ArrayList<ParcelBitmap> items = getArguments().getParcelableArrayList("image_datas");

        url_data = getArguments().getStringArrayList("url_data");

        for(int i=0; i<url_data.size(); i++){
            Log.d("fimg_url", url_data.get(i));
        }

        int size = items.size();

        list = (ParcelBitmapList)items;


        recyclerView = (RecyclerView) view.findViewById(R.id.image_recyclerview);
        recyclerView.setHasFixedSize(true);

        DetailRecyclerAdapter adapter = new DetailRecyclerAdapter(list, size, getActivity(), url_data);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayout.HORIZONTAL);
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setAdapter(adapter);

        return  view;
    }
}