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
        //declaracion de los botones y sus señales
        btnc1.setOnClickListener { buscarColor(it) }
        btnc2.setOnClickListener { buscarColor(it) }
        btnc3.setOnClickListener { buscarColor(it) }
        btnc4.setOnClickListener { buscarColor(it) }
    }

    /*
    *Funcion que Busca en el navegador el codigo de color de cada boton
    * se asigna la variable a un btn como Button
    * se almacena el texto del boton en una variable
    * se muestra un toast con el texto
    * se utiliza la funcion browse de AnKo para abrir el navegador y buscar en Google el texto
    */
    fun buscarColor(view: View?) {
        val btn = view as Button
        val message = btn.text.toString()
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        browse("http://google.es/search?q=%23" + message)
    }
}
