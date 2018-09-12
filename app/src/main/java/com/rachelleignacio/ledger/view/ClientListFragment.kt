package com.rachelleignacio.ledger.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.rachelleignacio.ledger.R
import com.rachelleignacio.ledger.daggerComponent
import com.rachelleignacio.ledger.data.daos.AppDatabase
import com.rachelleignacio.ledger.data.models.Client
import com.rachelleignacio.ledger.viewmodel.ClientListViewModel
import com.rachelleignacio.ledger.viewmodel.intents.ClientListIntent
import com.rachelleignacio.ledger.viewmodel.viewstates.ClientListViewState
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_client_list.view.*
import javax.inject.Inject

fun newClientListFragment() = ClientListFragment()

class ClientListFragment internal constructor() : Fragment(), ClientListView {

    private val intentPublisher = PublishSubject.create<ClientListIntent>()
    private val onAddClientListener = PublishSubject.create<Client>()
    private var disposables = CompositeDisposable()
    private val clientListAdapter = ClientListAdapter()

    @Inject
    lateinit var appDatabase: AppDatabase

    @Inject
    lateinit var viewModel: ClientListViewModel

//    @BindView(R.id.client_list)
    private var clientList: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_client_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ButterKnife.bind(view)
        daggerComponent.inject(this)
        initClientList(view)
        subscribeViewModel()
        observeViewModel()
        initAddClientClickListner(view)
    }

    private fun initAddClientClickListner(view: View) {
        view.add_new_client_icon.setOnClickListener(onAddClientClickListener)
        view.add_new_client_text.setOnClickListener(onAddClientClickListener)
    }

    private fun initClientList(view: View) {
        clientList = view.client_list
        clientList?.setup()
    }

    private fun RecyclerView.setup() {
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(activity)
    }

    private val onAddClientClickListener = View.OnClickListener {
        newAddClientDialogFragment(onAddClientListener).show(fragmentManager, ADD_CLIENT_DIALOG_FRAGMENT_TAG)
    }

    private fun subscribeViewModel() {
        intents()
                .subscribeOn(Schedulers.io())
                .startWith(ClientListIntent.LoadAllClients(appDatabase))
                .subscribe(viewModel::process, ::renderError)
                .addTo(disposables)
    }

    private fun observeViewModel() {
        viewModel
                .viewStates()
                .distinctUntilChanged()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::render, ::renderError)
                .addTo(disposables)
    }

    override fun intents(): Observable<ClientListIntent> =
            intentPublisher
                    .mergeWith(onAddClientListener.map { ClientListIntent.AddClient(appDatabase, it) })
                    .subscribeOn(Schedulers.io())

    override fun render(viewState: ClientListViewState) {
        when (viewState) {
            is ClientListViewState.ClientsLoaded -> showClientList(viewState.clientList)
            is ClientListViewState.Error -> renderError(viewState.error)
        }
    }

    private fun showClientList(clients: List<Client>) {
        clientList?.adapter = null
        clientListAdapter.updateFullList(clients)
        clientList?.adapter = clientListAdapter
    }

    private fun renderError(throwable: Throwable) {
        Toast.makeText(activity, throwable.message, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }
}