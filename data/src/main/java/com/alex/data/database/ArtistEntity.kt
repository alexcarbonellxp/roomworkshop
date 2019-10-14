package com.alex.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alex.data.model.Genre

@Entity
data class ArtistEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var name: String,
    var genre: Genre
)
