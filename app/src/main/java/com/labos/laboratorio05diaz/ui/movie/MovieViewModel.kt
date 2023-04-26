package com.labos.laboratorio05diaz.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.labos.laboratorio05diaz.MovieReviewerApplication
import com.labos.laboratorio05diaz.data.model.MovieModel
import com.labos.laboratorio05diaz.repositories.MovieRepository

class MovieViewModel(val repository: MovieRepository): ViewModel() {
    fun getMovies() = repository.getMovie()
    fun addMovie(movie: MovieModel) = repository.addMovie(movie)
    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }
    }
}