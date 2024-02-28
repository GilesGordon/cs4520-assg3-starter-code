package com.cs4520.assignment3.MVVM

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.cs4520.assignment3.databinding.FragmentMVVMBinding


/**
 * A simple [Fragment] subclass.
 * Use the [MVVMFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MVVMFragment : Fragment() {

    private lateinit var binding: FragmentMVVMBinding
    private var viewModel: ViewModel = ViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMVVMBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addButtonMvvm.setOnClickListener() {
            viewModel.addClicked(binding.input1Mvvm.text.toString().toDoubleOrNull(),
                binding.input2Mvvm.text.toString().toDoubleOrNull())
        }
        binding.subtractButtonMvvm.setOnClickListener() {
            viewModel.subtractClicked(binding.input1Mvvm.text.toString().toDoubleOrNull(),
                binding.input2Mvvm.text.toString().toDoubleOrNull())
        }
        binding.multiplyButtonMvvm.setOnClickListener() {
            viewModel.multiplyClicked(binding.input1Mvvm.text.toString().toDoubleOrNull(),
                binding.input2Mvvm.text.toString().toDoubleOrNull())
        }
        binding.divideButtonMvvm.setOnClickListener() {
            viewModel.divideClicked(binding.input1Mvvm.text.toString().toDoubleOrNull(),
                binding.input2Mvvm.text.toString().toDoubleOrNull())
        }
        viewModel.data.observe(viewLifecycleOwner, Observer { newData ->
            if(newData.clear) {
                binding.input1Mvvm.text.clear()
                binding.input2Mvvm.text.clear()
            }
            if(newData.error != null) {
                Toast.makeText(activity, newData.error, Toast.LENGTH_SHORT).show()
            }
            if(newData.result != null) {
                binding.resultMvvm.text = newData.result
            }
        })
    }
}