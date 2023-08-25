package com.example.musictestagain.data.source.local

import androidx.room.Dao
import androidx.room.OnConflictStrategy
import androidx.room.Insert
import androidx.room.Query
import com.example.musictestagain.data.model.Music


@Dao
interface MusicDao {

	@Query("SELECT * FROM Music")
	suspend fun getAllMusic():  List<Music>


	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertAllMusic(musics: List<Music>)

	@Query("DELETE FROM Music")
	suspend fun deleteAllMusic()
}
