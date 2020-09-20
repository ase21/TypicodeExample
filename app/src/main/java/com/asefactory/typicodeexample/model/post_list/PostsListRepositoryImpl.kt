package com.asefactory.typicodeexample.model.post_list

import com.asefactory.typicodeexample.data.db.daos.FavoritePostsDao
import com.asefactory.typicodeexample.data.db.daos.PostsCacheDao
import com.asefactory.typicodeexample.data.db.entities.FavoritePostsEntity
import com.asefactory.typicodeexample.data.db.entities.PostsCacheEntity
import com.asefactory.typicodeexample.data.network.NetworkInterface
import io.reactivex.Single

import javax.inject.Inject

class PostsListRepositoryImpl @Inject constructor(private val api: NetworkInterface, private val cache: PostsCacheDao, private val favorite: FavoritePostsDao):
    PostsListRepository {

    override fun getPosts(): Single<List<PostsCacheEntity>> {
        return Single.zip(getPostList(), getFavoritePostList(),
            { posts, favoritePosts -> setPostsAsFavorite(posts, favoritePosts) })
    }

    private fun setPostsAsFavorite(
        posts: List<PostsCacheEntity>,
        favoritePosts: List<FavoritePostsEntity>
    ): List<PostsCacheEntity> {
        for (post in posts){
            for (favoritePost in favoritePosts){
                if (favoritePost.id == post.id)
                    post.favorite = true
            }
        }
        return posts
    }

    private fun getFavoritePostList(): Single<List<FavoritePostsEntity>> {
        return favorite.getAll()
    }

    private fun getPostList(): Single<List<PostsCacheEntity>> {
        return api
            .getPosts()
            .doAfterSuccess {
                cache.deleteAll()
                cache.insertAll(it)
            }
            .onErrorResumeNext {
                cache.getAll()
            }
    }
}