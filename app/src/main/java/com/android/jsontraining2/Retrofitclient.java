package com.android.jsontraining2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofitclient {
    public static Retrofit retrofit=null;
    public static Retrofit getRetrofit(){
        if(retrofit ==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl("http://clients.crystalinfosys.com/restroApp/public/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}