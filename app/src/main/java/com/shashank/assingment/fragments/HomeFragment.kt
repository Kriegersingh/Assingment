package com.shashank.assingment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.shashank.assingment.PullRequestsAdapter
import com.shashank.assingment.R
import com.shashank.assingment.viewModels.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private val homeViewModel by viewModels<HomeViewModel>()
    private val pullAdapter by lazy { PullRequestsAdapter() }
    private val ownerName = "huggingface"
    private val repoName = "transformers"
    private val status = "closed"
    private val accept = "application/vnd.github.sailor-v-preview+json"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.fetchPullRequests(ownerName,repoName,status)
        homeViewModel.getPullList().observe(viewLifecycleOwner , Observer {list->
            if (!list.isNullOrEmpty()){
                progress_horizontal?.visibility = View.GONE
                pullRecycler?.adapter = pullAdapter
                pullAdapter.addData(list)
            }
        })
    }
}