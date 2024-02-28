package com.cs4520.assignment3.MVP

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.cs4520.assignment3.databinding.FragmentMVPBinding

/**
 * A simple [Fragment] subclass.
 * Use the [MVPFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MVPFragment : Fragment(), ContractMVP.View {

    private lateinit var binding: FragmentMVPBinding
    private var presenter: ContractMVP.Presenter = Presenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMVPBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addButtonMvp.setOnClickListener() {
            presenter.addClicked(binding.input1Mvp.text.toString().toDoubleOrNull(),
                binding.input2Mvp.text.toString().toDoubleOrNull())
        }
        binding.subtractButtonMvp.setOnClickListener() {
            presenter.subtractClicked(binding.input1Mvp.text.toString().toDoubleOrNull(),
                binding.input2Mvp.text.toString().toDoubleOrNull())
        }
        binding.multiplyButtonMvp.setOnClickListener() {
            presenter.multiplyClicked(binding.input1Mvp.text.toString().toDoubleOrNull(),
                binding.input2Mvp.text.toString().toDoubleOrNull())
        }
        binding.divideButtonMvp.setOnClickListener() {
            presenter.divideClicked(binding.input1Mvp.text.toString().toDoubleOrNull(),
                binding.input2Mvp.text.toString().toDoubleOrNull())
        }
    }

    override fun clearInputs() {
        binding.input1Mvp.text.clear()
        binding.input2Mvp.text.clear()
    }

    override fun displayResult(result: Double) {
        binding.resultMvp.text = result.toString()
    }

    override fun displayError(error: String) {
        Toast.makeText(activity, error, Toast.LENGTH_SHORT).show()
    }
}