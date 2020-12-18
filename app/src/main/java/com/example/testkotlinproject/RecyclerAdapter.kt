package com.example.testkotlinproject

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val activity: MainActivity, private var list: List<Model>) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    private lateinit var viewModel: MainViewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        viewModel = ViewModelProvider(activity).get(MainViewModel::class.java)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val current = list[position]

        holder.txtTitle.text = current.title

        holder.txtTitle.setOnClickListener {
            viewModel.postUserInformation(current.title, current.description)
            Log.i("Click", "click")
        }
    }

    override fun getItemCount(): Int = list.size

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val txtTitle = itemView.findViewById<TextView>(R.id.tvTitle)!!
        val cardView = itemView.findViewById<CardView>(R.id.cardView)!!

    }
}
