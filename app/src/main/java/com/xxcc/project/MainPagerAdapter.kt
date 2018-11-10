package com.xxcc.project

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by xxcc on 2018/11/9.
 */
class MainPagerAdapter constructor(fragmentList: ArrayList<Fragment>, fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private var list: ArrayList<Fragment> = fragmentList

    override fun getItem(position: Int): Fragment {
        return list[position]
    }

    override fun getCount(): Int {
        return list.size
    }

}