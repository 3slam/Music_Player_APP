package com.example.musictestagain.di

import com.example.musictestagain.data.source.remote.MusicService
import com.example.musictestagain.data.source.local.MusicDao
import com.example.musictestagain.data.source.MusicRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(musicService: MusicService, musicDao: MusicDao):MusicRepository  {
        return MusicRepository(musicService,musicDao)
    }
}