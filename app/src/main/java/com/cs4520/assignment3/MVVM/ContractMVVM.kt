package com.cs4520.assignment3.MVVM

interface ContractMVVM {
    interface Model {
        fun add(a : Double?, b : Double?)

        fun subtract(a : Double?, b : Double?)

        fun multiply(a : Double?, b : Double?)

        fun divide(a : Double?, b : Double?)

        fun setViewModel(viewModel: ViewModel)
    }
    interface ViewModel {
        fun addClicked(a: Double?, b: Double?)
        fun subtractClicked(a: Double?, b: Double?)
        fun multiplyClicked(a: Double?, b: Double?)
        fun divideClicked(a: Double?, b: Double?)

        fun sendClear()

        fun sendResult(result: Double)

        fun sendError(error: String)
    }
}