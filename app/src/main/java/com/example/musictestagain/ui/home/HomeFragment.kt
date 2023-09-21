package com.example.musictestagain.ui.home

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musictestagain.R
import com.example.musictestagain.databinding.HomeFragmentBinding
import com.example.musictestagain.player.MediaService
import com.example.musictestagain.ui.base.BaseFragment
import com.example.musictestagain.ui.base.BaseViewModel
import com.example.musictestagain.ui.musicPlayer.MusicPlayerViewModel
import com.example.musictestagain.utilities.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment: BaseFragment<HomeFragmentBinding>() , OnMusicListener {

    override val layoutFragmentId: Int = R.layout.home_fragment
    override val viewModel : HomeViewModel by viewModels()
    private val musicPlayerViewModel: MusicPlayerViewModel by activityViewModels()
    private lateinit var musicAdapter: MusicAdapter


    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.musicViewModel = musicPlayerViewModel

        musicAdapter = MusicAdapter(mutableListOf() ,this)
        viewModel.fetchAllMusics()

        binding.rv.apply {
            adapter = musicAdapter
            layoutManager = LinearLayoutManager(requireContext())
             setHasFixedSize(true)
        }

        lifecycleScope.launch {
            viewModel.musicList.collect {
                if (it is UiState.Success) {
                    musicPlayerViewModel.onPlayerEvents(PlayerEvents.AddPlaylist(it.data))
                }
            }
        }

        binding.bottomControlMusicPanel.playOrPause.setOnClickListener {
            musicPlayerViewModel.onPlayerEvents(PlayerEvents.PausePlay)
        }
        binding.bottomControlMusicPanel.musicTitle.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_musicPlayerFragment)
        }
    }


    override fun onMusicClick( position: Int) {
            binding.bottomControlMusicPanel.root.visibility = View.VISIBLE
           musicPlayerViewModel.onPlayerEvents(PlayerEvents.GoToSpecificItem(position))
    }




}


