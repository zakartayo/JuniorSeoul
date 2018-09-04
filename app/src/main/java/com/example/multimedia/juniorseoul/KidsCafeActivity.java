package com.example.multimedia.juniorseoul;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.kakao.util.maps.helper.Utility.getPackageInfo;

public class KidsCafeActivity extends AppCompatActivity {
    private ImageView kangnam, kangdong, kangbuk, kanagseo, kwanak,
            kwangjin, kuro, keumcheon, nowon, dobong, dongdaemun,
            dongjak, mapo, seodaemun, seocho, sungdong, sungbuk,
            songpa, yangcheon, youngdeungpo, yongsan, eunpyung,
            jongro, joong, joonglang;
    private String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_cafe);

        id = getIntent().getStringExtra("id");

        kangnam = (ImageView)findViewById(R.id.kangnam);
        kangdong = (ImageView)findViewById(R.id.kangdong);
        kangbuk = (ImageView)findViewById(R.id.kangbuk);
        kwanak = (ImageView)findViewById(R.id.kwanak);
        kwangjin = (ImageView)findViewById(R.id.kwangjin);
        kuro = (ImageView)findViewById(R.id.kuro);
        keumcheon = (ImageView)findViewById(R.id.keumcheon);
        nowon = (ImageView)findViewById(R.id.nowon);
        dobong = (ImageView)findViewById(R.id.dobong);
        dongdaemun = (ImageView)findViewById(R.id.dongdaemun);
        dongjak = (ImageView)findViewById(R.id.dongjak);
        mapo = (ImageView)findViewById(R.id.mapo);
        seodaemun = (ImageView)findViewById(R.id.seodaemun);
        seocho = (ImageView)findViewById(R.id.seocho);
        sungdong = (ImageView)findViewById(R.id.sungdong);
        sungbuk = (ImageView)findViewById(R.id.sungbuk);
        songpa = (ImageView)findViewById(R.id.songpa);
        yangcheon = (ImageView)findViewById(R.id.yangcheon);
        youngdeungpo = (ImageView)findViewById(R.id.youngdeungpo);
        yongsan = (ImageView)findViewById(R.id.yongsan);
        eunpyung = (ImageView)findViewById(R.id.eunpyung);
        joong = (ImageView)findViewById(R.id.joong);
        joonglang = (ImageView)findViewById(R.id.joonglang);


    }

    public void onButtonClick(View view) {
        Intent intent = new Intent(getApplicationContext(), KidsCafeListActivity.class);
        switch (view.getId()) {
            case R.id.kangnam :
                intent.putExtra("state", "X");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.joonglang :
                intent.putExtra("state", "A");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.joong :
                intent.putExtra("state", "B");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.eunpyung :
                intent.putExtra("state", "C");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.yongsan :
                intent.putExtra("state", "D");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.youngdeungpo :
                intent.putExtra("state", "E");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.yangcheon :
                intent.putExtra("state", "F");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.songpa :
                intent.putExtra("state", "G");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.sungbuk :
                intent.putExtra("state", "H");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.sungdong :
                intent.putExtra("state", "I");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.seocho :
                intent.putExtra("state", "J");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.seodaemun :
                intent.putExtra("state", "K");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.mapo :
                intent.putExtra("state", "L");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.dongjak :
                intent.putExtra("state", "M");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.dongdaemun :
                intent.putExtra("state", "N");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.dobong :
                intent.putExtra("state", "O");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.nowon :
                intent.putExtra("state", "P");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.keumcheon :
                intent.putExtra("state", "Q");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.kuro :
                intent.putExtra("state", "R");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.kwangjin :
                intent.putExtra("state", "S");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.kwanak :
                intent.putExtra("state", "T");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.kangseo :
                intent.putExtra("state", "U");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.kangbuk :
                intent.putExtra("state", "V");
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.kangdong :
                intent.putExtra("state", "X");
                intent.putExtra("id", id);
                startActivity(intent);
                break;

        }
    }


}