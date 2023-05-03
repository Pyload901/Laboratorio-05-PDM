package com.labos.laboratorio05diaz.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.labos.laboratorio05diaz.R
import com.labos.laboratorio05diaz.data.model.movies
import com.labos.laboratorio05diaz.databinding.FragmentBillboardBinding


class BillboardFragment : Fragment() {
    private lateinit var binding : FragmentBillboardBinding
    private val viewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_billboard, container, false)
//        return inflater.inflate(R.layout.fragment_billboard, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var adapter = CardMovieAdapter{
            findNavController().navigate(R.id.action_billboard_to_movie_description)
        }
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        binding.recyclerCardMovie.adapter = adapter
        adapter.setMovies(movies)
        addListener(view)
    }
    private fun addListener(view : View) {
        binding.actionAdd.setOnClickListener {
            view.findNavController().navigate(R.id.action_billboard_to_add_new_movie)
        }
    }


}