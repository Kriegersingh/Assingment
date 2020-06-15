package com.shashank.assingment.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shashank.assingment.R
import com.shashank.assingment.responseModel.PullRequestDatum
import com.shashank.assingment.utils.BaseUtils
import kotlinx.android.synthetic.main.item_pull_request.view.*

class PullRequestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setData(pullData: PullRequestDatum){
        with(itemView){

            requestTitle?.text = pullData.title
            createdBy?.text = context.getString(R.string.created_by_fmt,pullData.user?.login)
            createdAt?.text = context.getString(R.string.created_at_fmt,BaseUtils.convertSimpleDateFormatToReadableFormat(pullData.createdAt))
            closedAt?.text = context.getString(R.string.closed_at_fmt,BaseUtils.convertSimpleDateFormatToReadableFormat(pullData.closedAt))
            Glide.with(itemView)
                .load(pullData.user?.avatarUrl)
                .circleCrop()
                .into(avatarImage)



        }
    }
}