package com.example.viewmodel_exercise_1.ui.main.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.viewmodel_exercise_1.R
import com.example.viewmodel_exercise_1.ui.main.viewModel.MainViewModel
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    val viewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lifecycleScope.launch {
            viewModel.response.collect{ data ->
                val message = view?.findViewById<TextView>(R.id.message)
                if (message != null) {
                    "This is the size of the data ${data.size}, and the body for the first is ${data[0].body}".also { message.text = it }
                } else {
                    Log.d("MainFragment", "ERRORE!")
                }
            }
        }

        viewModel.retriveRepos()

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

}