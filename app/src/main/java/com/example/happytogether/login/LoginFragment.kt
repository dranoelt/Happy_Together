package com.example.happytogether.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.happytogether.MainActivity
import com.example.happytogether.data.Data
import com.example.happytogether.data.EXTRA_DATA
import com.example.happytogether.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        val nama = binding.email.text
        binding.btnLogin.setOnClickListener{
            val intent = Intent(this.activity, MainActivity::class.java)
            val bundle = Bundle()
            val parcel = Data("$nama")


            bundle.putParcelable(EXTRA_DATA, parcel)
            intent.putExtra("Bundle", bundle)
            startActivity(intent)

//            var intentAct = Intent(activity, MainActivity::class.java)
//            var d = Data ("$nama")
//            intentAct.putExtra(EXTRA_DATA, d)
//            startActivity(intentAct)
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