package com.example.sougha.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sougha.R
import com.example.sougha.modals.HomePageDataClass

class AdapterHomeScreeen(private val list:ArrayList<HomePageDataClass>, val context: Context):RecyclerView.Adapter<AdapterHomeScreeen.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=LayoutInflater.from(context).inflate(R.layout.rv_recommendation,parent,false)
        return MyViewHolder(itemView)
    }
    override fun getItemCount(): Int {
        return list.size
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=list[position]
        holder.image.setImageResource(currentItem.image)
        holder.txtLogo.text=currentItem.txtLogo
        holder.txtHome.text=currentItem.txtHome
        holder.txtDiscount.text=currentItem.txtDiscount
        holder.txtValidDate.text=currentItem.txtValidDate
    }
     class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val image: ImageView =itemView.findViewById(R.id.imgFurniture)
        val txtLogo: TextView =itemView.findViewById(R.id.txt2xl)
        val txtHome: TextView =itemView.findViewById(R.id.txtHome)
        val txtDiscount: TextView =itemView.findViewById(R.id.txtOffer)
        val txtValidDate: TextView =itemView.findViewById(R.id.txtValidDate)
    }
}