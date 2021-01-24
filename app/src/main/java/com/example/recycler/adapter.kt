package com.example.recycler

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class DataAdapter(context: Context, imageUrls: ArrayList<ImageUrl>) :
    RecyclerView.Adapter<DataAdapter.ViewHolder>() {
    private val imageUrls: ArrayList<ImageUrl>
    private val context: Context
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.image_layout, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        Glide.with(context).load(imageUrls[i].getImageUrl()).into(viewHolder.img)
    }

    override fun getItemCount(): Int {
        return imageUrls.size()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var img: ImageView

        init {
            img = view.findViewById(R.id.imageView)
        }
    }

    init {
        this.context = context
        this.imageUrls = imageUrls
    }
}


