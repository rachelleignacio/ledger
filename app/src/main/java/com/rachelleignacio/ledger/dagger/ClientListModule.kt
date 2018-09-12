package com.rachelleignacio.ledger.dagger

import com.rachelleignacio.ledger.data.DataRepository
import com.rachelleignacio.ledger.data.daos.AppDatabase
import com.rachelleignacio.ledger.viewmodel.ClientListViewModel
import dagger.Module
import dagger.Provides

@Module
class ClientListModule {

    @Provides
    fun provideClientListViewModel(): ClientListViewModel = ClientListViewModel()

    @Provides
    fun provideAppDatabaseInstance(): AppDatabase = DataRepository.appDatabase
}