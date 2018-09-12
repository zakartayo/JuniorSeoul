package com.example.multimedia.juniorseoul.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.multimedia.juniorseoul.R;

import java.util.ArrayList;

public class TabFragmentInfo extends Fragment {
    TextView name_tv, address_tv, phonenum_tv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_fragment_info, container, false);

        ArrayList<String> info = getArguments().getStringArrayList("info");

        for(int i=0; i<info.size(); i++){
            Log.d("data_test", info.get(i));
        }

        name_tv = (TextView) view.findViewById(R.id.name_tv);
        address_tv = (TextView) view.findViewById(R.id.address_tv);
        phonenum_tv = (TextView) view.findViewById(R.id.phone_tv);

        name_tv.setText(info.get(0));
        address_tv.setText(info.get(1));
        phonenum_tv.setText(info.get(2));

        return view;
    }
}
