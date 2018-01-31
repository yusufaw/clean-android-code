package com.crevion.apps.cleanandroidcode.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.crevion.apps.cleanandroidcode.R;
import com.crevion.apps.cleanandroidcode.models.CityListData;

import java.util.List;

/**
 * Created by yusufaw on 1/27/18.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>  {
    private List<CityListData> data;
    private final OnItemClickListener listener;
    private Context context;

    public HomeAdapter(Context context, List<CityListData> data, OnItemClickListener listener) {
        this.data = data;
        this.listener = listener;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.click(data.get(position), listener);
        holder.textViewCity.setText(data.get(position).getName());
        holder.textViewDescription.setText(data.get(position).getDescription());

        String images = data.get(position).getBackground();
        Glide.with(context)
                .load(images)
                .into(holder.imageViewBackground);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewCity, textViewDescription;
        ImageView imageViewBackground;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewCity = itemView.findViewById(R.id.city);
            textViewDescription = itemView.findViewById(R.id.hotel);
            imageViewBackground = itemView.findViewById(R.id.image);
        }

        public void click(final CityListData cityListData, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(cityListData);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onClick(CityListData cityListData);
    }
}
