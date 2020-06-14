package com.shashank.assingment.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.shashank.assingment.responseModel.PullRequestDatum
import kotlinx.android.synthetic.main.item_pull_request.view.*

class PullRequestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setData(pullData: PullRequestDatum){
        with(itemView){
            requestTitle?.text = pullData.title
            createdBy?.text = pullData.user?.login
            createdAt?.text = pullData.createdAt
            closedAt?.text = pullData.closedAt
        }
    }
}