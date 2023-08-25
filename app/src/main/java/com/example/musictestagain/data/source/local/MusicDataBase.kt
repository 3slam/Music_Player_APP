package com.example.musictestagain.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.musictestagain.data.model.Music
import com.example.musictestagain.data.source.local.MusicDao


@Database(entities = [Music::class],version = 1)
abstract class MusicDataBase : RoomDatabase() {
    abstract fun musicDao(): MusicDao
}