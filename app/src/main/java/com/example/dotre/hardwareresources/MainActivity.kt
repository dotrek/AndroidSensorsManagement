package com.example.dotre.hardwareresources

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity


interface FragmentChangeListener {
    fun replaceFragment(fragment: Fragment)
    fun previousFragment()
}

class MainActivity : FragmentActivity(), FragmentChangeListener {
    private val fragmentManager = supportFragmentManager
    private val fragmentTransaction = fragmentManager.beginTransaction()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun replaceFragment(fragment: Fragment) {
        fragmentTransaction.replace(R.id.mContainerId, fragment, fragment.toString())
        fragmentTransaction.addToBackStack(fragment.toString())
        fragmentTransaction.commit()
    }

    override fun previousFragment() {
        fragmentManager.popBackStack()
    }
}
