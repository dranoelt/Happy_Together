package com.example.happytogether.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.happytogether.R
import com.example.happytogether.login.StartupFragment
import com.example.happytogether.ui.HomeFragment


class StartupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startup)

        if (savedInstanceState == null) {
            supportFragmentManager.commit{
                setReorderingAllowed(true)
                add<StartupFragment>(R.id.container)
            }
        }
    }
}