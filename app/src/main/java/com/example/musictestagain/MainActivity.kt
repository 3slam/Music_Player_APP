package com.example.musictestagain


import com.example.musictestagain.ui.base.BaseActivity
import com.example.musictestagain.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val layoutActivityId: Int = R.layout.activity_main
}