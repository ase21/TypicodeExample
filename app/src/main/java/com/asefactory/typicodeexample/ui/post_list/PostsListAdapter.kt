package com.asefactory.typicodeexample.ui.post_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.asefactory.typicodeexample.R
import com.asefactory.typicodeexample.data.db.entities.PostsCacheEntity

class PostsListAdapter : RecyclerView.Adapter<PostsListAdapter.PostsViewHolder>() {

    private var postsList = ArrayList<PostsCacheEntity>()

    fun setItems(list: List<PostsCacheEntity>) {
        this.postsList.clear()
        this.postsList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostsViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.bind(postsList[position])
    }

    override fun getItemCount(): Int = postsList.size

    class PostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title = itemView.findViewById<TextView>(R.id.titleTextView)
        val body = itemView.findViewById<TextView>(R.id.bodyTextView)
        val ratingBar = itemView.findViewById<RatingBar>(R.id.ratingBar)

        fun bind(post: PostsCacheEntity) {
            title.text = post.title
            body.text = post.body
            ratingBar.rating = 100f
        }
    }
}