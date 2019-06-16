package com.grosalex.nasaapi.presenter

import com.grosalex.nasaapi.contract.ApodContract
import com.grosalex.nasaapi.model.Apod
import java.util.*
import java.text.SimpleDateFormat

class ApodPresenter(val view: ApodContract.View, val provider: ApodContract.Provider) : ApodContract.Presenter,
    ApodContract.Provider.OnProvide {

    private var count =0
    private val format = SimpleDateFormat(DATE_PATTERN)
    private val today = Calendar.getInstance().time

    override fun loadThirtyDays() {
        view.load()
        count = 0
        provider.getApod(format.format(today), this)

    }

    override fun onSuccess(apod: Apod) {
        view.add(apod)
        if (shouldLoadNext(apod.date)) {
            val date = format.parse(apod.date)
            val calendar = Calendar.getInstance()
            calendar.time = date
            calendar.add(Calendar.DATE, -1)
            val yesterday = calendar.time
            provider.getApod(format.format(yesterday), this)
        }
    }

    override fun onFailure(message: String) {
        view.onError(message)
    }

    override fun shouldLoadNext(oldDate: String): Boolean {
/*        val date = format.parse(oldDate)
        return getDaysDifference(date, today) < DAYS_TO_LOAD*/
        count++
        return count < DAYS_TO_LOAD
    }

    private fun getDaysDifference(fromDate: Date?, toDate: Date?): Long {
        return if (fromDate == null || toDate == null) 0 else ((toDate.time - fromDate.time) / (1000 * 60 * 60 * 24))
    }

    companion object {
        const val DAYS_TO_LOAD = 9
        const val DATE_PATTERN = "YYYY-MM-dd"
    }
}