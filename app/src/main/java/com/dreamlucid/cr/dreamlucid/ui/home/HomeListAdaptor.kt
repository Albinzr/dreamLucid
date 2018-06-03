package com.dreamlucid.cr.dreamlucid.ui.home


import android.support.v7.widget.RecyclerView
import android.view.*
import android.view.View.OnClickListener
import android.widget.LinearLayout
import android.widget.TextView
import com.dreamlucid.cr.dreamlucid.R

class HomeListAdaptor(list: ArrayList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), OnClickListener {

    val data = list

    private val GRID_VIEW: Int = 0
    private val DEFALT_VIEW: Int = 1
    private val HEADER_VIEW = 2
    private val DREAM_CARD_VIEW = 3
    private val NEXT_DREAM_CARD_VIEW = 4

    override fun onClick(v: View?) {
        println("hi..........................")
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == GRID_VIEW) {
            var view = LayoutInflater.from(parent.context).inflate(R.layout.home_grid_recycle_view, parent, false)
//            view.setOnClickListener(this)
            return HomeGridViewHolder(view)
        }else if (viewType == HEADER_VIEW){
            var view = LayoutInflater.from(parent.context).inflate(R.layout.header_view, parent, false)
//            view.setOnClickListener(this)
            return HeaderViewHolder(view)
        }
        else if (viewType == DREAM_CARD_VIEW){
            var view = LayoutInflater.from(parent.context).inflate(R.layout.dream_list,parent,false)
            return  DreamCardViewHolder(view)
        }
        else if (viewType == NEXT_DREAM_CARD_VIEW){
            var view = LayoutInflater.from(parent.context).inflate(R.layout.next_dream_list,parent,false)
            return  NextDreamCardViewHolder(view)
        }
        else {
            var view = LayoutInflater.from(parent.context).inflate(R.layout.next_dream_list, parent, false)
//            view.setOnClickListener(this)
            return HomeViewHolder(view)
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HomeGridViewHolder) {
            var list: ArrayList<String> = arrayListOf("Albin", "john", "selbin", "baby", "bastain", "angel")
            holder.rvGridList.adapter = HomeGridAdaptor(list)
        }else if (holder is HeaderViewHolder) {
            holder.headerViewTitle.text = "Recent"
        }else if (holder is DreamCardViewHolder) {
            holder.date.text = "1"
            holder.month.text = "Oct"
            holder.title.text = "ThisRecent"
            holder.description.text = "A fast circular ImageView perfect for profile images. This is based .." +
                    " A nice collection of often useful Android examples done in Java and Kotlin. Read More ..." +
                    " Create circular ImageView in Android in the simplest way possible"
        }
        else if (holder is NextDreamCardViewHolder) {
            holder.nextTitle.text = "often useful Android examples"
            holder.nextDescription.text = " Java and Kotlin. Read More ... Create circular ImageView in Android in the simplest way possible"
        }
        else if (holder is HomeViewHolder) {
//            holder.llGridLayout.setOnClickListener(this)
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0)
            return GRID_VIEW
        else if (position == 1)
            return  HEADER_VIEW
        else if (position == 2)
            return  DREAM_CARD_VIEW
        else if (position == 3)
            return  NEXT_DREAM_CARD_VIEW
        else
            return DEFALT_VIEW
    }

}

class HomeViewHolder(item: View) : RecyclerView.ViewHolder(item) {

    var view = item
    var llGridLayout = view.findViewById<LinearLayout>(R.id.gridLinerLayout)

}

class HomeGridViewHolder(item: View) : RecyclerView.ViewHolder(item) {

    var view = item
    var rvGridList = view.findViewById<RecyclerView>(R.id.home_grid_rv_list)

}

class HeaderViewHolder(item: View) : RecyclerView.ViewHolder(item) {

    var view = item
    var headerViewTitle = view.findViewById<TextView>(R.id.headerViewTitle)
}

class DreamCardViewHolder(item:View):RecyclerView.ViewHolder(item){
    var view = item
    var date = view.findViewById<TextView>(R.id.date)
    var month = view.findViewById<TextView>(R.id.month)
    var title = view.findViewById<TextView>(R.id.dreamTitle)
    var description = view.findViewById<TextView>(R.id.dreamDescription)
}

class NextDreamCardViewHolder(item:View):RecyclerView.ViewHolder(item){

    var view = item

    var nextTitle = view.findViewById<TextView>(R.id.nextStoryHeading)
    var nextDescription = view.findViewById<TextView>(R.id.nextStoryDescription)

}