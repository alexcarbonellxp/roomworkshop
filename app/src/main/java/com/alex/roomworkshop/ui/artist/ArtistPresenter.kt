package com.alex.roomworkshop.ui.artist

import com.alex.domain.common.UseCaseContract
import com.alex.domain.model.ArtistDomain
import com.alex.domain.usecase.GetAllArtists
import com.alex.domain.usecase.SaveArtist
import com.alex.roomworkshop.common.Logs

class ArtistPresenter(
    private val view: ArtistContract.View?,
    private val getAllArtists: UseCaseContract<List<ArtistDomain>, GetAllArtists.Params>,
    private val saveArtist: UseCaseContract<Unit, SaveArtist.Params>
) : ArtistContract.Presenter {

    private val artists = arrayListOf<ArtistDomain>()

    private var isFirstTime = true

    override fun init() {
        if (isFirstTime) {
            updateArtistsList()
        }
        isFirstTime = false
    }

    override fun onCreateArtistClick() {
        view?.openCreateArtistDialog()
    }

    override fun onCreateArtistDialogConfirm(artistName: String) {
        saveArtist.run({ updateArtistsList() }, ::onError, SaveArtist.Params(ArtistDomain("", artistName)))
    }

    private fun updateArtistsList() {
        getAllArtists.run(
            {
                artists.clear()
                artists.addAll(it)
                view?.showItems(artists)
            },
            {},
            GetAllArtists.Params()
        )
    }

    private fun onError(error: Throwable) {
        Logs.error(error)
        error.message?.let { message -> view?.showError(message) }
    }
}
