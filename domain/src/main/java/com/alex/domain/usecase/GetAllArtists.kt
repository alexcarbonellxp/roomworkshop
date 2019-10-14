package com.alex.domain.usecase

import com.alex.domain.common.UseCase
import com.alex.domain.model.ArtistDomain
import com.alex.domain.repository.ArtistRepositoryContract
import kotlinx.coroutines.coroutineScope

class GetAllArtists(private val repository: ArtistRepositoryContract) :
    UseCase<List<ArtistDomain>, GetAllArtists.Params>() {

    override suspend fun func(params: Params) = coroutineScope {
        repository.getAllArtists()
    }

    class Params
}
