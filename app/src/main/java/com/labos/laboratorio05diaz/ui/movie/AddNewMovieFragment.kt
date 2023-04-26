package com.labos.laboratorio05diaz.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.labos.laboratorio05diaz.R
import com.labos.laboratorio05diaz.data.model.MovieModel
import com.labos.laboratorio05diaz.databinding.FragmentAddNewMovieBinding

class AddNewMovieFragment : Fragment() {
    private lateinit var binding: FragmentAddNewMovieBinding
    private val viewModel: MovieViewModel by activityViewModels{
        MovieViewModel.Factory
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_new_movie, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        addListener()
    }
    fun addListener () {
        binding.actionSubmit.setOnClickListener {
            var movie = MovieModel(
                binding.nameInput.text.toString(),
                binding.categoryInput.text.toString(),
                binding.descriptionInput.text.toString(),
                binding.calificationInput.text.toString()
            )
            viewModel.addMovie(movie)
            Toast.makeText(this.context, "You added a movie!", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
        }
    }

}