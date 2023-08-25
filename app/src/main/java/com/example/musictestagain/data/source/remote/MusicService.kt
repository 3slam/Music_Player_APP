package com.example.musictestagain.data.source.remote


import com.example.musictestagain.data.model.MusicResponse
import retrofit2.Response
import retrofit2.http.GET

interface MusicService {

    @GET("catalog.json")
    suspend fun getAllMusic() : Response<MusicResponse>
}