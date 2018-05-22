package com.newcvresume.juansandoval.newcvresume.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.newcvresume.juansandoval.newcvresume.R


class FragmentFour : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater!!.inflate(R.layout.fragment_four, container, false)

    companion object {
        fun newInstance(): FragmentOne = FragmentOne()
    }
}