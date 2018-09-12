package com.rachelleignacio.ledger.viewmodel

import com.rachelleignacio.ledger.viewmodel.intents.ClientListIntent
import com.rachelleignacio.ledger.viewmodel.viewstates.ClientListViewState
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ClientListViewModel @Inject constructor() {

    private val disposables = CompositeDisposable()
    private val publishSubject = PublishSubject.create<ClientListViewState>()

    fun viewStates(): Observable<ClientListViewState> = publishSubject

    fun process(viewIntent: ClientListIntent) {
        viewIntent
                .toAction()
                .toResult()
                .subscribe { publishSubject.onNext(it.toViewState()) }
                .addTo(disposables)
    }
}