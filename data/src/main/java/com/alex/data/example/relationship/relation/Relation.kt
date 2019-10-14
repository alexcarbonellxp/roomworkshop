package com.alex.data.example.relationship.relation

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

/**
 * Relation.
 */
@Entity
class ArtistEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String
)

@Entity
class AlbumEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String
)

class ArtistWithAlbums(

    @Embedded
    var artist: ArtistEntity,

    @Relation(parentColumn = "id", entityColumn = "artistId")
    var albumList: List<AlbumEntity>
)
