package com.alex.roomworkshop.ui.artist

import com.alex.domain.model.ArtistDomain
import java.util.*

interface ArtistContract {

    interface View {

        fun showItems(artists: ArrayList<ArtistDomain>)

        fun openCreateArtistDialog()

        fun showError(message: String)
    }

    interface Presenter {

        fun init()

        fun onCreateArtistClick()

        fun onCreateArtistDialogConfirm(artistName: String)
    }
}
