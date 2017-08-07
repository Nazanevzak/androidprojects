package com.example.camel.imageparsingurljson;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by camel on 1.8.2017.
 */

public interface ApiInterface {
    @GET("products.json")
    Call<Contact> getContacts();


}
