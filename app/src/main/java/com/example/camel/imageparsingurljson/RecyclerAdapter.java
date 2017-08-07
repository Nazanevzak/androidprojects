package com.example.camel.imageparsingurljson;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by camel on 1.8.2017.
 */


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private List<Contact.Details> contacts;
    private Context context;
    public Tikla tikla;


    public RecyclerAdapter(List<Contact.Details>contacts,Context context){
        this.contacts=contacts;
        this.context=context;

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.id.setText(String.valueOf(contacts.get(position).getId()));
        holder.name.setText(contacts.get(position).getName());
        holder.price.setText(String.valueOf(contacts.get(position).getPrice()));
        holder.url = contacts.get(position).getImage();

        Picasso.with(context)
                .load(holder.url)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        Log.e("AMG", "getItemCount: " + contacts.size() );
        return contacts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView id,name,price;
        ImageView imageView;
        LinearLayout linearLayout;
        String url;


        public MyViewHolder(View itemView) {
            super(itemView);
            id = (TextView)itemView.findViewById(R.id.id1);
            name= (TextView)itemView.findViewById(R.id.name1);
            price=(TextView)itemView.findViewById(R.id.price1);
            imageView=(ImageView)itemView.findViewById(R.id.img1);
            linearLayout=(LinearLayout)itemView.findViewById(R.id.mainlayout);
            itemView.setClickable(true);
            itemView.setFocusableInTouchMode(true);

            id.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tikla.idClick(id.getText().toString());
                }
            });
            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tikla.nameClick(name.getText().toString(),price.getText().toString(),getAdapterPosition());
                }
            });
            price.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tikla.priceClick(price.getText().toString(), getAdapterPosition());
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tikla.imageClick(url);
                }
            });


        }
    }

    interface Tikla {
        void idClick(String id);

        void nameClick(String name,String price,int position);

        void priceClick(String price, int position);

        void imageClick(String url);
    }

    public void setTikla(Tikla tikla) {
        this.tikla = tikla;
    }

}
