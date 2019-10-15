package com.alex.data.database

import androidx.room.*
import com.alex.data.example.relationship.embedded.ArtistEmbeddedEntity
import com.alex.data.example.relationship.many_to_many.ArtistManyToManyEntity
import com.alex.data.example.relationship.one_to_many.ArtistOneToManyEntity

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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOneToMany(entity: ArtistOneToManyEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertManyToMany(entity: ArtistManyToManyEntity): Long

    @Update
    suspend fun update(entity: ArtistEntity)

    @Delete
    suspend fun delete(entity: ArtistEntity)

    @Query("delete from ArtistOneToManyEntity where id = :id")
    suspend fun deleteOneToManyById(id: String)
}
