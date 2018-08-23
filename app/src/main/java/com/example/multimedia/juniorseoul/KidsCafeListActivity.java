package com.example.multimedia.juniorseoul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.multimedia.juniorseoul.Adapter.KidsCafeListAdapter;
import com.example.multimedia.juniorseoul.Classess.KidsCafeModel;
import com.example.multimedia.juniorseoul.DataHouse.StaticData;

import java.util.ArrayList;
import java.util.List;

public class KidsCafeListActivity extends AppCompatActivity {

    private List<KidsCafeModel> list = new ArrayList<KidsCafeModel>();
    private ListView listview;
    private KidsCafeListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kid_cafe_list);

        Intent intent = getIntent();
        String regionName = intent.getStringExtra("regionName");
        getStaticData(regionName);

        listview = (ListView)findViewById(R.id.kids_cafe_listview);

        adapter = new KidsCafeListAdapter();

        listview.setAdapter(adapter);

        for(int i=0; i<list.size(); i++){
            adapter.addItem(list.get(i).getName());
        }

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent_to_detail = new Intent(getApplicationContext(), KidsCafeDetailActivity.class);

                intent_to_detail.putExtra("address", list.get(position).getAddress());
                intent_to_detail.putExtra("name", list.get(position).getName());
                intent_to_detail.putExtra("phoneNum", list.get(position).getPhoneNum());
                intent_to_detail.putExtra("latitude", list.get(position).getLatitude());
                intent_to_detail.putExtra("longitude", list.get(position).getLongitude());

                startActivity(intent_to_detail);
            }
        });



    }
    public void getStaticData(String regionName){
        switch (regionName){
            case "kangnamData" :
                list =  StaticData.kangnamData;
                break;
        }
    }
}
