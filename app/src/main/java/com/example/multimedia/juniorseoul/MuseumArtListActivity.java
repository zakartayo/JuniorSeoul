package com.example.multimedia.juniorseoul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.multimedia.juniorseoul.Adapter.KidsCafeListAdapter;
import com.example.multimedia.juniorseoul.Adapter.MuseumArtListAdapter;
import com.example.multimedia.juniorseoul.Classess.ArtModel;
import com.example.multimedia.juniorseoul.Classess.MemorialModel;
import com.example.multimedia.juniorseoul.Classess.MuseumModel;
import com.example.multimedia.juniorseoul.DataHouse.StaticData;

import java.util.List;

public class MuseumArtListActivity extends AppCompatActivity {

    private int which_data;
    private ListView listview;
    private MuseumArtListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum_art_list);

        Intent intent = getIntent();
        which_data = intent.getIntExtra("which_data", -1);

        listview = (ListView)findViewById(R.id.museum_art_listview);

        adapter = new MuseumArtListAdapter();

        listview.setAdapter(adapter);

        switch (which_data){
            case 0:
                final List<MuseumModel> museum_list = StaticData.museumDatas;

                for(int i=0; i<museum_list.size(); i++){
                    adapter.addItem(museum_list.get(i).getMuseumName());

                    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                            Intent intent_to_detail = new Intent(getApplicationContext(), MuseumArtDetailActivity.class);

                            intent_to_detail.putExtra("address", museum_list.get(position).getAddress());
                            intent_to_detail.putExtra("name", museum_list.get(position).getMuseumName());
                            intent_to_detail.putExtra("phoneNum", museum_list.get(position).getPhoneNum());
                            intent_to_detail.putExtra("latitude", museum_list.get(position).getLatitude());
                            intent_to_detail.putExtra("longitude", museum_list.get(position).getLongitude());
                            intent_to_detail.putExtra("administration", museum_list.get(position).getAdministration());
                            intent_to_detail.putExtra("webSite", museum_list.get(position).getWebSite());
                            intent_to_detail.putExtra("caseByCase", museum_list.get(position).isCaseByCase());
                            intent_to_detail.putExtra("adultPrice", museum_list.get(position).getAdultPrice());
                            intent_to_detail.putExtra("juvenilePrice", museum_list.get(position).getJuvenilePrice());
                            intent_to_detail.putExtra("kidPrice", museum_list.get(position).getKidPrice());

                            startActivity(intent_to_detail);
                        }
                    });
                }
                break;

            case 1:
                final List<ArtModel> art_list = StaticData.artDatas;

                for(int i=0; i<art_list.size(); i++){
                    adapter.addItem(art_list.get(i).getArtName());

                    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                            Intent intent_to_detail = new Intent(getApplicationContext(), MuseumArtDetailActivity.class);

                            intent_to_detail.putExtra("address", art_list.get(position).getAddress());
                            intent_to_detail.putExtra("name", art_list.get(position).getArtName());
                            intent_to_detail.putExtra("phoneNum", art_list.get(position).getPhoneNum());
                            intent_to_detail.putExtra("latitude", art_list.get(position).getLatitude());
                            intent_to_detail.putExtra("longitude", art_list.get(position).getLongitude());
                            intent_to_detail.putExtra("administration", art_list.get(position).getAdministration());
                            intent_to_detail.putExtra("webSite", art_list.get(position).getWebSite());
                            intent_to_detail.putExtra("caseByCase", art_list.get(position).isCaseByCase());
                            intent_to_detail.putExtra("adultPrice", art_list.get(position).getAdultPrice());
                            intent_to_detail.putExtra("juvenilePrice", art_list.get(position).getJuvenilePrice());
                            intent_to_detail.putExtra("kidPrice", art_list.get(position).getKidPrice());

                            startActivity(intent_to_detail);
                        }
                    });
                }
                break;

            case 2:
                final List<MemorialModel> memorial_list = StaticData.memorialDatas;

                for(int i=0; i<memorial_list.size(); i++){
                    adapter.addItem(memorial_list.get(i).getMemorialName());

                    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                            Intent intent_to_detail = new Intent(getApplicationContext(), MuseumArtDetailActivity.class);

                            intent_to_detail.putExtra("address", memorial_list.get(position).getAddress());
                            intent_to_detail.putExtra("name", memorial_list.get(position).getMemorialName());
                            intent_to_detail.putExtra("phoneNum", memorial_list.get(position).getPhoneNum());
                            intent_to_detail.putExtra("latitude", memorial_list.get(position).getLatitude());
                            intent_to_detail.putExtra("longitude", memorial_list.get(position).getLongitude());
                            intent_to_detail.putExtra("administration", memorial_list.get(position).getAdministration());
                            intent_to_detail.putExtra("webSite", memorial_list.get(position).getWebSite());
                            intent_to_detail.putExtra("caseByCase", memorial_list.get(position).isCaseByCase());
                            intent_to_detail.putExtra("adultPrice", memorial_list.get(position).getAdultPrice());
                            intent_to_detail.putExtra("juvenilePrice", memorial_list.get(position).getJuvenilePrice());
                            intent_to_detail.putExtra("kidPrice", memorial_list.get(position).getKidPrice());

                            startActivity(intent_to_detail);
                        }
                    });
                }
                break;
        }

    }
}
