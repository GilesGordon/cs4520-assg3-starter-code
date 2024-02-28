package com.cs4520.assignment3.MVVM

class ModelMVVM() : ContractMVVM.Model {
    private lateinit var viewModel: ContractMVVM.ViewModel

    override fun add(a: Double?, b: Double?) {
        if (a != null && b != null) {
            viewModel.sendResult(a+b)
        } else {
            viewModel.sendError("There's a null input")
        }
        viewModel.sendClear()
    }

    override fun subtract(a: Double?, b: Double?) {
        if (a != null && b != null) {
            viewModel.sendResult(a-b)
        } else {
            viewModel.sendError("There's a null input")
        }
        viewModel.sendClear()
    }

    override fun multiply(a: Double?, b: Double?) {
        if (a != null && b != null) {
            viewModel.sendResult(a*b)
        } else {
            viewModel.sendError("There's a null input")
        }
        viewModel.sendClear()
    }

    override fun divide(a: Double?, b: Double?) {
        if (a == null || b == null) {
            viewModel.sendError("There's a null input")
        } else if (b == 0.0){
            viewModel.sendError("Can not divide by 0")
        } else {
            viewModel.sendResult(a/b)
        }
        viewModel.sendClear()
    }

    override fun setViewModel(viewModel: ContractMVVM.ViewModel) {
        this.viewModel = viewModel
    }
}