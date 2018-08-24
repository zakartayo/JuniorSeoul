package com.example.multimedia.juniorseoul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

public class MuseumArtDetailActivity extends AppCompatActivity {

    private String name, address, phone_num, administration, website;
    private int adult_price, juvenile_price, kid_price;
    private double latitude, longitude;
    private boolean caseByCase;
    private TextView nameTv, addressTv, phoneNumTv,  adminTv,  websiteTv,  adultTv,  juvenileTv,  kidTv;
    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum_art_detail);

        Intent intent = getIntent();

        name = intent.getStringExtra("name");
        address = intent.getStringExtra("address");
        phone_num = intent.getStringExtra("phoneNum");
        administration = intent.getStringExtra("administration");
        website = intent.getStringExtra("webSite");
        caseByCase = intent.getBooleanExtra("caseByCase", false);
        adult_price = intent.getIntExtra("adultPrice", -1);
        juvenile_price = intent.getIntExtra("juvenilePrice", -1);
        kid_price = intent.getIntExtra("kidPrice", -1);
        latitude = intent.getDoubleExtra("latitude", 0.0);
        longitude = intent.getDoubleExtra("longitude", 0.0);

        nameTv = (TextView)findViewById(R.id.name);
        addressTv = (TextView)findViewById(R.id.address);
        phoneNumTv = (TextView)findViewById(R.id.phone);
        adminTv = (TextView)findViewById(R.id.administraion);
        websiteTv = (TextView)findViewById(R.id.website);
        adultTv = (TextView)findViewById(R.id.adult_price);
        juvenileTv = (TextView)findViewById(R.id.juvenile_price);
        kidTv = (TextView)findViewById(R.id.kid_price);

        if(caseByCase==false){
            adultTv.setText("가격 미정");
            juvenileTv.setVisibility(View.GONE);
            kidTv.setVisibility(View.GONE);

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
            phoneNumTv.setText(phone_num);
            adminTv.setText(administration);
            websiteTv.setText(website);
        }else{
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
            phoneNumTv.setText(phone_num);
            adminTv.setText(administration);
            websiteTv.setText(website);
            adultTv.setText(Integer.toString(adult_price));
            juvenileTv.setText(Integer.toString(juvenile_price));
            kidTv.setText(Integer.toString(kid_price));
        }
    }
}
