package com.alex.data.database

import androidx.room.TypeConverter
import com.alex.data.model.Genre

class GenreConverter {

    @TypeConverter
    fun fromGenreToInt(genre: Genre): Int = genre.value

    @TypeConverter
    fun fromIntToGenre(value: Int) = Genre.values().find { it.value == value } ?: Genre.POP
}
