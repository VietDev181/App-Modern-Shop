package com.example.modernshop.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.modernshop.domain.BannerModel
import com.example.modernshop.domain.CategoryModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainRepository {
    private  val  firebaseDatabase = FirebaseDatabase.getInstance()

    fun loadBanner() : LiveData<MutableList<BannerModel>>
    {
        val liveData = MutableLiveData<MutableList<BannerModel>>()
        val ref = firebaseDatabase.getReference("Banner")
        ref.addValueEventListener(object : ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<BannerModel>()
                for (child in snapshot.children)
                {
                    val item = child.getValue(BannerModel::class.java)
                    item?.let{list.add(it)}
                }
                liveData.value = list
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
        return liveData
    }

    fun loadCategory() : LiveData<MutableList<CategoryModel>>
    {
        val liveData = MutableLiveData<MutableList<CategoryModel>>()
        val ref = firebaseDatabase.getReference("Category")
        ref.addValueEventListener(object : ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<CategoryModel>()
                for (child in snapshot.children)
                {
                    val item = child.getValue(CategoryModel::class.java)
                    item?.let{list.add(it)}
                }
                liveData.value = list
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
        return liveData
    }
}