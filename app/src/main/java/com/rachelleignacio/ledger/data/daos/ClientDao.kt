package com.rachelleignacio.ledger.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.rachelleignacio.ledger.data.models.Client
import io.reactivex.Observable

@Dao
interface ClientDao {

    @Query("SELECT * FROM clients")
    fun getAllClients(): Observable<List<Client>>

    @Insert
    fun addClient(newClient: Client)

    @Update
    fun updateClient(client: Client)
}