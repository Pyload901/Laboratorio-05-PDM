package com.labos.laboratorio05diaz.ui.movie.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.labos.laboratorio05diaz.MovieReviewerApplication
import com.labos.laboratorio05diaz.data.model.MovieModel
import com.labos.laboratorio05diaz.repositories.MovieRepository

class MovieViewModel(val repository: MovieRepository): ViewModel() {
    var name = MutableLiveData("")
    var category = MutableLiveData("")
    var description = MutableLiveData("")
    var qualification = MutableLiveData("")
    var status = MutableLiveData("")
    fun getMovies() = repository.getMovie()
    private fun addMovie(movie: MovieModel) = repository.addMovie(movie)
    private fun validateLiveData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            category.value.isNullOrEmpty() -> return false
            description.value.isNullOrEmpty() -> return false
            qualification.value.isNullOrEmpty() -> return false
        }
        return true
    }
    fun createMovie() {
        if (!validateLiveData()) {
            status.value = WRONG_DATA
            return
        }
        val movie = MovieModel(
            name.value.toString(),
            category.value.toString(),
            description.value.toString(),
            qualification.value.toString()
        )
        addMovie(movie)
        status.value = MOVIE_CREATED
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    fun clearData () {
        name.value = ""
        category.value = ""
        description.value = ""
        qualification.value = ""
    }
    fun setSelectedMovie(movie: MovieModel) {
        name.value = movie.name
        category.value = movie.category
        description.value = movie.description
        qualification.value = movie.qualification
    }
    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }
        const val MOVIE_CREATED = "Movie created!"
        const val WRONG_DATA = "Wrong data!"
        const val INACTIVE = ""
    }
}