package com.alex.roomworkshop.di

import android.app.Application
import com.alex.data.di.dataModule
import com.alex.domain.di.domainModule
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module

fun Application.startInjector() {
    val list = ArrayList<Module>()
    list.addAll(appModules())
    startKoin(this, list)
}

fun appModules(): List<Module> {
    return listOf(
        presenterModule,
        domainModule,
        dataModule
    )
}
