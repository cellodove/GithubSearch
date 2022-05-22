package com.peter.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.peter.presentation.base.BaseActivity
import com.peter.presentation.databinding.ActivityMainBinding


class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate){

    private val tabTitleArray = arrayOf("검색", "북마크")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        viewPager.adapter = ViewPagerAdapter(supportFragmentManager,lifecycle)
        TabLayoutMediator(tabLayout,viewPager){tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()
    }
}