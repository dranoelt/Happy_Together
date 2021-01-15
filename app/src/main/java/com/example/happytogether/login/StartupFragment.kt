package com.example.happytogether.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.happytogether.R
import com.example.happytogether.databinding.FragmentStartupBinding

class StartupFragment : Fragment() {

    private var _binding: FragmentStartupBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentStartupBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnLogin.setOnClickListener {
            val loginFragment = LoginFragment.newInstance()
            openFragment(loginFragment)
        }

        binding.btnRegister.setOnClickListener {
            val registerFragment = RegisterFragment.newInstance()
            openFragment(registerFragment)
        }

        return view
    }

    companion object {
        fun newInstance(): StartupFragment = StartupFragment()
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = activity!!.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}