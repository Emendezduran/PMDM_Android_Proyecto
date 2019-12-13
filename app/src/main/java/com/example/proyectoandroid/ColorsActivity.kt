package com.example.proyectoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_colors.*
import org.jetbrains.anko.browse

class ColorsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colors)
        btnc1.setOnClickListener { buscarColor(it) }
        btnc2.setOnClickListener { buscarColor(it) }
        btnc3.setOnClickListener { buscarColor(it) }
        btnc4.setOnClickListener { buscarColor(it) }
    }

    fun buscarColor(view: View?){
        val btn = view as Button
        val message = btn.text.toString()
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        browse("http://google.es/search?q=%23" + message)
    }
}
