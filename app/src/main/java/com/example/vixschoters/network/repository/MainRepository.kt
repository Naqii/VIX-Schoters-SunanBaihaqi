package com.example.vixschoters.network.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.vixschoters.BuildConfig
import com.example.vixschoters.network.api.ApiService
import com.example.vixschoters.network.api.RetrofitHelper
import com.example.vixschoters.network.model.ArticlesItem
import com.example.vixschoters.network.model.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(private val service: RetrofitHelper) {

    //GET News from API
    fun getNews(category: String?): MutableLiveData<List<ArticlesItem>> {
        val item = MutableLiveData<List<ArticlesItem>>()
        val api = service.getInstance().create(ApiService::class.java)
            .getNews("id", category, BuildConfig.API_KEY)

        api.enqueue(object : Callback<NewsResponse>{
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        val tempNewsList = mutableListOf<ArticlesItem>()
                        body.articles.forEach{
                            tempNewsList.add(
                                ArticlesItem(
                                    it.title,
                                    it.author,
                                    it.urlToImage,
                                    it.description,
                                    it.url,
                                    it.source,
                                    it.publishedAt,
                                    it.content
                                )
                            )
                        }
                        item.value = tempNewsList
                    }
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                t.message?.let { Log.d("Failure", it) }
            }

        })
        return item
    }
}