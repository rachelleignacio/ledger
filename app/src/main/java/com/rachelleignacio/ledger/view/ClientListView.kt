package com.rachelleignacio.ledger.view

import com.rachelleignacio.ledger.viewmodel.intents.ClientListIntent
import com.rachelleignacio.ledger.viewmodel.viewstates.ClientListViewState
import io.reactivex.Observable

interface ClientListView {
    fun intents(): Observable<ClientListIntent>
    fun render(viewState: ClientListViewState)
}