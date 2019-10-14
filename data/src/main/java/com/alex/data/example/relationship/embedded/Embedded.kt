package com.alex.data.example.relationship.embedded

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Embedded.
 */

@Entity
data class ArtistEmbeddedEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String,
    @Embedded
    var albumEmbedded: Album
)

class Album(
    @ColumnInfo(name = "albumId")
    var id: Int,
    @ColumnInfo(name = "albumName")
    var name: String
)
