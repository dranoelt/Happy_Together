package com.example.happytogether

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.happytogether.databinding.ActivityIntroSliderBinding


class IntroSliderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntroSliderBinding

    private val fragmentList = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroSliderBinding.inflate(layoutInflater)
        val view = binding.root
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }

        setContentView(view)

        val adapter = IntroSliderAdapter(this)
        binding.vpIntroSlider.adapter = adapter

        fragmentList.addAll(listOf(
            Intro1Fragment(), Intro2Fragment(), Intro3Fragment()
        ))
        adapter.setFragmentList(fragmentList)

        binding.indicatorLayout.setIndicatorCount(adapter.itemCount)
        binding.indicatorLayout.selectCurrentPosition(0)

        registerListeners()
    }
    private fun registerListeners() {
        binding.vpIntroSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                binding.indicatorLayout.selectCurrentPosition(position)

                if (position < fragmentList.lastIndex) {
                    binding.tvSkip.visibility = View.VISIBLE
                    binding.tvNext.text = "Next"
                } else {
                    binding.tvSkip.visibility = View.GONE
                    binding.tvNext.text = "Get Started"
                }
            }
        })
        binding.tvSkip.setOnClickListener {
            startActivity(Intent(this, StartupActivity::class.java))
            finish()
        }
        binding.tvNext.setOnClickListener {
            val position = binding.vpIntroSlider.currentItem

            if (position < fragmentList.lastIndex) {
                binding.vpIntroSlider.currentItem = position + 1
            } else {
                startActivity(Intent(this,StartupActivity::class.java))
                finish()
            }
        }
    }
}