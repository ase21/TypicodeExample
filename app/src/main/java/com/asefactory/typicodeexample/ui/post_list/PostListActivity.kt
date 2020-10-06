package com.asefactory.typicodeexample.ui.post_list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.asefactory.typicodeexample.R
import com.asefactory.typicodeexample.data.db.entities.PostsCacheEntity
import com.asefactory.typicodeexample.ui.post_detail.PostDetailActivity
import com.asefactory.typicodeexample.viewmodel.post_list.PostsListViewModel

class Engine{
    var name = ""
    var power = 120
    var compression = 12.2
}

class PostListActivity : AppCompatActivity(), PostsListAdapter.OnPostClickListener {

    private val postsViewModel : PostsListViewModel by viewModels()

    lateinit var postsListAdapter: PostsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts_list)
        //apply
        //получает текущий контекст объекта
        //возвращает текущий контекст объекта
        val someEngine = Engine().apply {
            this.compression = 10.0
        }

        //with
        //получает текущий контекст объекта
        //возвращает либо результат лямбды, как тут(строка)...
        val someEnginePower = with(someEngine){
            println(this.power)
            "Power of engine is ${this.power}"
        }
        //..либо Unit, как тут
        val someUnitEnginePower = with(someEngine){
            "Power of engine is ${this.power}"
            println(this.power)
        }
        lateinit var s: String
        someEngine.also {
            println("")
        }
        println(someEnginePower)

        val someString = someEngine.run{
            println("sd")
            "some result"
        }

        someEngine.let {

        }

        val postsListRecyclerView = findViewById<RecyclerView>(R.id.postsListRecyclerView)
        postsListRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        postsListAdapter = PostsListAdapter(this)
        postsListRecyclerView.adapter = postsListAdapter

        setObservers()
        Unit
    }

    private fun setObservers() {
        postsViewModel
            .postsList
            .observe(
                this, {
                    postsListAdapter.setItems(it)
                }
            )

        postsViewModel
            .throwableMessages
            .observe(
                this, {
                    Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                }
            )
    }

    override fun onStart() {
        super.onStart()
        postsViewModel.getPosts()
    }

    override fun onPostClick(post: PostsCacheEntity) {
        val intent = Intent(this, PostDetailActivity::class.java)
        intent.putExtra("post", post)
        startActivity(intent)
    }
}