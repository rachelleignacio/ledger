package com.rachelleignacio.ledger.viewmodel.viewstates

import com.rachelleignacio.ledger.data.models.Client

sealed class ClientListViewState(clients: List<Client> = emptyList(), error: Throwable? = null) {
    data class Error(val error: Throwable) : ClientListViewState(emptyList(), error)

    data class ClientsLoaded(val clientList: List<Client>) : ClientListViewState(clientList, null)
}