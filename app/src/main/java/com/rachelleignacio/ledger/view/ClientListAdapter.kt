package com.rachelleignacio.ledger.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rachelleignacio.ledger.R
import com.rachelleignacio.ledger.data.models.Client
import kotlinx.android.synthetic.main.client_list_item.view.*

class ClientListAdapter : RecyclerView.Adapter<ClientViewHolder>() {
    private val clients = mutableListOf<Client>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ClientViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.client_list_item, parent, false))

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        holder.clientName.text = clients[position].name
    }

    override fun getItemCount() = clients.size

    fun updateFullList(newClientList: List<Client>) {
        clients.clear()
        clients.addAll(newClientList)
        notifyDataSetChanged()
    }

    fun addClient(newClient: Client) {
        val newItemIndex = clients.size
        clients.add(newItemIndex, newClient)
        notifyItemInserted(newItemIndex)
    }
}

class ClientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val clientName: TextView = itemView.client_name
}

