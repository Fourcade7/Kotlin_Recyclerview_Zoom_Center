package com.pr7.kotlin_recyclerview_zoom_center

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pr7.kotlin_recyclerview_zoom_center.databinding.RecyclerviewitemBinding

class MyAdapter constructor(
    val context: Context,
    val array: Array<Int>
):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=RecyclerviewitemBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            imageview1.setImageResource(array.get(position))
        }
    }
    override fun getItemCount(): Int =array.size



    class MyViewHolder(val binding: RecyclerviewitemBinding):RecyclerView.ViewHolder(binding.root)
}