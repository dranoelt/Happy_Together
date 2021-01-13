package com.example.happytogether

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.happytogether.databinding.ActivityStartupBinding
import com.example.happytogether.login.LoginFragment
import com.example.happytogether.login.RegisterFragment


class StartupActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartupBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnLogin.setOnClickListener {
            val loginFragment = LoginFragment.newInstance()
            binding.appLogo.visibility = View.GONE
            binding.appName.visibility = View.GONE
            binding.btnLogin.visibility = View.GONE
            binding.btnRegister.visibility = View.GONE
            openFragment(loginFragment)
        }
        binding.btnRegister.setOnClickListener {
            val registerFragment = RegisterFragment.newInstance()
            binding.appLogo.visibility = View.GONE
            binding.appName.visibility = View.GONE
            binding.btnLogin.visibility = View.GONE
            binding.btnRegister.visibility = View.GONE
            openFragment(registerFragment)
        }
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container1, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}