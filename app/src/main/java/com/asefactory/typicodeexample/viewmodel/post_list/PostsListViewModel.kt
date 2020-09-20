package com.asefactory.typicodeexample.viewmodel.post_list

import android.app.Application
import androidx.lifecycle.*
import com.asefactory.typicodeexample.data.db.entities.PostsCacheEntity
import com.asefactory.typicodeexample.di.App
import com.asefactory.typicodeexample.model.PostsListRepositoryImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostsListViewModel(application: Application) : AndroidViewModel(application) {

    val postsList: MutableLiveData<List<PostsCacheEntity>> by lazy {
        MutableLiveData<List<PostsCacheEntity>>()
    }

    val throwableMessages: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    @Inject
    lateinit var repository: PostsListRepositoryImpl

    init {
        App.appComponent?.plusPostsListComponent()?.inject(this)
    }

    fun getPosts(){
        repository.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({postsList.value = it}, {throwableMessages.value = it.message})
    }
}