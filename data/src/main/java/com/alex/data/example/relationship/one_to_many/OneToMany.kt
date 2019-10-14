package com.alex.data.example.relationship.one_to_many

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * Foreign key (ONE-TO-MANY).
 */
@Entity
class ArtistEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String
)

@Entity(
    foreignKeys = [
        ForeignKey(entity = ArtistEntity::class, parentColumns = ["id"], childColumns = ["artistId"], onDelete = ForeignKey.CASCADE)
    ]
)
class Album(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String,
    var artistId: Int
)
