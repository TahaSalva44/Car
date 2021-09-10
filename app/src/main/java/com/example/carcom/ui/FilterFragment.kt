package com.example.carcom.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.carcom.R
import com.example.carcom.databinding.FragmentFilterBinding
import com.example.carcom.interfaces.IFilter
import com.example.carcom.util.DefaultCarUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FilterFragment(val iFilter: IFilter) : BottomSheetDialogFragment() {

    lateinit var binding: FragmentFilterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_filter, container, false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.filterFragmentApplyFilterButton.setOnClickListener {
            DefaultCarUtil.setFilter(
                binding.oldestYear.text.toString(),
                binding.newYear.text.toString()
            )
            iFilter.onYearFilter()
            dismiss()
        }


    }


}