package com.alex.domain.di

import com.alex.domain.common.UseCaseContract
import com.alex.domain.model.ArtistDomain
import com.alex.domain.usecase.GetAllArtists
import com.alex.domain.usecase.SaveArtist
import org.koin.dsl.module.module

const val GET_ALL_ARTISTS_USECASE = "GetAllArtistsUseCase"
const val SAVE_ARTIST_USECASE = "SaveArtistUseCase"

val domainModule = module {

    factory<UseCaseContract<List<ArtistDomain>, GetAllArtists.Params>>(GET_ALL_ARTISTS_USECASE) {
        GetAllArtists(get())
    }

    factory<UseCaseContract<Unit, SaveArtist.Params>>(SAVE_ARTIST_USECASE) { SaveArtist(get()) }

}
