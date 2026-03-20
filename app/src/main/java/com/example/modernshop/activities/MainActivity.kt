package com.example.modernshop.activities

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.modernshop.R
import com.example.modernshop.adapter.CategoryAdapter
import com.example.modernshop.adapter.PopularAdapter
import com.example.modernshop.databinding.ActivityMainBinding
import com.example.modernshop.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBanner()
        initCategory()
        initPopular()
    }

    private fun initPopular() {
        binding.apply {
            progressBarPopular.visibility = View.VISIBLE
            viewModel.loadPopular().observeForever {
                popularView.layoutManager = GridLayoutManager(this@MainActivity, 2)
                popularView.adapter = PopularAdapter(it)
                progressBarPopular.visibility = View.GONE
            }
            viewModel.loadPopular()
        }
    }

    private fun initCategory() {
        binding.apply {
            progressBarCategory.visibility = View.VISIBLE
            viewModel.loadCategory().observeForever {
                catView.layoutManager =
                    LinearLayoutManager(this@MainActivity,
                        LinearLayoutManager.HORIZONTAL, false)
                catView.adapter = CategoryAdapter(it)
                progressBarCategory.visibility = View.GONE
            }
        }
    }

    private fun initBanner() {
        binding.apply {
            progressBarBanner.visibility = View.VISIBLE
            viewModel.loadBanner().observeForever {
                Glide.with(this@MainActivity)
                    .load(it[0].url)
                    .into(banner)
                progressBarBanner.visibility = View.GONE
            }
            viewModel.loadBanner()
        }
    }
}