package com.example.multimedia.juniorseoul;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

public class TnDetailActivity extends AppCompatActivity {

    private TextView trsr_gubun, gubun, k_name, c_name, description, quantitiy, address, age;
    private ImageView detail_img;
    private MapView mapView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tn_detail);

        double latitude = getIntent().getDoubleExtra("latitude", 0.0);
        double longitude = getIntent().getDoubleExtra("longitude", 0.0);

        showMap(getIntent().getStringExtra("koreanNm"), latitude, longitude);

        trsr_gubun = (TextView)findViewById(R.id.tn_detail_trsr_gubun);
        gubun = (TextView)findViewById(R.id.tn_detail_gubun);
        k_name = (TextView)findViewById(R.id.tn_detail_kname);
        c_name = (TextView)findViewById(R.id.tn_detail_cname);
        description = (TextView)findViewById(R.id.tn_detail_description);
        quantitiy = (TextView)findViewById(R.id.tn_detail_quantity);
        address = (TextView)findViewById(R.id.tn_detail_address);
        age = (TextView)findViewById(R.id.tn_detail_age);
        detail_img = (ImageView)findViewById(R.id.tn_detail_img);

        detail_img.setImageResource(getIntent().getIntExtra("img", 0));
        address.setText(getIntent().getStringExtra("address"));
        trsr_gubun.setText(getIntent().getStringExtra("trsr_gubun") + " " + getIntent().getStringExtra("number"));
        k_name.setText(getIntent().getStringExtra("koreanNm"));
        c_name.setText(" ("+getIntent().getStringExtra("chineseNm" )+ ")");
        quantitiy.setText(getIntent().getStringExtra("quantity"));
        gubun.setText(getIntent().getStringExtra("gubun"));
        age.setText(getIntent().getStringExtra("age"));

    }

    public void showMap(String name, double latitude, double longitude){
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

    }
}
