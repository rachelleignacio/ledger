package com.rachelleignacio.ledger.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rachelleignacio.ledger.R

fun newInvoiceListFragment() = InvoiceListFragment()

class InvoiceListFragment internal constructor() : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_invoice_list, container, false)
}