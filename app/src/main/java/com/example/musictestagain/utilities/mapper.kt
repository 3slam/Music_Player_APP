package com.example.musictestagain.utilities

import androidx.media3.common.MediaItem
import com.example.musictestagain.data.model.Music

fun toMusicItem(mediaItem: MediaItem): Music =
    Music(
        album = mediaItem.mediaMetadata.albumArtist.toString(),
        artist = mediaItem.mediaMetadata.artist.toString(),
        duration = 0,
        genre = mediaItem.mediaMetadata.displayTitle.toString(),
        id = mediaItem.mediaId,
        image = mediaItem.mediaMetadata.artworkUri.toString(),
        site = mediaItem.mediaMetadata.description.toString(),
        source = mediaItem.mediaId,
        title = mediaItem.mediaMetadata.displayTitle.toString() ,
        totalTrackCount = 0,
        trackNumber = 0
    )
