package com.cs4520.assignment3.MVP

class ModelMVP() : ContractMVP.Model {

    private lateinit var presenter: ContractMVP.Presenter

    override fun add(a: Double?, b: Double?) {
        if (a != null && b != null) {
            presenter.sendResult(a+b)
        } else {
            presenter.sendError("There's a null input")
        }
        presenter.sendClear()
    }

    override fun subtract(a: Double?, b: Double?) {
        if (a != null && b != null) {
            presenter.sendResult(a-b)
        } else {
            presenter.sendError("There's a null input")
        }
        presenter.sendClear()
    }

    override fun multiply(a: Double?, b: Double?) {
        if (a != null && b != null) {
            presenter.sendResult(a*b)
        } else {
            presenter.sendError("There's a null input")
        }
        presenter.sendClear()
    }

    override fun divide(a: Double?, b: Double?) {
        if (a == null || b == null) {
            presenter.sendError("There's a null input")
        } else if (b == 0.0){
            presenter.sendError("Can not divide by 0")
        } else {
            presenter.sendResult(a/b)
        }
        presenter.sendClear()
    }

    override fun setPresenter(presenter: ContractMVP.Presenter) {
        this.presenter = presenter
    }
}