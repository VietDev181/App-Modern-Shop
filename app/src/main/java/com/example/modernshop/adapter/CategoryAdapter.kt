package com.example.modernshop.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.modernshop.R
import com.example.modernshop.databinding.ViewholderCategoryBinding
import com.example.modernshop.domain.CategoryModel

class CategoryAdapter(val items: MutableList<CategoryModel>) :
    RecyclerView.Adapter<CategoryAdapter.viewholder>()
{
    private lateinit var context: Context
    private var selectedPosition = -1
    private var lastSelectedPosition = -1

    class viewholder(val binding: ViewholderCategoryBinding):
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryAdapter.viewholder {
        context = parent.context
        val binding = ViewholderCategoryBinding.inflate(LayoutInflater.from(context), parent, false)
        return viewholder(binding)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.viewholder, position: Int) {
        val item = items[position]
        holder.binding.apply {
            titleCatTxt.text = item.title
            root.setOnClickListener {
                lastSelectedPosition = selectedPosition
                selectedPosition = position
                notifyItemChanged(lastSelectedPosition)
                notifyItemChanged(selectedPosition)
            }

            if (selectedPosition == position)
            {
                titleCatTxt.setBackgroundResource(R.drawable.blue_bg)
                titleCatTxt.setTextColor(context.resources.getColor(R.color.white))
            }
            else
            {
                titleCatTxt.setBackgroundResource(R.drawable.grey_bg)
                titleCatTxt.setTextColor(context.resources.getColor(R.color.black))
            }
        }
    }

    override fun getItemCount(): Int = items.size

}