package com.example.happytogether

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.happytogether.login.StartupFragment


class StartupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startup)

        val startupFragment = StartupFragment.newInstance()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, startupFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}