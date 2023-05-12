package com.labos.laboratorio05diaz.ui.movie.moviedescription

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.labos.laboratorio05diaz.R
import com.labos.laboratorio05diaz.databinding.FragmentMovieDescriptionBinding
import com.labos.laboratorio05diaz.ui.movie.viewmodel.MovieViewModel


class MovieDescriptionFragment : Fragment() {
    private val viewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }
    private lateinit var binding: FragmentMovieDescriptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_description, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.viewModel?.clearData()
    }
}