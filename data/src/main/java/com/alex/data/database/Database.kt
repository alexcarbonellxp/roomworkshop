package com.alex.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alex.data.database.Database.Companion.DATABASE_VERSION
import com.alex.data.example.relationship.embedded.ArtistEmbeddedEntity

@Database(
    entities = [ArtistEntity::class, ArtistEmbeddedEntity::class],
    version = DATABASE_VERSION
)
@TypeConverters(GenreConverter::class)
abstract class Database : RoomDatabase() {

    abstract val artistDao: ArtistDao

    companion object {

        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "database.db"
    }
}
