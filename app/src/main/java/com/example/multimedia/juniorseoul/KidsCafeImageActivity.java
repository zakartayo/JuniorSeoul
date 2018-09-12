package com.example.multimedia.juniorseoul;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class KidsCafeImageActivity extends AppCompatActivity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_cafe_image);

        byte[] bytes = getIntent().getByteArrayExtra("bitmap");
        Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

        img = (ImageView)findViewById(R.id.detail_image);

        img.setImageBitmap(bmp);
        PhotoViewAttacher mAttacher = new PhotoViewAttacher(img);

    }
}
