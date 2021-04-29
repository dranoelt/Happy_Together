package com.example.happytogether.ui

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.happytogether.MainActivity
import com.example.happytogether.data.Data
import com.example.happytogether.data.EXTRA_DATA
import com.example.happytogether.databinding.FragmentProfileBinding
import com.example.happytogether.login.LoginFragment
import com.example.happytogether.login.StartupActivity

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.username.text = arguments?.getString(EXTRA_DATA)
        binding.btn05Logout.setOnClickListener {
            var intent = Intent(this.activity, StartupActivity::class.java)
            startActivity(intent)
        }
        return view
    }

    companion object {
        fun newInstance(): ProfileFragment = ProfileFragment()
    }


}