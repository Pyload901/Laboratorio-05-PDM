package com.labos.laboratorio05diaz.ui.movie.billboard.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.labos.laboratorio05diaz.R
import com.labos.laboratorio05diaz.data.model.MovieModel
import com.labos.laboratorio05diaz.databinding.FragmentMovieItemBinding

class MovieRecyclerViewAdapter(private val clickListener : (MovieModel) -> Unit): RecyclerView.Adapter<MovieRecyclerViewHolder>() {
    private var movies = ArrayList<MovieModel>()
     class ViewHolder(var view : View) : RecyclerView.ViewHolder(view) {

    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = FragmentMovieItemBinding.inflate(inflater, parent, false)
        return MovieRecyclerViewHolder(view)
    }
    override fun onBindViewHolder(holder: MovieRecyclerViewHolder, position: Int) {
        holder.bind(movies[position], clickListener)
    }

    fun setMovies(movies:List<MovieModel>) {
        this.movies.clear()
        this.movies.addAll(movies)
//        notifyDataSetChanged()
    }

}