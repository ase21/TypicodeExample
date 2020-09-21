package com.asefactory.typicodeexample.viewmodel.post_detail

import android.app.Application
import androidx.lifecycle.*
import com.asefactory.typicodeexample.di.App
import com.asefactory.typicodeexample.model.post_detail.PostDetailRepositoryImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostsDetailViewModel(application: Application) : AndroidViewModel(application) {

    val isFavorite: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val throwableMessages: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    @Inject
    lateinit var repository : PostDetailRepositoryImpl

    private var compositeDisposable : CompositeDisposable

    init {
        App.appComponent?.plusPostDetailComponent()?.inject(this)
        compositeDisposable = CompositeDisposable()
    }

    fun changeFavorite(id: Long, isFavorite:Boolean){
        if (isFavorite){
            deleteFromFavorite(id)
        } else {
            addToFavorite(id)
        }
    }

    private fun addToFavorite(id: Long) {
        compositeDisposable.add(
            repository.addToFavorite(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({isFavorite.value = true}, {
                    isFavorite.value = false
                    throwableMessages.value = it.message
                })
        )
    }

    private fun deleteFromFavorite(id: Long) {
        compositeDisposable.add(
            repository.deleteFromFavorite(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({isFavorite.value = false}, {
                    isFavorite.value = true
                    throwableMessages.value = it.message
                })
        )
    }
}