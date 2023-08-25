package com.example.musictestagain.ui.onBoarding

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import com.example.musictestagain.MainActivity
import com.example.musictestagain.R
import com.example.musictestagain.ui.base.BaseActivity
import com.example.musictestagain.databinding.ActivityOnBoardingBinding
import com.example.musictestagain.utilities.IS_THE_FIRST_TIME
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class OnBoardingActivity : BaseActivity<ActivityOnBoardingBinding>(){
    override val layoutActivityId: Int = R.layout.activity_on_boarding

    @Inject
    lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


       val openAppFirstTime = sharedPreferences.getBoolean(IS_THE_FIRST_TIME,false)

        if (openAppFirstTime){
          startActivity(Intent(this, MainActivity::class.java))
        }

        val onBoardingScreens = listOf(
            R.layout.on_boarding_fragment_one,
            R.layout.on_boarding_fragment_two ,
            R.layout.on_boarding_fragment_three)

         binding.viewPager.adapter = OnBoardingPagerAdapter(onBoardingScreens)

        binding.dotsIndicator.attachTo(binding.viewPager)

        binding.getStart.setOnClickListener {
            sharedPreferences.edit().putBoolean(IS_THE_FIRST_TIME, true).apply()
           startActivity(Intent(this, MainActivity::class.java))
        }
    }

}
