package com.example.recyclerviewwithstickyheader.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewwithstickyheader.R
import com.example.recyclerviewwithstickyheader.model.AnimalNames
import kotlinx.android.synthetic.main.list_items.view.*

class MyAdapter(var list: ArrayList<AnimalNames>): RecyclerView.Adapter<MyAdapter.AnimalViewHolder>() {


    fun updateList(newInfo: ArrayList<AnimalNames>) {
        list.clear()
        list.addAll(newInfo)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= AnimalViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.list_items,parent,false)
    )

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(list[position])
    }


    class AnimalViewHolder(view: View): RecyclerView.ViewHolder(view){

        val name = view.tv_names

        fun bind(animalNames: AnimalNames) {
            name.text = animalNames.name
        }
    }
}