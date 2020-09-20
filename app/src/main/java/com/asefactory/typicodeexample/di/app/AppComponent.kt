package com.asefactory.typicodeexample.di.app

import android.app.Application
import android.content.Context
import com.asefactory.typicodeexample.di.post_detail.PostDetailComponent
import com.asefactory.typicodeexample.di.post_list.PostsListComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent?
    }

    fun plusPostsListComponent(): PostsListComponent

    fun plusPostDetailComponent(): PostDetailComponent
}