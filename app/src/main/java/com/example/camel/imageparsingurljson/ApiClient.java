package com.example.camel.imageparsingurljson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by camel on 1.8.2017.
 */

public class ApiClient {
    public static final String BASE_URL ="http://quocnguyen.16mb.com/";

    public static Retrofit retrofit =null;

    public static Retrofit getApiCLient(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        if(retrofit==null){
            retrofit= new Retrofit.Builder().baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create(gson))
                    .build();


        }
        return retrofit;

    }




}
