package com.example.carcom.binding

import android.os.Looper
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.example.carcom.model.CarDetail
import com.example.carcom.ui.adapter.AdapterCarsDetail

object BindingAdapters {
    @JvmStatic
    @BindingAdapter(value = ["loadImage"], requireAll = false)
    fun loadImage(view: ImageView, url: String?) {
        url?.let {
            Glide.with(view.context)
                .load(url.replace("{0}", "800x600"))
                .placeholder(android.R.color.darker_gray)
                .apply(
                    RequestOptions().transform(
                        MultiTransformation(
                            CenterCrop()
                        )
                    )
                )
                .into(view)
        }
    }

    @JvmStatic
    @BindingAdapter(value = ["setUpRecyclerCarDetail","indicatorCar"])
    fun setUpRecyclerCarDetailList(view: ViewPager2?, carList: List<String>?, indicator:me.relex.circleindicator.CircleIndicator3) {
        if (view?.adapter == null || (view?.adapter as AdapterCarsDetail).itemCount == 0) {
            val adapterBanners = carList?.let { AdapterCarsDetail(it) }
            view?.adapter = adapterBanners
            val handler = android.os.Handler(Looper.getMainLooper())
            view?.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    handler.removeMessages(0)
                    val runnable = Runnable { view.currentItem = position + 1 }
                    val run = Runnable { view.currentItem = 0 }
                    if (carList?.size == position +1){
                        handler.postDelayed(run, 10000)
                    }
                    if (position < view.adapter?.itemCount ?: 0) {
                        handler.postDelayed(runnable, 10000)
                    }
                }

            })
            indicator.setViewPager(view)
            (view?.adapter as AdapterCarsDetail?)?.notifyDataSetChanged()
        }
    }

}