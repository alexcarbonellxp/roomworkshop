package com.alex.data.di

import androidx.room.Room
import com.alex.data.database.Database
import com.alex.data.datasource.DatabaseDataSource
import com.alex.data.repository.ArtistRepository
import com.alex.domain.repository.ArtistRepositoryContract
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val dataModule = module {

    single {
        Room.databaseBuilder(androidContext(), Database::class.java, Database.DATABASE_NAME).build()
    }
    single { get<Database>().artistDao }

    single { DatabaseDataSource(get()) }
    single<ArtistRepositoryContract> { ArtistRepository(get()) }
}
