package com.example.multimedia.juniorseoul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import kr.go.seoul.airquality.AirQualityButtonTypeA;

public class MainActivity extends AppCompatActivity {
    private AirQualityButtonTypeA typeAbtn;
    private String openApiKey = "4852536450646c6738336c4e7a7a50";
    private ImageView kidsCafe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        typeAbtn = (AirQualityButtonTypeA )findViewById(R.id.typeAbtn);
        typeAbtn.setOpenAPIKey(openApiKey);
        typeAbtn.setButtonImage(R.drawable.weather_check_img);

        kidsCafe = (ImageView)findViewById(R.id.kids_cafe);

        kidsCafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), KidsCafeActivity.class);
                startActivity(intent);
            }
        });
    }
}
