package com.alex.data.database

import androidx.room.*
import com.alex.data.example.relationship.embedded.ArtistEmbeddedEntity

@Dao
interface ArtistDao {

    @Query("select * from ArtistEntity")
    suspend fun getAll(): List<ArtistEntity>

    @Query("select * from ArtistEntity where id = :id")
    suspend fun get(id: String): ArtistEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: ArtistEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEmbedded(entity: ArtistEmbeddedEntity)

    @Update
    suspend fun update(entity: ArtistEntity)


    @Delete
    suspend fun delete(entity: ArtistEntity)
}
