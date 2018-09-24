package com.example.multimedia.juniorseoul.Classess;

import com.example.multimedia.juniorseoul.Interface.KidsCafeImageApiService;
import com.example.multimedia.juniorseoul.Interface.KidsCafeListApiService;
import com.example.multimedia.juniorseoul.Interface.KidsCafeReplyApiService;
import com.example.multimedia.juniorseoul.Interface.MuseumArtApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static final String KIDS_CAFE_URL = "http://218.148.183.226:20000/";

    private static Retrofit getKidsCafeListInstance(){
        return new Retrofit.Builder()
                .baseUrl(KIDS_CAFE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static Retrofit getKidsCafeImageInstance(){
        return new Retrofit.Builder()
                .baseUrl(KIDS_CAFE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static Retrofit getKidsCafeReplyInstance(){
        return new Retrofit.Builder()
                .baseUrl(KIDS_CAFE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static Retrofit getMuseumArtInstance(){
        return new Retrofit.Builder()
                .baseUrl(KIDS_CAFE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static KidsCafeListApiService getListApiService(){
        return getKidsCafeListInstance().create(KidsCafeListApiService.class);
    }

    public static KidsCafeImageApiService getImageApiService(){
        return getKidsCafeImageInstance().create(KidsCafeImageApiService.class);
    }

    public static KidsCafeReplyApiService getReplyApiService(){
        return getKidsCafeReplyInstance().create(KidsCafeReplyApiService.class);
    }
    public static MuseumArtApiService getMuseumArtApiService(){
        return getMuseumArtInstance().create(MuseumArtApiService.class);
    }
}
