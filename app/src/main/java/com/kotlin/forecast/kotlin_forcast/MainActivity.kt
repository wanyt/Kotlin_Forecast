package com.kotlin.forecast.kotlin_forcast

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.Window
import com.jaeger.library.StatusBarUtil
import com.kotlin.forecast.kotlin_forcast.model.bean.CityBean
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        StatusBarUtil.setTranslucentForImageView(this, null)

        setContentView(R.layout.activity_main)

        val cityBeijing = CityBean("北京", R.drawable.pic_beijing)
        val cityShanghai = CityBean("上海", R.drawable.pic_shanghai)

        val fragmentBeijing = CityFragment()
        val fragmentShanghai = CityFragment()

        val bundle = Bundle()
        bundle.putSerializable(Constants.params, cityBeijing)

        val bundleShanghai = Bundle()
        bundleShanghai.putSerializable(Constants.params, cityShanghai)

        fragmentBeijing.arguments = bundle
        fragmentShanghai.arguments = bundleShanghai

        val arrayList = ArrayList<Fragment>()
        arrayList.add(fragmentBeijing)
        arrayList.add(fragmentShanghai)

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, arrayList)
        viewPager.adapter = viewPagerAdapter

    }

}

/**
 * 主页面适配器
 */
class ViewPagerAdapter(fm: FragmentManager, private var fragmentList: ArrayList<Fragment>) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return fragmentList.get(position)
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

}
