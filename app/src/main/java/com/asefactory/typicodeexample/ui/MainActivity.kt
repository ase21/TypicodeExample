package com.asefactory.typicodeexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.asefactory.typicodeexample.R
import com.asefactory.typicodeexample.ui.post_list.PostsListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, PostsListFragment())
            .commit()
    }
}