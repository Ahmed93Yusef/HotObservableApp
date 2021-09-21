package com.example.hotobservableapp.ui

import android.view.LayoutInflater
import com.example.hotobservableapp.databinding.FragmentTopBinding
import com.example.hotobservableapp.util.Constant


class TopFragment : BaseFragment<FragmentTopBinding>() {
    override val bindingInflater: (LayoutInflater) -> FragmentTopBinding
        get() = FragmentTopBinding::inflate
    private lateinit var receiveData: String
    override fun setup() {
        receiveData = arguments?.getString(Constant.KEY_EDIT_TEXT) ?: ""
        binding?.outputText?.text = receiveData
        super.onStart()
    }



}