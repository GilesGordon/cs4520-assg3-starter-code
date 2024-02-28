package com.cs4520.assignment3.MVVM

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cs4520.assignment3.MVP.ModelMVP

class ViewModel(private val modelMVP: ContractMVVM.Model = ModelMVVM()) : ContractMVVM.ViewModel {

    private val resultData = MutableLiveData<ResultData>()
    val data: LiveData<ResultData> = resultData
    init {
        modelMVP.setViewModel(this)
    }

    override fun addClicked(a: Double?, b: Double?) {
        modelMVP.add(a, b)
    }

    override fun subtractClicked(a: Double?, b: Double?) {
        modelMVP.subtract(a, b)
    }

    override fun multiplyClicked(a: Double?, b: Double?) {
        modelMVP.multiply(a, b)
    }

    override fun divideClicked(a: Double?, b: Double?) {
        modelMVP.divide(a, b)
    }

    override fun sendClear() {
        resultData.value= ResultData(true, null, null)
    }

    override fun sendResult(result: Double) {
        resultData.value=ResultData(false, result.toString(), null)
    }

    override fun sendError(error: String) {
        resultData.value=ResultData(false, null, error)
    }
}