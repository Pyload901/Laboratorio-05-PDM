package com.labos.laboratorio05diaz.ui.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.labos.laboratorio05diaz.R
import com.labos.laboratorio05diaz.data.model.MovieModel

class CardMovieAdapter(private val onClickMovie : (MovieModel) -> Unit): RecyclerView.Adapter<CardMovieAdapter.ViewHolder>() {
    private var movies : List<MovieModel> ?= null
     class ViewHolder(var view : View) : RecyclerView.ViewHolder(view) {
        fun bind(movie : MovieModel, onClickMovie: (MovieModel) -> Unit) {

            val card_movie_name = view.findViewById<TextView>(R.id.card_movie_name)
            val card_movie_photo = view.findViewById<ImageView>(R.id.card_movie_photo)
            val card_movie_calification = view.findViewById<TextView>(R.id.card_movie_calification)

            card_movie_name.text = movie.name
            card_movie_calification.text = movie.qualification
            view.setOnClickListener{
                onClickMovie(movie)
            }
        }
    }

    override fun getItemCount(): Int {
        return movies?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflater = LayoutInflater.from(parent.context)

        var view = inflater.inflate(R.layout.fragment_card_movie, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        movies?.let {
            holder.bind(it[position], onClickMovie)
        }
    }

    fun setMovies(movies:List<MovieModel>) {
        this.movies = movies
        notifyDataSetChanged()
    }

}