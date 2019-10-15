package com.alex.data.repository

import com.alex.data.database.ArtistEntity
import com.alex.data.datasource.DatabaseDataSource
import com.alex.data.model.Genre
import com.alex.domain.model.ArtistDomain
import com.alex.domain.repository.ArtistRepositoryContract

class ArtistRepository(private val dataSource: DatabaseDataSource) : ArtistRepositoryContract {

    override suspend fun getAllArtists(): List<ArtistDomain> {
        return dataSource.getAllArtists().map { ArtistDomain(it.id.toString(), it.name) }
    }

    override suspend fun saveArtist(artistDomain: ArtistDomain) {
        dataSource.saveArtist(ArtistEntity(name = artistDomain.name, genre = Genre.POP))
//        dataSource.saveArtist(ArtistEntity(name = artistDomain.name, genre = Genre.POP, lastName = "Example"))
    }
}
