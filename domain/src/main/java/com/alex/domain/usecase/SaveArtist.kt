package com.alex.domain.usecase

import com.alex.domain.common.UseCase
import com.alex.domain.model.ArtistDomain
import com.alex.domain.repository.ArtistRepositoryContract

class SaveArtist(private val repository: ArtistRepositoryContract) :
    UseCase<Unit, SaveArtist.Params>() {

    override suspend fun func(params: Params) = repository.saveArtist(params.artist)

    class Params(val artist: ArtistDomain)
}
