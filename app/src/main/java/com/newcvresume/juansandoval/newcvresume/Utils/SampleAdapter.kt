package com.newcvresume.juansandoval.newcvresume.Utils

import android.support.v4.app.FragmentManager
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import com.newcvresume.juansandoval.newcvresume.Fragments.*


class SampleAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? = when (position) {
        0 -> FragmentOne.newInstance()
        1 -> FragmentTwo.newInstance()
        2 -> FragmentThree.newInstance()
        3 -> FragmentFour.newInstance()
        4 -> FragmentFive.newInstance()
        else -> null
    }

    override fun getPageTitle(position: Int): CharSequence = when (position) {
        0 -> "Tab 1 Item"
        1 -> "Tab 2 Item"
        2 -> "Tab 3 Item"
        3 -> "Tab 4 item"
        4 -> "Tab 5 item"
        else -> ""
    }

    override fun getCount(): Int = 5
}