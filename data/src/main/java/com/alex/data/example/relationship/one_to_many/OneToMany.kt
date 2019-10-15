package com.alex.data.example.relationship.one_to_many

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * Foreign key (ONE-TO-MANY).
 */
@Entity
class ArtistOneToManyEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String
)

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = ArtistOneToManyEntity::class,
            parentColumns = ["id"],
            childColumns = ["artistId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
class AlbumOneToManyEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String,
    var artistId: Int
)
