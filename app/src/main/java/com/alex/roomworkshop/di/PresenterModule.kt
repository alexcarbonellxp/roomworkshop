package com.alex.roomworkshop.di

import com.alex.domain.di.GET_ALL_ARTISTS_USECASE
import com.alex.domain.di.SAVE_ARTIST_USECASE
import com.alex.roomworkshop.ui.artist.ArtistContract
import com.alex.roomworkshop.ui.artist.ArtistPresenter
import org.koin.dsl.module.module

val presenterModule = module {

    factory<ArtistContract.Presenter> { (view: ArtistContract.View) ->
        ArtistPresenter(
            view,
            get(GET_ALL_ARTISTS_USECASE),
            get(SAVE_ARTIST_USECASE)
        )
    }
}
