package com.kotlin.forecast.kotlin_forcast

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayList = ArrayList<Fragment>()
        arrayList.add(CityFragment())
        arrayList.add(CityFragment())

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, arrayList)
        viewPager.adapter = viewPagerAdapter

    }

    class ViewPagerAdapter(fm: FragmentManager, private var fragmentList: ArrayList<Fragment>) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return fragmentList!!.get(position)
        }

        override fun getCount(): Int {
            return fragmentList!!.size
        }

    }

}
