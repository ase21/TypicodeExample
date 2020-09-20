package com.asefactory.typicodeexample.di.post_detail

import com.asefactory.typicodeexample.di.scopes.ViewModelScope
import com.asefactory.typicodeexample.viewmodel.post_list.PostsListViewModel
import dagger.Subcomponent

@ViewModelScope
@Subcomponent(modules = [PostDetailModule::class])
interface PostDetailComponent {
    //fun inject(viewModel: PostsListViewModel)
}