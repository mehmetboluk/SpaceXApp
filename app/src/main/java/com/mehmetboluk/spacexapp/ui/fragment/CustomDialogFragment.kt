package com.mehmetboluk.spacexapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.mehmetboluk.spacexapp.R
import com.mehmetboluk.spacexapp.ui.MainActivity
import kotlinx.android.synthetic.main.fragment_custom_dialog.view.*

class CustomDialogFragment : DialogFragment()  {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_custom_dialog, container, false)
        view.btnCancel.setOnClickListener {
            dismiss()
        }
        view.btnOkay.setOnClickListener {
            val year : String = view.etEnterYear.text.toString()
            (activity as MainActivity).year.postValue(year)
            dismiss()
        }
        return view
    }
}