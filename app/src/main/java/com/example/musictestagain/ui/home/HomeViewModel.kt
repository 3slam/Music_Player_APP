package com.example.musictestagain.ui.home

import androidx.lifecycle.*
import com.example.musictestagain.data.model.Music
import com.example.musictestagain.data.source.MusicRepository
import com.example.musictestagain.utilities.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val musicRepository: MusicRepository
) :ViewModel (){

    private var _musicList : MutableStateFlow<UiState<List<Music>>> =  MutableStateFlow(UiState.Loading)
    val musicList = _musicList.asStateFlow()

    init {
        fetchAllMusics()
    }

      fun fetchAllMusics() {
        viewModelScope.launch {
            _musicList.value = UiState.Loading
            val musicFlow = musicRepository.getMusics()
            musicFlow.collect { resource ->
                _musicList.value = resource
            }
        }
    }

}



