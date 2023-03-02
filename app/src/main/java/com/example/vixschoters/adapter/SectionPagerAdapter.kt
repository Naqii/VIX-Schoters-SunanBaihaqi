package com.example.vixschoters.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.vixschoters.ui.fragment.BusinessFragment
import com.example.vixschoters.ui.fragment.HomeFragment

class SectionPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity){
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = HomeFragment()
            1 -> fragment = BusinessFragment()
        }
        return fragment as Fragment
    }
}