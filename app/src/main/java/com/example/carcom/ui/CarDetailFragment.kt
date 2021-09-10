package com.example.carcom.ui

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.example.carcom.R
import com.example.carcom.base.BaseFragment
import com.example.carcom.databinding.CarDetailFragmentBinding
import com.example.carcom.model.CarDetail
import com.example.carcom.util.DefaultCarUtil

class CarDetailFragment : BaseFragment<CarDetailViewModel,CarDetailFragmentBinding>() {
    override val getLayoutId: Int = R.layout.car_detail_fragment
    override val viewModelClass: Class<CarDetailViewModel> = CarDetailViewModel::class.java
    private var carId: Long? = 0L
    private var carDetail:CarDetail? = null
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        observe()
    }

   private fun init(){
        arguments.let {
            carId = arguments?.getLong(DefaultCarUtil.CAR_ID)
            viewModel.getCarDetail(carId)
        }

       binding.detailFragmentCarDetailsButton.setOnClickListener {
            setProperties()
           binding.detailFragmentCarDetailsButton.setBackgroundColor(ContextCompat.getColor(context!!, android.R.color.white))
           binding.detailFragmentCarDetailsButton.setTextColor(ContextCompat.getColor(context!!, android.R.color.holo_orange_dark))
           binding.detailFragmentDescriptionButton.setBackgroundColor(ContextCompat.getColor(context!!, android.R.color.holo_orange_dark))
           binding.detailFragmentDescriptionButton.setTextColor(ContextCompat.getColor(context!!, android.R.color.white))
       }
       binding.detailFragmentDescriptionButton.setOnClickListener {
           setExplanations()
           binding.detailFragmentDescriptionButton.setBackgroundColor(ContextCompat.getColor(context!!, android.R.color.white))
           binding.detailFragmentDescriptionButton.setTextColor(ContextCompat.getColor(context!!, android.R.color.holo_orange_dark))
           binding.detailFragmentCarDetailsButton.setBackgroundColor(ContextCompat.getColor(context!!, android.R.color.holo_orange_dark))
           binding.detailFragmentCarDetailsButton.setTextColor(ContextCompat.getColor(context!!, android.R.color.white))
       }
   }

    private fun observe(){
        viewModel.carDetail.observe(this, Observer {
            binding.data = it
            carDetail = it
            setProperties()
        })
    }

    private fun setProperties(){
        binding.detailFragmentPropertiesContainer.carPropertiesLayout.visibility = View.VISIBLE
        binding.detailFragmentExplanationsContainer.explanationLayout.visibility = View.GONE
        binding.detailFragmentPropertiesContainer.propertiesPriceTextView.text = carDetail?.priceFormatted
        binding.detailFragmentPropertiesContainer.propertiesDateTextView.text = carDetail?.dateFormatted
        binding.detailFragmentPropertiesContainer.propertiesModelTextView.text = carDetail?.modelName
        binding.detailFragmentPropertiesContainer.propertiesYearTextView.text = carDetail?.properties?.get(2)?.value
        binding.detailFragmentPropertiesContainer.propertiesGearTextView.text = carDetail?.properties?.get(3)?.value
        binding.detailFragmentPropertiesContainer.propertiesFuelTextView.text = carDetail?.properties?.get(4)?.value
        binding.detailFragmentPropertiesContainer.propertiesColorTextView.text = carDetail?.properties?.get(1)?.value
        binding.detailFragmentPropertiesContainer.propertiesKilometerTextView.text = carDetail?.properties?.get(0)?.value

    }

    private fun setExplanations(){
        binding.detailFragmentExplanationsContainer.explanationLayout.visibility = View.VISIBLE
        binding.detailFragmentExplanationsContainer.explanationFragmentTextView.text = carDetail?.text
        binding.detailFragmentPropertiesContainer.carPropertiesLayout.visibility = View.GONE
    }



}