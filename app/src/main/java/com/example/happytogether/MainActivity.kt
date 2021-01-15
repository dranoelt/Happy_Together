package com.example.happytogether

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.happytogether.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val m0nNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        item -> when (item.itemId) {
            R.id.nav_home -> {
                val homeFragment = HomeFragment.newInstance()
                openFragment(homeFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_order -> {
                val orderFragment = OrderFragment.newInstance()
                openFragment(orderFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_cart -> {
                val cartFragment = CartFragment.newInstance()
                openFragment(cartFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_messages -> {
                val messageFragment = MessageFragment.newInstance()
                openFragment(messageFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_profile -> {
                val profileFragment = ProfileFragment.newInstance()
                openFragment(profileFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment.newInstance()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, homeFragment)
        transaction.addToBackStack(null)
        transaction.commit()

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_nav)
        bottomNav.setOnNavigationItemSelectedListener(m0nNavigationItemSelectedListener)
    }
}