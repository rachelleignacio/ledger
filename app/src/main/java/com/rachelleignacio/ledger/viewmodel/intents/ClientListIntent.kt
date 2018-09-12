package com.rachelleignacio.ledger.viewmodel.intents

import com.rachelleignacio.ledger.data.daos.AppDatabase
import com.rachelleignacio.ledger.data.models.Client
import com.rachelleignacio.ledger.viewmodel.actions.ClientListAction

sealed class ClientListIntent {

    abstract fun toAction(): ClientListAction

    data class LoadAllClients(private val dataRepository: AppDatabase) : ClientListIntent() {
        override fun toAction() = ClientListAction.GetAllClients(dataRepository)
    }

    data class AddClient(private val dataRepository: AppDatabase, private val newClient: Client) : ClientListIntent() {
        override fun toAction() = ClientListAction.AddClient(dataRepository, newClient)
    }

    data class UpdateClient(private val dataRepository: AppDatabase, private val client: Client) : ClientListIntent() {
        override fun toAction() = ClientListAction.UpdateClient(dataRepository, client)
    }
}