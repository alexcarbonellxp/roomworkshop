package com.alex.roomworkshop.ui.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alex.domain.model.ArtistDomain
import com.alex.roomworkshop.R

class ArtistsAdapter : RecyclerView.Adapter<ArtistViewHolder>() {

    private val items = arrayListOf<ArtistDomain>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        return ArtistViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.artist_item, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.update(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun showItems(items: List<ArtistDomain>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}
