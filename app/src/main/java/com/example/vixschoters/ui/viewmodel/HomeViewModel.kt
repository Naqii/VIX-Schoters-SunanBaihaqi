package com.example.vixschoters.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vixschoters.network.model.ArticlesItem
import com.example.vixschoters.network.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: MainRepository) :ViewModel() {

    private var newsLiveData: MutableLiveData<List<ArticlesItem>>? = null

    fun getNews(category: String): MutableLiveData<List<ArticlesItem>>? {

        newsLiveData = category.let { repository.getNews(it) }

        return newsLiveData
    }

}