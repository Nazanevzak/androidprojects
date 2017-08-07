package com.example.camel.imageparsingurljson;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ItemsActivity extends AppCompatActivity {
    private Context context;
    public String[] indirim = {"%20", "%30", "%40", "%50", "%60", "%25", "%35", "%10"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        Intent i = getIntent();
        TextView rowid = (TextView) findViewById(R.id.rowTv);
        String name = i.getStringExtra("data");
        if (name == null) {
            rowid.setVisibility(View.GONE);

        } else
            rowid.setText(name);


        TextView rowprice = (TextView) findViewById(R.id.rowTv2);
        String price = i.getStringExtra("data2");
        if (price == null) {
            rowprice.setVisibility(View.GONE);
        }
        int position = i.getIntExtra("position", -1);
        if (position == -1) {
            rowprice.setVisibility(View.GONE);

        } else
            rowprice.setText(price + " " + indirim[position] + " " + "indirimli");


        ImageView rowimage = (ImageView) findViewById(R.id.img2);
        String url2 = i.getStringExtra("data3");
        if (url2 == null) {
            rowimage.setVisibility(View.GONE);
        } else
            Picasso.with(context)
                    .load(url2)
                    .into(rowimage);

    }
}