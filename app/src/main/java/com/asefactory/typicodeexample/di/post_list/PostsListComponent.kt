package com.asefactory.typicodeexample.di.post_list

import com.asefactory.typicodeexample.di.scopes.ViewModelScope
import com.asefactory.typicodeexample.viewmodel.post_list.PostsListViewModel
import dagger.Subcomponent

@ViewModelScope
@Subcomponent(modules = [PostsListModule::class])
interface PostsListComponent {
    fun inject(viewModel: PostsListViewModel)
}