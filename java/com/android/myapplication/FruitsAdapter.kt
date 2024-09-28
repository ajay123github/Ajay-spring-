package com.android.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FruitsAdapter(
    private val context:Context,
    private val fruits:List<Fruits>): RecyclerView.Adapter<FruitsAdapter.FruitViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsAdapter.FruitViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.fruits,parent,false)
        return FruitViewHolder(view)
    }

    override fun onBindViewHolder(holder: FruitsAdapter.FruitViewHolder, position: Int) {
        val fruit=fruits.get(position)
        holder.name.text=fruit.fruitname
        holder.descriptive.text=fruit.fruitdescriptive
    }

    override fun getItemCount(): Int = fruits.size

    class FruitViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val name: TextView=itemView.findViewById(R.id.fruitsname)
        val descriptive: TextView=itemView.findViewById(R.id.fruitsdescriptive)
    }
}