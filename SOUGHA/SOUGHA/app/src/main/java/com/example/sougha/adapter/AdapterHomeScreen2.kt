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

class AdapterHomeScreen2(val List:ArrayList<HomePageDataClass>, val context: Context):RecyclerView.Adapter<AdapterHomeScreen2.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=LayoutInflater.from(context).inflate(R.layout.rv_partneroffers,parent,false)
        return MyViewHolder(itemView)
    }
    override fun getItemCount(): Int {
     return List.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      val currentItem=List[position]
        holder.image.setImageResource(currentItem.image)
        holder.txtLogo.text=currentItem.txtLogo
        holder.txtHome.text=currentItem.txtHome
        holder.txtDiscount.text=currentItem.txtDiscount
        holder.txtValidDate.text=currentItem.txtValidDate
    }
    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val image=itemView.findViewById<ImageView>(R.id.imgFurniture)
        val txtLogo=itemView.findViewById<TextView>(R.id.txt2xl)
        val txtHome=itemView.findViewById<TextView>(R.id.txtHome)
        val txtDiscount=itemView.findViewById<TextView>(R.id.txtOffer)
        val txtValidDate=itemView.findViewById<TextView>(R.id.txtValidDate)
    }
}