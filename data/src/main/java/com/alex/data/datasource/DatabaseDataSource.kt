package com.alex.data.datasource

import com.alex.data.database.AlbumDao
import com.alex.data.database.ArtistAlbumDao
import com.alex.data.database.ArtistDao
import com.alex.data.database.ArtistEntity
import com.alex.data.example.relationship.embedded.Album
import com.alex.data.example.relationship.embedded.ArtistEmbeddedEntity
import com.alex.data.example.relationship.many_to_many.AlbumManyToManyEntity
import com.alex.data.example.relationship.many_to_many.ArtistAlbumEntity
import com.alex.data.example.relationship.many_to_many.ArtistManyToManyEntity
import com.alex.data.example.relationship.one_to_many.AlbumOneToManyEntity
import com.alex.data.example.relationship.one_to_many.ArtistOneToManyEntity


class DatabaseDataSource(
    private val artistDao: ArtistDao,
    private val albumDao: AlbumDao,
    private val artistAlbumDao: ArtistAlbumDao
) {

    suspend fun getAllArtists(): List<ArtistEntity> {
        return artistDao.getAll()
    }

    suspend fun saveArtist(artistEntity: ArtistEntity) {
        // Insert entity with TypeConverter
        artistDao.insert(artistEntity)

        // Insert embedded
        artistDao.insertEmbedded(ArtistEmbeddedEntity(name = "testName", albumEmbedded = Album("albumEmbeddedName")))

        // Insert one-to-many
        val artistOneToManyId: Long = artistDao.insertOneToMany(ArtistOneToManyEntity(name = artistEntity.name))
        albumDao.insertOneToMany(AlbumOneToManyEntity(name = "albumOneToManyName", artistId = artistOneToManyId.toInt()))

        // Insert many-to-many
        val artistManyToManyId: Long = artistDao.insertManyToMany(ArtistManyToManyEntity(name = artistEntity.name))
        val albumManyToManyId: Long = albumDao.insertManyToMany(AlbumManyToManyEntity(name = "albumManyToManyName"))
        artistAlbumDao.insertManyToMany(ArtistAlbumEntity(artistId = artistManyToManyId.toInt(), albumId = albumManyToManyId.toInt()))

//        artistDao.deleteOneToManyById("1")
    }
}
