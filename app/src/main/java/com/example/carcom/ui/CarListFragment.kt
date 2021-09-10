package com.example.carcom.ui

import android.content.ContentValues.TAG
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.carcom.R
import com.example.carcom.base.BaseFragment
import com.example.carcom.databinding.CarListFragmentBinding
import com.example.carcom.interfaces.ICar
import com.example.carcom.interfaces.IFilter
import com.example.carcom.model.Car
import com.example.carcom.ui.adapter.AdapterCarList
import com.example.carcom.util.DefaultCarUtil
import com.example.carcom.util.EndlessGridRecyclerOnScrollListener

class CarListFragment : BaseFragment<CarListViewModel, CarListFragmentBinding>() {
    override val getLayoutId: Int = R.layout.car_list_fragment
    override val viewModelClass: Class<CarListViewModel> = CarListViewModel::class.java
    var carList: ArrayList<Car> = arrayListOf()
    private var page = 20
    private var endlessScrollListener: EndlessGridRecyclerOnScrollListener? = null
    private val adapter = AdapterCarList(carList, object : ICar {
        override fun carId(id: Long) {
            val bundle = Bundle()
            bundle.putLong(DefaultCarUtil.CAR_ID, id)
            NavHostFragment.findNavController(this@CarListFragment)
                .navigate(R.id.action_car_to_carDetail, bundle)
        }

    })

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
        init()
        observe()
        initRecycler()
    }

    private fun init() {
        viewModel.getCars()
    }

    private fun observe() {
        viewModel.carList.observe(this, Observer { listCar ->
            carList.clear()
            carList.addAll(listCar)
            adapter.notifyDataSetChanged()
        })
    }

    private fun initRecycler() {
        binding.carListRecycler.adapter = adapter
        binding.carListRecycler.setHasFixedSize(true)
        endlessScrollListener = object :
            EndlessGridRecyclerOnScrollListener(binding.carListRecycler.layoutManager as GridLayoutManager) {
            override fun onLoadMore() {
                if (carList.size > 19) {
                    loadMoreCars()
                }
            }

        }
        binding.carListRecycler.addOnScrollListener(endlessScrollListener as EndlessGridRecyclerOnScrollListener)

    }

    private fun loadMoreCars() {
        page += 10
        viewModel.getCarsMore(page)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.car_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item?.itemId) {
            R.id.car_filter_menu -> {
                val filterFragment = FilterFragment( object :IFilter{
                    override fun onYearFilter() {
                        viewModel.getCars()
                    }

                })
                activity?.supportFragmentManager?.let { it1 ->
                    filterFragment.show(it1, TAG)
                }
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }


}