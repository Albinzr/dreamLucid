package com.dreamlucid.cr.dreamlucid.ui.home

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.*
import android.view.View.OnClickListener
import com.dreamlucid.cr.dreamlucid.R


class HomeGridAdaptor(list: ArrayList<String>) : RecyclerView.Adapter<HomeGridViewHolder>(), OnClickListener {

    override fun onClick(v: View?) {
        println("hi..........................")
    }

    val data = list

    override fun getItemCount(): Int {
        return data.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeGridViewHolder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.home_grid_view, parent, false)
        Log.d("Testing", "oncreateViewHolder")
        view.setOnClickListener(this)


        return HomeGridViewHolder(view)
    }


    override fun onBindViewHolder(holder: HomeGridViewHolder, position: Int) {

//        holder.textView.text = data.get(position)
        Log.d("Testing", "onBindViewHolder")

    }
}

