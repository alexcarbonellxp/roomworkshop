package com.alex.domain.repository

import com.alex.domain.model.ArtistDomain

interface ArtistRepositoryContract {

    suspend fun getAllArtists(): List<ArtistDomain>

    suspend fun saveArtist(artistDomain: ArtistDomain)
}
