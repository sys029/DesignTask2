package com.example.mygreenthumb;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemRecyclerAdapter  extends RecyclerView.Adapter<ItemRecyclerAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Product> mData ;


    public ItemRecyclerAdapter(Context mContext, List<Product> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_product,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv_product_price.setText(mData.get(position).getPrice());
        holder.tv_product_title.setText(mData.get(position).getTitle());
        holder.img_product_thumbnail.setImageResource(mData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,DetailActivity.class);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_product_title;
        TextView tv_product_price;
        ImageView img_product_thumbnail;
        CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_product_title = (TextView) itemView.findViewById(R.id.product_title_id) ;
            tv_product_price = (TextView) itemView.findViewById(R.id.product_price_id) ;
            img_product_thumbnail = (ImageView) itemView.findViewById(R.id.product_img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id_product);


        }
    }


}


