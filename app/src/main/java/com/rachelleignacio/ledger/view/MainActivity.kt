package com.rachelleignacio.ledger.view

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.rachelleignacio.ledger.R
import kotlinx.android.synthetic.main.activity_main.*

private const val CONTENT_FRAME_ID = R.id.fragment_container
private const val BACKSTACK_NAME = "MainActivityFragmentStack"

class MainActivity : AppCompatActivity() {

    private val clientListFragment = newClientListFragment()
    private val invoiceListFragment = newInvoiceListFragment()

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_clients -> {
                showFragment(clientListFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_invoices -> {
                showFragment(invoiceListFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_packages -> {
                showFragment(invoiceListFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(CONTENT_FRAME_ID, fragment)
                .addToBackStack(BACKSTACK_NAME)
                .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.selectedItemId = R.id.navigation_clients
    }
}
