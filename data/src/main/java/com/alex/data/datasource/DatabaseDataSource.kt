package com.alex.data.datasource

import com.alex.data.database.ArtistDao
import com.alex.data.database.ArtistEntity
import com.alex.data.example.relationship.embedded.Album
import com.alex.data.example.relationship.embedded.ArtistEmbeddedEntity

class DatabaseDataSource(private val artistDao: ArtistDao) {

    suspend fun getAllArtists(): List<ArtistEntity> {
        return artistDao.getAll()
    }

    suspend fun saveArtist(artistEntity: ArtistEntity) {
        artistDao.insert(artistEntity)

        // TODO: Remove test
        artistDao.insertEmbedded(ArtistEmbeddedEntity(0, "testName", Album(3, "albumName")))
    }
}
