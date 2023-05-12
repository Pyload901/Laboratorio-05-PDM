package com.labos.laboratorio05diaz.ui.movie.billboard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.labos.laboratorio05diaz.data.model.MovieModel
import com.labos.laboratorio05diaz.databinding.FragmentMovieItemBinding

class MovieRecyclerViewHolder(private val binding: FragmentMovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: MovieModel, clickListener: (MovieModel) -> Unit) {
        binding.cardMovieName.text = movie.name;
        binding.cardMovieCalification.text = movie.qualification
        binding.cardMovieItem.setOnClickListener{
            clickListener(movie);
        }
    }
}