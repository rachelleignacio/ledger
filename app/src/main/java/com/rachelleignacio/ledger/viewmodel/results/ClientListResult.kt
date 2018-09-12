package com.rachelleignacio.ledger.viewmodel.results

import com.rachelleignacio.ledger.data.models.Client
import com.rachelleignacio.ledger.viewmodel.viewstates.ClientListViewState

sealed class ClientListResult {

    abstract fun toViewState(): ClientListViewState

    data class ClientList(private val clientList: List<Client>) : ClientListResult() {
        override fun toViewState(): ClientListViewState = ClientListViewState.ClientsLoaded(clientList)
    }

    data class Error(private val error: Throwable) : ClientListResult() {
        override fun toViewState(): ClientListViewState = ClientListViewState.Error(error)
    }
}