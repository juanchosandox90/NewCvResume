package com.newcvresume.juansandoval.newcvresume.Activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.newcvresume.juansandoval.newcvresume.R
import com.newcvresume.juansandoval.newcvresume.Utils.SampleAdapter
import kotlinx.android.synthetic.main.activity_tabs.*


class TabsActivity : AppCompatActivity(), View.OnClickListener {

    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs)

        initToolbar()

        btn_sign_out.setOnClickListener(this)

        mAuth = FirebaseAuth.getInstance()

        val tabLayout: TabLayout = findViewById(R.id.tab_layout)

        val viewPager: ViewPager = findViewById(R.id.view_pager)

        val adapter = SampleAdapter(supportFragmentManager)

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }

    override fun onClick(view: View?) {
        val i = view!!.id
        if (i == R.id.btn_sign_out) {
            signOut()
        }
    }

    private fun signOut() {
        mAuth!!.signOut()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun initToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(android.graphics.Color.WHITE)
    }
}