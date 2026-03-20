package com.example.modernshop.viewModel

import androidx.lifecycle.LiveData
import com.example.modernshop.domain.BannerModel
import com.example.modernshop.domain.CategoryModel
import com.example.modernshop.repository.MainRepository

class MainViewModel {
    private val repository = MainRepository()

    fun loadBanner(): LiveData<MutableList<BannerModel>>
    {
        return repository.loadBanner()
    }

    fun loadCategory(): LiveData<MutableList<CategoryModel>>
    {
        return repository.loadCategory()
    }
}