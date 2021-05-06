package com.example.happytogether.login

import androidx.fragment.app.Fragment
import android.content.Intent
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.happytogether.MainActivity
import com.example.happytogether.R
import com.example.happytogether.data.Data
import com.example.happytogether.data.EXTRA_DATA
import com.example.happytogether.databinding.FragmentLoginBinding

private var sp: SoundPool? = null
private var soundID = 0
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        var nama = binding.email.text
        binding.btnLogin.setOnClickListener{
            if (soundID != 0) {
                sp?.play(soundID, 0.99f, .99f, 1, 0, .99f)
            }
            var intent = Intent(this.activity, MainActivity::class.java)
            if (nama.toString() == "") {
                var parcel = Data()
                intent.putExtra(EXTRA_DATA, parcel)
//                Toast.makeText(this.activity, R.string.toast_nama, Toast.LENGTH_SHORT).show()
            }
            else {
                var parcel = Data("$nama")
                intent.putExtra(EXTRA_DATA, parcel)

            }
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

    override fun onStart() {
        super.onStart()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            createNewSoundPool()
        }
        else {
            createOldSoundPool()
        }
        sp?.setOnLoadCompleteListener { soundPool, id, status ->
            if (status != 0) {

            }
            else {

            }
        }
        soundID = sp?.load(activity, R.raw.ringtone, 1) ?: 0
    }
    private fun createNewSoundPool() {
        sp = SoundPool.Builder()
                .setMaxStreams(15)
                .build()
    }
    private fun createOldSoundPool() {
        sp = SoundPool(15, AudioManager.STREAM_MUSIC, 0)
    }

    override fun onStop() {
        super.onStop()
        sp?.release()
        sp = null
    }
}