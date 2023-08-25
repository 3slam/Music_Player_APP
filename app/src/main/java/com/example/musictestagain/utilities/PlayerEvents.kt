package com.example.musictestagain.utilities

import com.example.musictestagain.data.model.Music

sealed class PlayerEvents {
    data class  AddPlaylist(val musics: List<Music>): PlayerEvents()
 //   data class  SeekProgress(val value: Long): PlayerEvents()
    data class GoToSpecificItem(val index:Int): PlayerEvents()

    object  PausePlay: PlayerEvents()
    object  Previous : PlayerEvents()
    object  Next : PlayerEvents()
    object  Shuffle : PlayerEvents()
    object  Repeat : PlayerEvents()
    object  SeekForward : PlayerEvents()
    object  SeekBack : PlayerEvents()
}
