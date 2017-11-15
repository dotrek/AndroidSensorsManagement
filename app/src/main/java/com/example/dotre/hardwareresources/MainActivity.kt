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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment = MainFragment()
        supportFragmentManager.beginTransaction()
                .replace(R.id.mContainerId, fragment)
                .commit();
    }

    override fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mContainerId, fragment, fragment.toString())
        fragmentTransaction.addToBackStack(fragment.toString())
        fragmentTransaction.commit()
    }

    override fun previousFragment() {
        fragmentManager.popBackStack()
    }
}
