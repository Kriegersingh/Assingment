package com.shashank.assingment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shashank.assingment.responseModel.PullRequestDatum
import com.shashank.assingment.viewholders.PullRequestViewHolder

class PullRequestsAdapter  :RecyclerView.Adapter<PullRequestViewHolder>() {

    private val list by lazy { ArrayList<PullRequestDatum>() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PullRequestViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_pull_request,parent,false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PullRequestViewHolder, position: Int) {
        holder.setData(list[position])
    }

    fun addData(tempList : List<PullRequestDatum>){
        this.list.clear()
        this.list.addAll(tempList)
        notifyDataSetChanged()
    }
}