package com.example.multimedia.juniorseoul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.multimedia.juniorseoul.Adapter.TreasureListAdapter;
import com.example.multimedia.juniorseoul.Classess.NTImgModel;
import com.example.multimedia.juniorseoul.Classess.NationalTreasure;
import com.example.multimedia.juniorseoul.Classess.NationalTreasureList;
import com.example.multimedia.juniorseoul.Classess.ServiceGenerator;
import com.example.multimedia.juniorseoul.DataHouse.StaticData;
import com.example.multimedia.juniorseoul.Interface.NationalTreasureApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TnListActivity extends AppCompatActivity {
    private ArrayList<NationalTreasureList> nationalTreasureList;
    private int count;
    private ListView listView;
    private TreasureListAdapter adapter;
    private List<NTImgModel> imgList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tn_list);

        String whichData = getIntent().getStringExtra("whichData");
        String state = getIntent().getStringExtra("state");
        listView = (ListView)findViewById(R.id.tn_listview);
        adapter = new TreasureListAdapter();

        if(whichData.equals("nationalT")){

            setNationalTreasureListAPI(state);

        }else if(whichData.equals("T")){

        }
    }
    public void setNationalTreasureListAPI(final String state){
        NationalTreasureApiService api = ServiceGenerator.getNationalTreasureApiService();

        Call<NationalTreasure> call = api.getNationalTreasure(state);

        call.enqueue(new Callback<NationalTreasure>() {
            @Override
            public void onResponse(Call<NationalTreasure> call, Response<NationalTreasure> response) {

                if (response.isSuccessful()) {
                    nationalTreasureList = response.body().getNationalTreasureList();
                    listView.setAdapter(adapter);

                    switch (state){
                        case"B":
                            imgList = StaticData.ntJoongu;
                            dataInit();

                            break;
                        case"D":
                            imgList = StaticData.ntYongsan;
                            dataInit();

                            break;
                        case"H":
                            imgList = StaticData.ntSungbuk;
                            dataInit();

                            break;
                        case"J":
                            imgList = StaticData.ntSeocho;
                            dataInit();

                            break;
                        case"K":
                            imgList = StaticData.ntSeodaemun;
                            dataInit();

                            break;
                        case"M":
                            imgList = StaticData.ntDongjak;
                            dataInit();

                            break;
                        case"S":
                            imgList = StaticData.ntKwangjin;
                            dataInit();

                            break;
                        case"T":
                            imgList = StaticData.ntKwanak;
                            dataInit();

                            break;
                        case"X":
                            imgList = StaticData.ntKangnam;
                            dataInit();

                            break;
                        case"Y":
                            imgList = StaticData.ntJongro;
                            dataInit();

                            break;
                    }


                }
            }


            @Override
            public void onFailure(Call<NationalTreasure> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "서버가 꺼져있습니다", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
    public void dataInit(){
        for (count = 0; count < nationalTreasureList.size(); count++) {

            if(nationalTreasureList.get(count).getAge()==null){
                if(nationalTreasureList.get(count).getChineseNm()==null){
                    adapter.addItem(imgList.get(count).getImg(),nationalTreasureList.get(count).getKoreanNm(), "", "시대미상", nationalTreasureList.get(count).getNumber());
                }else{
                    adapter.addItem(imgList.get(count).getImg(),nationalTreasureList.get(count).getKoreanNm(), nationalTreasureList.get(count).getChineseNm(), "시대미상", nationalTreasureList.get(count).getNumber());
                }

            }else{
                if(nationalTreasureList.get(count).getChineseNm()==null){
                    adapter.addItem(imgList.get(count).getImg(),nationalTreasureList.get(count).getKoreanNm(), "", nationalTreasureList.get(count).getAge(), nationalTreasureList.get(count).getNumber());
                }else{
                    adapter.addItem(imgList.get(count).getImg(),nationalTreasureList.get(count).getKoreanNm(), nationalTreasureList.get(count).getChineseNm(), nationalTreasureList.get(count).getAge(), nationalTreasureList.get(count).getNumber());
                }
            }
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), TnDetailActivity.class);

                intent.putExtra("img", imgList.get(i).getImg());
                intent.putExtra("address", nationalTreasureList.get(i).getAddress());

                if(nationalTreasureList.get(i).getAge()==null){
                    intent.putExtra("age", "시대미상");
                }else{
                    intent.putExtra("age", nationalTreasureList.get(i).getAge());
                }

                if(nationalTreasureList.get(i).getChineseNm()==null){
                    intent.putExtra("chineseNm", "");
                }else{
                    intent.putExtra("chineseNm", nationalTreasureList.get(i).getChineseNm());
                }
                intent.putExtra("koreanNm", nationalTreasureList.get(i).getKoreanNm());
                intent.putExtra("gubun", nationalTreasureList.get(i).getGubun());
                intent.putExtra("id", nationalTreasureList.get(i).getId());
                intent.putExtra("latitude", nationalTreasureList.get(i).getLatitude());
                intent.putExtra("longitude", nationalTreasureList.get(i).getLongitude());
                intent.putExtra("latitude", Double.parseDouble(nationalTreasureList.get(i).getLatitude()));
                intent.putExtra("longitude", Double.parseDouble(nationalTreasureList.get(i).getLongitude()));
                intent.putExtra("number", nationalTreasureList.get(i).getNumber());
                intent.putExtra("quantity", nationalTreasureList.get(i).getQuantity());
                intent.putExtra("state", nationalTreasureList.get(i).getState());
                intent.putExtra("trsr_gubun", nationalTreasureList.get(i).getTrsr_gubun());

                startActivity(intent);
            }
        });
    }
}
