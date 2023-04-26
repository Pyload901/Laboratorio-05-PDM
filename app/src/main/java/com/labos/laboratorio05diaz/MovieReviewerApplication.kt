package com.labos.laboratorio05diaz

import android.app.Application
import com.labos.laboratorio05diaz.data.model.movies
import com.labos.laboratorio05diaz.repositories.MovieRepository

class MovieReviewerApplication: Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}