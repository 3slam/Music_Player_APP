package com.example.musictestagain.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey




@Entity
data class Music(
    val album: String,
    val artist: String,
    val duration: Int,
    var genre: String,
    @PrimaryKey
    val id: String,
    val image: String,
    val site: String,
    val source: String,
    val title: String,
    var totalTrackCount: Int,
    val trackNumber: Int
)

