package com.example.musictestagain.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.musictestagain.ui.musicPlayer.MusicPlayerViewModel

abstract class BaseFragment<VDB : ViewDataBinding> : Fragment() {

    abstract val layoutFragmentId : Int
    abstract val viewModel : ViewModel
    private lateinit var _binding : VDB
    protected val binding : VDB get() = _binding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutFragmentId, container, false)

        _binding.apply {
            lifecycleOwner = viewLifecycleOwner
            setVariable(BR.viewModel, viewModel)
            return root
        }

    }

}



