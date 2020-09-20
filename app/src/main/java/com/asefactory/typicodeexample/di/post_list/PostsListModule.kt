package com.asefactory.typicodeexample.di.post_list

import com.asefactory.typicodeexample.di.scopes.ViewModelScope
import com.asefactory.typicodeexample.model.PostsListRepository
import com.asefactory.typicodeexample.model.PostsListRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface PostsListModule {

    @ViewModelScope
    @Binds
    fun providePostListRepo(repository: PostsListRepositoryImpl): PostsListRepository
}