package com.example.hotobservableapp.ui

import android.util.Log
import android.view.LayoutInflater
import androidx.core.widget.doOnTextChanged
import com.example.hotobservableapp.databinding.FragmentBottomBinding
import com.example.hotobservableapp.util.Communicator
import com.example.hotobservableapp.util.Constant
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit


class BottomFragment : BaseFragment<FragmentBottomBinding>() {
    private lateinit var dataConnect: Communicator
    override val bindingInflater: (LayoutInflater) -> FragmentBottomBinding
        get() = FragmentBottomBinding::inflate

    override fun setup() {
        dataConnect = activity as Communicator
        setData()
    }
    private fun setData(){
        val observable =Observable.create<String>{ data ->
            binding?.inputText?.doOnTextChanged { t1, _, _, _ ->
                data.onNext(t1.toString())
            }
        }.debounce(1500, TimeUnit.MILLISECONDS).publish()
        observable.connect()
        observable.subscribe(
            {l1 ->
                dataConnect.passData(l1)
            },
            {e->
                Log.i(Constant.LOG_TAG,"onError ${e.message}")
            }
        )
    }
}