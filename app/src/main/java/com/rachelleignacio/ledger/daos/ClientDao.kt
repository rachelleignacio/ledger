package com.rachelleignacio.ledger.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.rachelleignacio.ledger.models.Client

@Dao
interface ClientDao {

    @Query("SELECT * FROM clients")
    fun getAllClients(): List<Client>

    @Insert
    fun addClient(newClient: Client)

    @Update
    fun udpateClient(client: Client)
}