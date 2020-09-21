package com.asefactory.typicodeexample.ui.post_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.*
import androidx.activity.viewModels
import com.asefactory.typicodeexample.R
import com.asefactory.typicodeexample.data.db.entities.PostsCacheEntity
import com.asefactory.typicodeexample.viewmodel.post_detail.PostsDetailViewModel

class PostDetailActivity : AppCompatActivity() {

    private val viewModel : PostsDetailViewModel by viewModels()
    private lateinit var button: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var bodyTextView: TextView
    private lateinit var post: PostsCacheEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        titleTextView = findViewById(R.id.titleTextView)
        bodyTextView = findViewById(R.id.bodyTextView)

        button = findViewById(R.id.button)

        post = intent.getSerializableExtra("post") as PostsCacheEntity

        titleTextView.text = post.title
        bodyTextView.text = post.body
        setStar(post.favorite)

        button.setOnClickListener { viewModel.changeFavorite(post.id, post.favorite) }

        setObservers()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        finish()
        return true
    }

    private fun setObservers() {
        viewModel
            .isFavorite
            .observe(this, { setStar(it) })

        viewModel
            .throwableMessages
            .observe(
                this, {
                    Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                }
            )
    }

    private fun setStar(favorite: Boolean) {
        if (favorite) {
            button.setImageResource(R.drawable.ic_star_favorite)
        } else {
            button.setImageResource(R.drawable.ic_star_not_favorite)
        }
        post.favorite = favorite
    }
}