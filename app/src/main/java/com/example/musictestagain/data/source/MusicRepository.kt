package com.example.musictestagain.data.source

import com.example.musictestagain.data.source.remote.MusicService
import com.example.musictestagain.data.model.Music
import com.example.musictestagain.data.source.local.MusicDao
import com.example.musictestagain.utilities.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


import javax.inject.Inject


class MusicRepository @Inject constructor (
    private val musicService: MusicService,
    private val musicDao: MusicDao
)  {

    // caching
    fun getMusics(): Flow<UiState<List<Music>>> {
            return flow {
                emit(UiState.Loading)
                val cachedMusic = musicDao.getAllMusic()
                if (cachedMusic.isNotEmpty()) emit(UiState.Success(cachedMusic))
                try {
                    val networkResponse = musicService.getAllMusic()
                        val musics = networkResponse.body()?.music ?: emptyList()
                        musicDao.insertAllMusic(musics)
                        emit(UiState.Success(musics))
                } catch (e: Exception) {
                    emit(UiState.Error("Error fetching Musics"))
                }

            }.flowOn(Dispatchers.IO)
    }


}


