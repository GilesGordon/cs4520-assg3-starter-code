package com.cs4520.assignment3.MVP

class Presenter(private val view: ContractMVP.View,
                private val modelMVP: ContractMVP.Model = ModelMVP()
) : ContractMVP.Presenter {

    init {
        modelMVP.setPresenter(this)
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
        view.clearInputs()
    }

    override fun sendResult(result: Double) {
        view.displayResult(result)
    }

    override fun sendError(error: String) {
        view.displayError(error)
    }
}