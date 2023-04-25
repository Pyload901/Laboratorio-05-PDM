package com.labos.laboratorio05diaz

import android.app.ActivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.labos.laboratorio05diaz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var biding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        biding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    }
}