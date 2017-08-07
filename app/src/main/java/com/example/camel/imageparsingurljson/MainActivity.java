package com.example.camel.imageparsingurljson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter recyclerAdapter;
    private List<Contact.Details> contacts;
    private ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        apiInterface = ApiClient.getApiCLient().create(ApiInterface.class);
        Call<Contact> call = apiInterface.getContacts();
        call.enqueue(new Callback<Contact>() {
            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {
                contacts = response.body().getProducts();
                RecyclerAdapter adapter = new RecyclerAdapter(contacts, MainActivity.this);
                RecyclerAdapter.Tikla a = new RecyclerAdapter.Tikla() {


                    @Override
                    public void idClick(String id) {

                    }

                    @Override
                    public void nameClick(String name,String price,int position) {
                        Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
                        Intent i =  new Intent(MainActivity.this,ItemsActivity.class);
                        i.putExtra("data",name);
                        i.putExtra("data2",price);
                        i.putExtra("position",position);
                        startActivity(i);
                    }

                    @Override
                    public void priceClick(String price,int position) {
                        Intent i = new Intent (MainActivity.this,ItemsActivity.class);
                        i.putExtra("data2",price);
                        i.putExtra("position",position);
                        startActivity(i);
                    }
                    @Override
                    public void imageClick(String url) {
                        Intent c = new Intent (MainActivity.this,ItemsActivity.class);
                        c.putExtra("data3",url);
                        startActivity(c);


                    }
                };
                //Toast.makeText(MainActivity.this, contacts.get(0).getProducts().get(0).getName(), Toast.LENGTH_LONG).show();
                adapter.setTikla(a);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Contact> call, Throwable t) {
                Log.e("AMG", "onFailure: "+ t.getMessage() );
            }
        });



    }
}
