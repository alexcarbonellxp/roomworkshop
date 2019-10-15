package com.alex.data.example.relationship.many_to_many

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * Foreign key (MANY-TO-MANY).
 */
@Entity
class ArtistManyToManyEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String
)

@Entity
class AlbumManyToManyEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String
)


@Entity(
    tableName = "artist_album_join",
    primaryKeys = ["artistId", "albumId"],
    foreignKeys = [
        ForeignKey(entity = ArtistManyToManyEntity::class, parentColumns = ["id"], childColumns = ["artistId"]),
        ForeignKey(entity = AlbumManyToManyEntity::class, parentColumns = ["id"], childColumns = ["albumId"])
    ]
)
class ArtistAlbumEntity(
    var artistId: Int,
    var albumId: Int
)
