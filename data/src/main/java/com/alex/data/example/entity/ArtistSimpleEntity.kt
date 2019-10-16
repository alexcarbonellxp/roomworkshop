package com.alex.data.example.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArtistEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var name: String
)
