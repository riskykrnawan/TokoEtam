package com.example.tokoetam.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.tokoetam.fragment.CartFragment
import com.example.tokoetam.fragment.HomeFragment
import com.example.tokoetam.fragment.ProfileFragment
import com.example.tokoetam.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(HomeFragment())

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation_view)
        bottomNavigationView.setOnItemSelectedListener(this)
    }

    private fun loadFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_layout, fragment)
            .commit()
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment = HomeFragment()
        when(item.itemId) {
            R.id.navigation_home -> {
                fragment = HomeFragment()
            }
            R.id.navigation_cart -> {
                fragment = CartFragment()
            }
            R.id.navigation_profile -> {
                fragment = ProfileFragment()
            }
        }
        return loadFragment(fragment)
    }

}