package com.android.jsontraining2;

import com.android.jsontraining2.jsonpack.json;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterfaceadapter {
    @GET("api/get_review/1")
    Call<List<json>> getMenu();
}