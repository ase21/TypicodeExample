package com.asefactory.typicodeexample.ui.post_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.viewModels
import com.asefactory.typicodeexample.R
import com.asefactory.typicodeexample.data.db.entities.PostsCacheEntity
import com.asefactory.typicodeexample.viewmodel.post_detail.PostsDetailViewModel
import com.asefactory.typicodeexample.viewmodel.post_list.PostsListViewModel

class PostDetailActivity : AppCompatActivity() {

    private val viewModel : PostsDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)

        val titleTextView = findViewById<TextView>(R.id.titleTextView)
        val bodyTextView = findViewById<TextView>(R.id.bodyTextView)

        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)

        val post = intent.getSerializableExtra("post") as PostsCacheEntity

        titleTextView.text = post.title
        bodyTextView.text = post.body
        if (post.favorite){
            ratingBar.rating = 100f
        } else {
            ratingBar.rating = 0f
        }

        ratingBar.setOnClickListener(View.OnClickListener { v -> viewModel.changeFavorite(post.favorite) })

        setObservers()
    }

    private fun setObservers() {

    }
}