package com.rogok.recyclerviewwithretrofit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rogok.recyclerviewwithretrofit.R
import com.rogok.recyclerviewwithretrofit.model.user_model.Data
import kotlinx.android.synthetic.main.row_layout.view.*

class MyAdapter(private val context: Context) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private var myList = emptyList<Data>()


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = myList[position].avatar
        Glide.with(context).load(image).into(holder.itemView.imageView)

        holder.itemView.tv_first_name.text = myList[position].firstName
        holder.itemView.tv_last_name.text = myList[position].lastName
    }

    override fun getItemCount() = myList.size

    fun setData(newList: List<Data>) {
        myList = newList
        notifyDataSetChanged()
    }
}