package com.alex.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.alex.data.example.relationship.many_to_many.ArtistAlbumEntity

@Dao
interface ArtistAlbumDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertManyToMany(entity: ArtistAlbumEntity): Long
}
