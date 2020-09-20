package com.asefactory.typicodeexample.di.post_detail

import com.asefactory.typicodeexample.di.scopes.ViewModelScope
import com.asefactory.typicodeexample.model.post_detail.PostDetailRepository
import com.asefactory.typicodeexample.model.post_detail.PostDetailRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface PostDetailModule {

    @ViewModelScope
    @Binds
    fun providePostDetailRepo(repository: PostDetailRepositoryImpl): PostDetailRepository
}