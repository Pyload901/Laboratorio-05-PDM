package com.labos.laboratorio05diaz.ui.movie.billboard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.labos.laboratorio05diaz.R
import com.labos.laboratorio05diaz.data.model.MovieModel
import com.labos.laboratorio05diaz.data.model.movies
import com.labos.laboratorio05diaz.databinding.FragmentBillboardBinding
import com.labos.laboratorio05diaz.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter
import com.labos.laboratorio05diaz.ui.movie.viewmodel.MovieViewModel


class BillboardFragment : Fragment() {
    private lateinit var binding : FragmentBillboardBinding
    private lateinit var adapter: MovieRecyclerViewAdapter
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

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        addListener(view)

        setRecyclerView(view)
    }
    private fun setRecyclerView(view: View) {
        binding.recyclerCardMovie.layoutManager = LinearLayoutManager(view.context)
        adapter = MovieRecyclerViewAdapter{
            viewModel.name.value = it.name
            viewModel.category.value = it.category
            viewModel.qualification.value = it.qualification
            viewModel.description.value = it.description
            Log.d("APP_TAG", it.toString())
            showSelectedMovie(it)
        }
        binding.recyclerCardMovie.adapter = adapter
        showMovies()
    }
    private fun addListener(view : View) {
        binding.actionAdd.setOnClickListener {
            view.findNavController().navigate(R.id.action_billboard_to_add_new_movie)
        }
    }
    private fun showMovies() {
        adapter.setMovies(movies)
        adapter.notifyDataSetChanged()
    }
    private fun showSelectedMovie(movie: MovieModel) {
        viewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_billboard_to_movie_description)
    }
}