package com.newcvresume.juansandoval.newcvresume.Fragments

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.newcvresume.juansandoval.newcvresume.R


class FragmentThree : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater!!.inflate(R.layout.fragment_three, container, false)

    companion object {
        fun newInstance(): FragmentThree = FragmentThree()
    }
}