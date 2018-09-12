package com.rachelleignacio.ledger.viewmodel.actions

import com.rachelleignacio.ledger.data.daos.AppDatabase
import com.rachelleignacio.ledger.data.models.Client
import com.rachelleignacio.ledger.viewmodel.results.ClientListResult
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

sealed class ClientListAction {

    abstract fun toResult(): Observable<ClientListResult>

    data class GetAllClients(private val dataRepository: AppDatabase) : ClientListAction() {
        override fun toResult(): Observable<ClientListResult> =
            dataRepository
                    .clientDao()
                    .getAllClients()
                    .subscribeOn(Schedulers.io())
                    .map { ClientListResult.ClientList(listOf(Client(1234, "Test1"))) as ClientListResult }
//                    .map { ClientListResult.ClientList(it) as ClientListResult }
                    .onErrorReturn { ClientListResult.Error(it) }
    }

    data class AddClient(private val dataRepository: AppDatabase, private val newClient: Client) : ClientListAction() {
        override fun toResult(): Observable<ClientListResult> {
            val clientDao = dataRepository.clientDao()
            return Observable.fromCallable { clientDao.addClient(newClient) }
                    .subscribeOn(Schedulers.io())
                    .flatMap { clientDao.getAllClients() }
                    .map { ClientListResult.ClientList(it) as ClientListResult }
                    .onErrorReturn { ClientListResult.Error(it) }
        }
    }

    data class UpdateClient(private val dataRepository: AppDatabase, private val client: Client) : ClientListAction() {
        override fun toResult(): Observable<ClientListResult> {
            val clientDao = dataRepository.clientDao()
            return Observable.fromCallable { clientDao.updateClient(client) }
                    .subscribeOn(Schedulers.io())
                    .flatMap { clientDao.getAllClients() }
                    .map { ClientListResult.ClientList(it) as ClientListResult }
                    .onErrorReturn { ClientListResult.Error(it) }
        }
    }
}