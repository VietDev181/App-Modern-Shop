package com.example.modernshop.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.modernshop.databinding.ViewholderPopularBinding
import com.example.modernshop.domain.ItemsModel

class PopularAdapter(val items: MutableList<ItemsModel>):
RecyclerView.Adapter<PopularAdapter.Viewholder>()
{
    lateinit var context : Context
    class Viewholder(val binding: ViewholderPopularBinding):
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularAdapter.Viewholder {
        context = parent.context
        val binding = ViewholderPopularBinding.inflate(LayoutInflater.from(context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: PopularAdapter.Viewholder, position: Int) {
        holder.binding.apply {
            titleTxt.text = items[position].title
            priceTxt.text = "$" + items[position].price.toString()

            Glide.with(context)
                .load(items[position].thumbnail)
                .into(pic)
            root.setOnClickListener {

            }
        }
    }

    override fun getItemCount(): Int = items.size

}