package com.alex.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alex.data.database.Database.Companion.DATABASE_VERSION
import com.alex.data.example.relationship.embedded.ArtistEmbeddedEntity
import com.alex.data.example.relationship.many_to_many.AlbumManyToManyEntity
import com.alex.data.example.relationship.many_to_many.ArtistAlbumEntity
import com.alex.data.example.relationship.many_to_many.ArtistManyToManyEntity
import com.alex.data.example.relationship.one_to_many.AlbumOneToManyEntity
import com.alex.data.example.relationship.one_to_many.ArtistOneToManyEntity

@Database(
    entities = [ArtistEntity::class, ArtistEmbeddedEntity::class, ArtistOneToManyEntity::class, ArtistManyToManyEntity::class,
        AlbumOneToManyEntity::class, AlbumManyToManyEntity::class, ArtistAlbumEntity::class],
    version = DATABASE_VERSION
)
@TypeConverters(GenreConverter::class)
abstract class Database : RoomDatabase() {

    abstract val artistDao: ArtistDao
    abstract val albumDao: AlbumDao
    abstract val artistAlbumDao: ArtistAlbumDao

    companion object {

        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "database.db"
    }
}
