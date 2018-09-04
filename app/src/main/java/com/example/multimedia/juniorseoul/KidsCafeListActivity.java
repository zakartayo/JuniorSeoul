package com.example.multimedia.juniorseoul;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.multimedia.juniorseoul.Adapter.KidsCafeListAdapter;
import com.example.multimedia.juniorseoul.Classess.CafeList;
import com.example.multimedia.juniorseoul.Classess.KidsCafe;
import com.example.multimedia.juniorseoul.Classess.KidsCafeListItem;
import com.example.multimedia.juniorseoul.Classess.KidsCafeModel;
import com.example.multimedia.juniorseoul.Classess.ServiceGenerator;
import com.example.multimedia.juniorseoul.DataHouse.StaticData;
import com.example.multimedia.juniorseoul.Interface.KidsCafeListApiService;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;

public class KidsCafeListActivity extends AppCompatActivity {

    private List<KidsCafeListItem> list = new ArrayList<KidsCafeListItem>();
    private ListView listview;
    private KidsCafeListAdapter adapter;
    private List<String> test  = new ArrayList<String>();
    private ArrayList<CafeList> cafeList;
    private static final String KIDS_CAFE_URL = "http://218.148.183.226:20000";
    private int count;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kid_cafe_list);

        setKidsCafeListAPI("A");
        progressDialog = new ProgressDialog(KidsCafeListActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("진행중...");
        progressDialog.show();

        Intent intent = getIntent();
        String state = intent.getStringExtra("state");
        String id = intent.getStringExtra("id");

    }
    private void setKidsCafeListAPI(String state){

        KidsCafeListApiService api = ServiceGenerator.getListApiService();

        Call<KidsCafe> call = api.getKidsCafeList(state);

        call.enqueue(new Callback<KidsCafe>() {
            @Override
            public void onResponse(Call<KidsCafe> call, Response<KidsCafe> response) {

                if(response.isSuccessful()){
                    cafeList = response.body().getCafeList();

                    for(count=0; count<cafeList.size(); count++){
                        Log.d("address", cafeList.get(count).getAddress());
                        Log.d("latitude", cafeList.get(count).getLatitude());
                        Log.d("longitude", cafeList.get(count).getLongitude());
                        Log.d("name", cafeList.get(count).getName());
                        Log.d("tell", cafeList.get(count).getTel());
                        Log.d("rating", String.valueOf(cafeList.get(count).getRating()));
                        Log.d("image_url", String.valueOf(cafeList.get(count).getImage_url()));

                        list.add(new KidsCafeListItem(cafeList.get(count).getName(), (float)cafeList.get(count).getRating()));
                        cafeList.get(count).setImage_url(cafeList.get(count).getImage_url().replace("JPG", "jpg"));
                        test.add(KIDS_CAFE_URL+cafeList.get(count).getImage_url());

                        Thread mThread = new Thread(){
                            @Override
                            public void run(){
                                try{
                                    URL url = new URL(test.get(count));

                                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                                    conn.setDoInput(true);
                                    conn.connect();

                                    InputStream is = conn.getInputStream();

                                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                                    list.get(count).setBitmap(bitmap);


                                }catch (MalformedURLException e){
                                    e.printStackTrace();
                                }catch (IOException e){
                                    e.printStackTrace();
                                }

                            }
                        };

                        mThread.start();

                        try{
                            mThread.join();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }

                    }

                    listview = (ListView)findViewById(R.id.kids_cafe_listview);

                    adapter = new KidsCafeListAdapter();

                    listview.setAdapter(adapter);

                    for(int i=0; i<list.size(); i++){
                        adapter.addItem(list.get(i).getName(), list.get(i).getRate(), list.get(i).getBitmap());
                    }

                    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                        }
                    });
                    progressDialog.dismiss();
                }
                else{
                    Toast.makeText(getApplicationContext(),"response fail", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<KidsCafe> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"onFailure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
