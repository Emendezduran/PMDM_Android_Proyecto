package com.example.proyectoandroid

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.browse

//Constantes para manejar los diferentes Result de las actividades
const val REQUEST_R2 = 2
const val REQUEST_R3 = 3

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //declaracion de los botones y sus señales
        btn1.setOnClickListener { abrirReto1(it) }
        btn2.setOnClickListener { abrirReto2(it) }
        btn3.setOnClickListener { abrirReto3(it) }
        btn4.setOnClickListener { abrirReto4(it) }
        link.setOnClickListener { abrirRepositorio(it) }
    }

    //funcion que busca en internet el repositorio del proyecto al hacer click al titulo Retos AnKo
    fun abrirRepositorio(view: View) {
        browse("https://github.com/Emendezduran/PMDM_Android_Proyecto")
    }

    /*
    * funcion OnClick del reto 1
    * se asigna la variable a un btn como Button
    * se cambia el fondo al boton y se deshabilita
    * se declara intent y se ejecuta su metodo startActivity
    */
    fun abrirReto1(view: View?) {
        val btn = view as Button
        with(btn) { setBackgroundColor(1) }
        with(btn) { setEnabled(false) }
        val intent = Intent(this, ColorsActivity::class.java)
        startActivity(intent)
    }

    /*
    * funcion OnClick del reto 2
    * se declara intent y se ejecuta su metodo startActivityForResult
    */
    fun abrirReto2(view: View?) {
        val btn = view as Button
        val intent = Intent(this, MathActivity::class.java)
        startActivityForResult(intent, REQUEST_R2)
    }

    /*
    * funcion OnClick del reto 3
    * se declara intent y se ejecuta su metodo startActivityForResult
    */
    fun abrirReto3(view: View?) {
        val btn = view as Button
        val intent = Intent(this, TriviaActivity::class.java)
        startActivityForResult(intent, REQUEST_R3)
    }

    /*
    * funcion OnClick del reto 4
    * se asigna la variable a un btn como Button
    * se cambia el fondo al boton y se deshabilita
    * se declara intent y se ejecuta su metodo startActivity
    */
    fun abrirReto4(view: View?) {
        val btn = view as Button
        with(btn) { setBackgroundColor(1) }
        with(btn4) { setEnabled(false) }
        val intent = Intent(this, CameraActivity::class.java)
        startActivity(intent)
    }

    /*
    * Funcion que maneja los diferentes Result que pueden venir del reto2 o el reto3
    * si el resultCode es REQUES_R2 se cambia el fondo al boton y se deshabilita el btn2
    * si el resultCode es REQUES_R3 se cambia el fondo al boton y se deshabilita el btn3
    */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_R2 || requestCode == REQUEST_R3 ) {
            if (resultCode == Activity.RESULT_OK) {
                with(btn2) { setBackgroundColor(1) }
                with(btn2) { setEnabled(false) }
            }
        } else if (requestCode == REQUEST_R3) {
            if (resultCode == Activity.RESULT_OK) {
                with(btn3) { setEnabled(false) }
                with(btn3) { setBackgroundColor(1) }
            }
        }
    }

}
