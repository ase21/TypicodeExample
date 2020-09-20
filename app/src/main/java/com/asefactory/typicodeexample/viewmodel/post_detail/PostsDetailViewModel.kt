package com.asefactory.typicodeexample.viewmodel.post_detail

import android.app.Application
import androidx.lifecycle.*
import com.asefactory.typicodeexample.data.db.entities.PostsCacheEntity
import com.asefactory.typicodeexample.di.App
import com.asefactory.typicodeexample.model.post_detail.PostDetailRepositoryImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostsDetailViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var repository : PostDetailRepositoryImpl

    private var compositeDisposable : CompositeDisposable

    init {
        App.appComponent?.plusPostDetailComponent()?.inject(this)
        compositeDisposable = CompositeDisposable()
    }

    fun changeFavorite(isFavorite:Boolean){
//        compositeDisposable.add(
//            repository.changeFavorite()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({postsList.value = it}, {throwableMessages.value = it.message})
//        )
    }
}