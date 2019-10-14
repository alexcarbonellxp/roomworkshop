package com.alex.roomworkshop

import android.app.Application
import com.alex.roomworkshop.di.startInjector

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startInjector()
    }
}
