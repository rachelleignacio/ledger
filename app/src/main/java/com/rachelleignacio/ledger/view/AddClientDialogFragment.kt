package com.rachelleignacio.ledger.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.rachelleignacio.ledger.utils.Keyboard
import com.rachelleignacio.ledger.R
import com.rachelleignacio.ledger.data.models.Client
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.dialog_fragment_add_client.view.*

const val ADD_CLIENT_DIALOG_FRAGMENT_TAG = "AddDialogFragmentTag"
fun newAddClientDialogFragment(intentPublisher: PublishSubject<Client>) =
        AddClientDialogFragment().apply { addClientPublisher = intentPublisher }

class AddClientDialogFragment internal constructor() : DialogFragment() {

    internal lateinit var addClientPublisher: PublishSubject<Client>

    private lateinit var editTextBox: EditText

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val context = activity as Context
        val view = LayoutInflater.from(context).inflate(R.layout.dialog_fragment_add_client, null)
        editTextBox = view.add_client_edittext
        editTextBox.apply {
            requestFocus()
            Keyboard.show(context, view)
            setOnEditorActionListener { _, actionId, _ ->
                var handled = false
                if (actionId == EditorInfo.IME_ACTION_GO) {
                    (dialog as AlertDialog).getButton(AlertDialog.BUTTON_POSITIVE).callOnClick()
                    handled = true
                }
                handled
            }
        }

        val dialog =
                AlertDialog.Builder(context)
                        .setup(view)
                        .create()
        return dialog.apply {
            setOnShowListener {
                getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener { dismiss() }
                getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                    val listName = editTextBox.text.toString()
                    if (listName.isEmpty()) {
                        Toast.makeText(activity, getString(R.string.add_client_error_toast_message), Toast.LENGTH_SHORT).show()
                    } else {
                        Keyboard.hide(context, editTextBox)
                        addClientPublisher.onNext(Client(name = editTextBox.text.toString()))
                        dismiss()
                    }
                }
            }
        }
    }

    private fun AlertDialog.Builder.setup(view: View) = apply {
        setView(view)
        setNegativeButton(android.R.string.cancel, null)
        setPositiveButton(R.string.add_client_submit_text, null)
    }
}