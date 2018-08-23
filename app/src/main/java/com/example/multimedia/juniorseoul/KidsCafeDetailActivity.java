package com.example.multimedia.juniorseoul;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.multimedia.juniorseoul.Classess.KidsCafeModel;
import com.example.multimedia.juniorseoul.DataHouse.StaticData;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static com.example.multimedia.juniorseoul.DataHouse.StaticData.kangnamData;
import static com.kakao.util.maps.helper.Utility.getPackageInfo;

public class KidsCafeDetailActivity extends AppCompatActivity {
    private MapView mapView;
    private TextView nameTv, addressTv, phoneNumTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_cafe_detail);

        nameTv = (TextView)findViewById(R.id.kids_cafe_name);
        addressTv = (TextView)findViewById(R.id.kids_cafe_address);
        phoneNumTv = (TextView)findViewById(R.id.kids_cafe_phone);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String address = intent.getStringExtra("address");
        String phoneNum = intent.getStringExtra("phoneNum");
        double latitude = intent.getDoubleExtra("latitude", 0.0);
        double longitude = intent.getDoubleExtra("longitude", 0.0);

        showMap(name, address, phoneNum, latitude, longitude);

    }
    public void showMap(String name, String address, String phoneNum, double latitude, double longitude){
        Log.d("hashkey", getKeyHash(this));
        mapView = new MapView(this);
        mapView.setDaumMapApiKey("1e10c6bb9dc91481b02f90ccc00f2e21");
        RelativeLayout container = (RelativeLayout) findViewById(R.id.map_view);

        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(latitude, longitude), true);
        mapView.setZoomLevel(3, true);

        MapPOIItem marker = new MapPOIItem();
        marker.setItemName(name);
        marker.setTag(0);
        marker.setMapPoint(MapPoint.mapPointWithGeoCoord(latitude, longitude));
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        mapView.addPOIItem(marker);

        container.addView(mapView);

        nameTv.setText(name);
        addressTv.setText(address);
        phoneNumTv.setText(phoneNum);

    }

    public static String getKeyHash(final Context context) {
        PackageInfo packageInfo = getPackageInfo(context, PackageManager.GET_SIGNATURES);
        if (packageInfo == null)
            return null;

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                return android.util.Base64.encodeToString(md.digest(), android.util.Base64.NO_WRAP);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
