package com.example.happytogether.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.happytogether.MainActivity
import com.example.happytogether.R
import com.example.happytogether.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnLogin.setOnClickListener{
            startActivity(Intent(activity, MainActivity::class.java))
        }
        return view
    }

    companion object {
        fun newInstance(): LoginFragment = LoginFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}