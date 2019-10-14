package com.alex.roomworkshop.ui.artist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alex.domain.model.ArtistDomain
import com.alex.roomworkshop.R
import com.alex.roomworkshop.ui.common.CustomDialogFragment
import kotlinx.android.synthetic.main.fragment_artist.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.ParameterList
import java.util.*

/**
 * Presentacion:
 *
 * WHY ROOM?
 * BASIC IMPLEMENTATION (CRUD, QUERYS)
 * ROOM STARTER PACK= Relaciones, TYPE_CONVERTER, migraciones
 * EXTRAS (Debugging)
 */
class ArtistFragment : ArtistContract.View, Fragment() {

    private val presenter: ArtistContract.Presenter by inject { ParameterList(this) }
    private val adapter = ArtistsAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_artist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        presenter.init()
    }

    override fun showItems(artists: ArrayList<ArtistDomain>) {
        adapter.showItems(artists)
    }

    override fun openCreateArtistDialog() {
        val title = "Create new artist"
        val positiveText = "Create"
        val negativeText = "Cancel"

        val createArtistDialogFragment = CustomDialogFragment(
            title,
            positiveText,
            negativeText,
            {},
            { artistName -> presenter.onCreateArtistDialogConfirm(artistName) }
        )

        activity?.supportFragmentManager?.let { createArtistDialogFragment.show(it, null) }
    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun initViews() {
        createNewArtistButton.setOnClickListener { presenter.onCreateArtistClick() }
        artistsRecyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        artistsRecyclerView.adapter = adapter
    }
}
