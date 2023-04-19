package com.labos.laboratorio05diaz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton


class Billboard : Fragment() {
    private lateinit var actionAdd : FloatingActionButton
    private lateinit var movieStarWars : CardView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_billboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind(view)

        addListener(view)
    }
    private fun addListener(view : View) {
        actionAdd.setOnClickListener {
            view.findNavController().navigate(R.id.action_billboard_to_add_new_movie)
        }
        movieStarWars.setOnClickListener{
            view.findNavController().navigate(R.id.action_billboard_to_movie_description)
        }
    }
    private fun bind (view : View) {
        actionAdd = view.findViewById(R.id.action_add)
        movieStarWars = view.findViewById(R.id.movie_star_wars)
    }

}