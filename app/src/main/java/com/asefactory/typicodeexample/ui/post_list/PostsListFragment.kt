package com.asefactory.typicodeexample.ui.post_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.asefactory.typicodeexample.R
import com.asefactory.typicodeexample.viewmodel.post_list.PostsListViewModel

class PostsListFragment : Fragment() {

    private val postsViewModel : PostsListViewModel by viewModels()

    lateinit var postsListAdapter: PostsListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_posts_list, container, false)
        val postsListRecyclerView = view.findViewById<RecyclerView>(R.id.postsListRecyclerView)
        postsListRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        postsListAdapter = PostsListAdapter()
        postsListRecyclerView.adapter = postsListAdapter
        setObservers()
        return view
    }

    private fun setObservers() {
        postsViewModel.postsList.observe(viewLifecycleOwner, Observer {
            postsListAdapter.setItems(it)
        })
    }

    override fun onStart() {
        super.onStart()
        postsViewModel.getPosts()
    }
}