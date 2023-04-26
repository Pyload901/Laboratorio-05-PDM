package com.labos.laboratorio05diaz.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.labos.laboratorio05diaz.R
import com.labos.laboratorio05diaz.databinding.ActivityMainBinding
import com.labos.laboratorio05diaz.ui.movie.MovieViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var biding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    }
}