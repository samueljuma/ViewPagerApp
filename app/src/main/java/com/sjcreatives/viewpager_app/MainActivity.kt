package com.sjcreatives.viewpager_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.sjcreatives.viewpager_app.adapters.BudgetItemAdapter
import com.sjcreatives.viewpager_app.data.BudgetItem
import com.sjcreatives.viewpager_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2

    private lateinit var adapter: BudgetItemAdapter

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        viewPager2 = binding.viewPager
        adapter = BudgetItemAdapter()
        viewPager2.adapter = adapter

        val budgetItemsList = listOf(
            BudgetItem(getString(R.string.title1),getString(R.string.desc1)),
            BudgetItem(getString(R.string.title2),getString(R.string.desc2)),
            BudgetItem(getString(R.string.title3),getString(R.string.desc3)),
            BudgetItem(getString(R.string.title4),getString(R.string.desc4)),
        )
        adapter.submitList(budgetItemsList)

    }
}