package com.xxcc.project

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var len = 17
        var list = ArrayList<Fragment>()
        for (i in 1..len) {
            list.add(ContentFragment.newInstance(i.toString()))
        }
        progressBar.max=len
        var adapter = MainPagerAdapter(list, supportFragmentManager)
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(position: Int) {

            }

            override fun onPageScrolled(position: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(position: Int) {
                progressBar.progress = position+1
                tvPosition.text = "${position+1}/$len"
            }

        })
    }
}
