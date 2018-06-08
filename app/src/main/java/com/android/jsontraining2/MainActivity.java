package com.android.jsontraining2;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.jsontraining2.jsonpack.json;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recycling);
        progressDialog=new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading.......");
        progressDialog.setCancelable(false);
        progressDialog.show();
        getMenuJson();
    }
    public void getMenuJson() {
        RetrofitInterfaceadapter retrofitInterfaceadapter = Retrofitclient.getRetrofit().create(RetrofitInterfaceadapter.class);
        Call<List<json>>jsonpack = retrofitInterfaceadapter.getMenu();
        jsonpack.enqueue(new Callback<List<json>>() {
            @Override
            public void onResponse(Call<List<json>> call, Response<List<json>> response) {
                List<json>jsoninternal  = response.body();
                Recycleviewadapter recycleviewadapter = new Recycleviewadapter(MainActivity.this, jsoninternal);
              //  Recycleviewadapter recycleviewadapter1= new Recycleviewadapter(MainActivity.this, response.body());
                RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 2);
              // LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(recycleviewadapter);
                recycleviewadapter.notifyDataSetChanged();

                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();

                }

            }

            @Override
            public void onFailure(Call<List<json>> call, Throwable t) {

            }
        });
    }
    }
