package com.rachelleignacio.ledger.dagger

import com.rachelleignacio.ledger.view.ClientListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ClientListModule::class])
interface AppComponent {
    fun inject(clientListFragment: ClientListFragment)
}