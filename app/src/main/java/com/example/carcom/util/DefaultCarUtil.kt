package com.example.carcom.util

import com.example.carcom.model.Filter
import com.example.carcom.model.Sort

object DefaultCarUtil {
    const val DEFAULT_MIN_YEAR = 1990
    const val DEFAULT_MAX_YEAR = 2021
    const val DEFAULT_MIN_DATE = "1990-11-05T00:00:00"
    const val DEFAULT_MAX_DATE = "2021-09-09T00:00:00"
    const val DEFAULT_SORT = 1
    const val DEFAULT_SORT_DIRECTION = 0
    const val CAR_ID = "CAR_ID"


    var filter = Filter(DEFAULT_MIN_DATE, DEFAULT_MAX_DATE, DEFAULT_MIN_YEAR, DEFAULT_MAX_YEAR)
    var sort = Sort(DEFAULT_SORT, DEFAULT_SORT_DIRECTION)

    fun setSort(_sort:Int,_sortDirection:Int):Sort{
        sort.sort = _sort
        sort.sortDirection = _sortDirection
        return sort
    }

    fun setFilter(_minYear:String,_maxYear:String):Filter{
        filter.minYear = _minYear.toInt()
        filter.maxYear = _maxYear.toInt()
        return filter
    }
}