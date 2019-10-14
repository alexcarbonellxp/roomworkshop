package com.alex.roomworkshop.ui.artist

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alex.domain.model.ArtistDomain
import kotlinx.android.synthetic.main.artist_item.view.*

class ArtistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val artistNameTextView = itemView.artistItemName

    fun update(artist: ArtistDomain) {
        artistNameTextView.text = artist.name
    }
}
