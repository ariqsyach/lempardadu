package com.example.challenge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_skor.view.*

class RollAdapter(private val listDadu: List<Dadu>) :
    RecyclerView.Adapter<RollAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(dadu: Dadu, position: Int) {
            itemView.tv_user_skor.text = dadu.user
            itemView.tv_skor_skor.text = dadu.skor.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_skor, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listDadu.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listDadu[position],position)
    }

}