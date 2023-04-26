package com.labos.laboratorio05diaz

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView

class CardMovieAdapter(private val onClickMovie : (Movie) -> Unit): RecyclerView.Adapter<CardMovieAdapter.ViewHolder>() {
    private var movies : List<Movie> ?= null
     class ViewHolder(var view : View) : RecyclerView.ViewHolder(view) {
        fun bind(movie : Movie, onClickMovie: (Movie) -> Unit) {

            val card_movie_name = view.findViewById<TextView>(R.id.card_movie_name)
            val card_movie_photo = view.findViewById<ImageView>(R.id.card_movie_photo)
            val card_movie_calification = view.findViewById<TextView>(R.id.card_movie_calification)

            card_movie_name.text = movie.nombre
            card_movie_calification.text = "9.8"
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

    fun setMovies(movies:List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }

}