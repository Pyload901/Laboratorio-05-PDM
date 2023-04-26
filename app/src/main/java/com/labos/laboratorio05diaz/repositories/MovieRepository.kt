package com.labos.laboratorio05diaz.repositories

import com.labos.laboratorio05diaz.data.model.MovieModel

class MovieRepository(val movies: MutableList<MovieModel>) {
    fun getMovie() = movies
    fun addMovie(movie : MovieModel) {
        movies.add(movie)
    }
}