package com.example.sougha.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.sougha.R

class AdapterViewPager(private val images:List<Int>): RecyclerView.Adapter<AdapterViewPager.ImageViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int):ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemi_images_viewpager, parent, false)
        return ImageViewHolder(view)
    }
    override fun onBindViewHolder(holder:ImageViewHolder,position:Int)
    {
        holder.bind(images[position])
    }
    override fun getItemCount():Int{
        return images.size
    }                                                                                                                                                                                                                                                                                                                                                   
    class ImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        fun bind(imageResId:Int)
        {
            itemView.findViewById<ImageView>(R.id.imageView).setImageResource(imageResId)
        }
    }
}