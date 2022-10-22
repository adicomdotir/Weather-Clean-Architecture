package com.example.weathercleanarchitecture.feature.mainscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.weathercleanarchitecture.R

class MainScreenFragment : Fragment() {
    private val weatherAdapter: WeatherAdapter by lazy {
        WeatherAdapter { index ->
            viewModel.processUiEvent(UiEvent.OnWeatherPointClicked(index))
        }
    }
    private val progressBar: ProgressBar by lazy { requireActivity().findViewById(R.id.progressBar) }
    private val recyclerView: RecyclerView by lazy { requireActivity().findViewById(R.id.rvWeatherPoints) }
    private val viewModel: MainScreenViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, ::render)
        recyclerView.adapter = weatherAdapter
    }

    private fun render(viewState: ViewState) {
        weatherAdapter.setData(viewState.weatherPointsShown)
        progressBar.isVisible = viewState.isLoading
    }

}