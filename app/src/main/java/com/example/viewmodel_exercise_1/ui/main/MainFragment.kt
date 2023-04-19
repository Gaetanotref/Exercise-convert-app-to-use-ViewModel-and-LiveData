package com.example.viewmodel_exercise_1.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.example.viewmodel_exercise_1.R
import com.example.viewmodel_exercise_1.ui.main.viewModel.MainViewModel
import kotlinx.coroutines.launch

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        lifecycleScope.launch {
            viewModel.response.collect { data ->
                val message = view?.findViewById<TextView>(R.id.message)
                if (message != null) {
                    "${data.body()?.get(0)?.body}".also { message.text = it }
                } else {
                    Log.d("MainFragment", "ERRORE!")
                }
            }
        }


        viewModel.retriveRepos()

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

}