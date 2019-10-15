package com.alex.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.alex.data.example.relationship.many_to_many.AlbumManyToManyEntity
import com.alex.data.example.relationship.one_to_many.AlbumOneToManyEntity

@Dao
interface AlbumDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOneToMany(entity: AlbumOneToManyEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertManyToMany(entity: AlbumManyToManyEntity): Long
}
