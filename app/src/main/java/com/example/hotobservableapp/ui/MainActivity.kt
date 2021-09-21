package com.example.hotobservableapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hotobservableapp.R
import com.example.hotobservableapp.databinding.ActivityMainBinding
import com.example.hotobservableapp.util.Communicator
import com.example.hotobservableapp.util.Constant

class MainActivity : AppCompatActivity(),Communicator {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myTopFragment: TopFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun passData(editTextInput: String) {
        myTopFragment = TopFragment()
        val bundle = Bundle()
        bundle.putString(Constant.KEY_EDIT_TEXT,editTextInput)
        myTopFragment.arguments = bundle
        this.supportFragmentManager.beginTransaction().replace(R.id.top_container, myTopFragment).commit()
    }
}