package com.example.musictestagain.ui.musicPlayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.musictestagain.R
import com.example.musictestagain.databinding.MusicFragmentBinding
import com.example.musictestagain.ui.base.BaseFragment
import com.example.musictestagain.utilities.PlayerEvents
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MusicPlayerFragment : BaseFragment<MusicFragmentBinding>() {
    override val layoutFragmentId: Int = R.layout.music_fragment
    override val viewModel: MusicPlayerViewModel  by activityViewModels()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            playOrPause.setOnClickListener { viewModel!!.onPlayerEvents(PlayerEvents.PausePlay) }
            next.setOnClickListener { viewModel!!.onPlayerEvents(PlayerEvents.Next) }
            previous.setOnClickListener { viewModel!!.onPlayerEvents(PlayerEvents.Previous) }
            forward.setOnClickListener { viewModel!!.onPlayerEvents(PlayerEvents.SeekForward) }
            rewind.setOnClickListener { viewModel!!.onPlayerEvents(PlayerEvents.SeekBack) }
            repeat.setOnClickListener { viewModel!!.onPlayerEvents(PlayerEvents.Repeat) }
            shuffle.setOnClickListener { viewModel!!.onPlayerEvents(PlayerEvents.Shuffle) }
        }

    }

}