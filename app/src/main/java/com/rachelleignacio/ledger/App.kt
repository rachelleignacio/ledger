package com.rachelleignacio.ledger

import android.app.Application
import com.rachelleignacio.ledger.dagger.ClientListModule
import com.rachelleignacio.ledger.dagger.AppComponent
import com.rachelleignacio.ledger.dagger.DaggerAppComponent
import com.rachelleignacio.ledger.data.DataRepository

val daggerComponent: AppComponent =
        DaggerAppComponent
                .builder()
                .clientListModule(ClientListModule())
                .build()

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        DataRepository.init(applicationContext)
    }
}