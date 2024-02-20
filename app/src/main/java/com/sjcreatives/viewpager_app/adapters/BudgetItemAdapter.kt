package com.sjcreatives.viewpager_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sjcreatives.viewpager_app.data.BudgetItem
import com.sjcreatives.viewpager_app.databinding.BudgetItemLayoutBinding

class BudgetItemAdapter: ListAdapter<BudgetItem, BudgetItemAdapter.ViewHolder>(BudgetIteDiffCallBack()) {

    class ViewHolder (val binding: BudgetItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind (budgetItem: BudgetItem){
            binding.budgetItem = budgetItem
            binding.executePendingBindings()
        }

        companion object{
            fun from(parent:ViewGroup): ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = BudgetItemLayoutBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class BudgetIteDiffCallBack : DiffUtil.ItemCallback<BudgetItem>() {
    override fun areItemsTheSame(oldItem: BudgetItem, newItem: BudgetItem): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: BudgetItem, newItem: BudgetItem): Boolean {
        return oldItem == newItem
    }

}
