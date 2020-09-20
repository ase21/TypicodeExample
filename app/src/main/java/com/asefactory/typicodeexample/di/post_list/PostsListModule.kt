package com.asefactory.typicodeexample.di.post_list

import com.asefactory.typicodeexample.di.scopes.ViewModelScope
import com.asefactory.typicodeexample.model.post_list.PostsListRepository
import com.asefactory.typicodeexample.model.post_list.PostsListRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface PostsListModule {

    @ViewModelScope
    @Binds
    fun providePostListRepo(repository: PostsListRepositoryImpl): PostsListRepository
}