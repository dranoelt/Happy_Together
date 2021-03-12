package com.example.happytogether

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.happytogether.data.Data
import com.example.happytogether.data.EXTRA_DATA
import com.example.happytogether.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var dd: Data

    private val m0nNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        item -> when (item.itemId) {
            R.id.nav_home -> {
                val homeFragment = HomeFragment.newInstance()
                openFragment(homeFragment)
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
                val profileFragment = ProfileFragment.newInstance(Data())
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
        if (savedInstanceState == null) {
            supportFragmentManager.commit{
                setReorderingAllowed(true)
                add<HomeFragment>(R.id.container)
            }
        }
        val bundle = intent.getBundleExtra("Bundle")
        val objectss = bundle?.getParcelable<Data>(EXTRA_DATA)
        val text: TextView = findViewById(R.id.textView6)
//        var d :Data? = intent.getParcelableExtra(EXTRA_DATA)
        text.text = "$objectss.Nama"

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_nav)
        bottomNav.setOnNavigationItemSelectedListener(m0nNavigationItemSelectedListener)

    }
}