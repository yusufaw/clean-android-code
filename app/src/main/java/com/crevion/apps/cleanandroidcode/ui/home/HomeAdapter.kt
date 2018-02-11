package com.crevion.apps.cleanandroidcode.ui.home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.crevion.apps.cleanandroidcode.R
import com.crevion.apps.cleanandroidcode.models.CityListData

/**
 * Created by yusufaw on 2/9/18.
 */

class HomeAdapter(private val context: Context, private val data: List<CityListData>, private val listener: OnItemClickListener) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home, null)
        view.layoutParams = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.click(data[position], listener)
        holder.textViewCity.text = data[position].name
        holder.textViewDescription.text = data[position].description

        val images = data[position].background
        Glide.with(context)
                .load(images)
                .into(holder.imageViewBackground)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var textViewCity: TextView = itemView.findViewById(R.id.city)
        internal var textViewDescription: TextView = itemView.findViewById(R.id.hotel)
        internal var imageViewBackground: ImageView = itemView.findViewById(R.id.image)

        fun click(cityListData: CityListData, listener: OnItemClickListener) {
            itemView.setOnClickListener { listener.onClick(cityListData) }
        }
    }

    interface OnItemClickListener {
        fun onClick(cityListData: CityListData)
    }
}