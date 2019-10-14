package com.alex.roomworkshop.ui.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDialogFragment
import com.alex.roomworkshop.R
import kotlinx.android.synthetic.main.dialog_fragment_confirmation.*
import kotlinx.android.synthetic.main.dialog_fragment_confirmation.view.*

class CustomDialogFragment(
    private val title: String,
    private val positiveText: String,
    private val negativeText: String,
    private val negativeAction: (() -> Unit)? = null,
    private val positiveAction: ((String) -> Unit)? = null
) : AppCompatDialogFragment() {

    init {
        retainInstance = true
    }

    override fun getTheme() = R.style.AppTheme_DialogFragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dialog_fragment_confirmation, container)
        initViews(view)
        initClickListeners(view)
        return view
    }

    override fun onDestroyView() {
        dialog?.apply {
            if (retainInstance) {
                setDismissMessage(null)
            }
        }
        super.onDestroyView()
    }

    private fun initViews(view: View) {
        view.confirmationTitle.text = title
        view.cancelButton.text = negativeText
        view.confirmButton.text = positiveText
    }

    private fun initClickListeners(view: View) {
        view.confirmButton.setOnClickListener {
            val textInput = dialogInput?.text?.toString()
            textInput?.let { positiveAction?.invoke(it) }
            dismiss()
        }
        view.cancelButton.setOnClickListener {
            negativeAction?.invoke()
            dismiss()
        }
    }
}
