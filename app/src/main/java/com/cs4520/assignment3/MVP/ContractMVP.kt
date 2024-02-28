package com.cs4520.assignment3.MVP

interface ContractMVP {
    interface View {
        fun clearInputs()

        fun displayResult(result: Double)

        fun displayError(error: String)
    }
    interface Model {
        fun add(a : Double?, b : Double?)

        fun subtract(a : Double?, b : Double?)

        fun multiply(a : Double?, b : Double?)

        fun divide(a : Double?, b : Double?)

        fun setPresenter(presenter: Presenter)
    }
    interface Presenter {
        fun addClicked(a : Double?, b : Double?)
        fun subtractClicked(a : Double?, b : Double?)
        fun multiplyClicked(a : Double?, b : Double?)
        fun divideClicked(a : Double?, b : Double?)

        fun sendClear()

        fun sendResult(result: Double)

        fun sendError(error: String)
    }
}