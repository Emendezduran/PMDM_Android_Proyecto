package com.example.proyectoandroid

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_trivia.*
import org.jetbrains.anko.browse

class TriviaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //declaracion de ContentView con la descripcion, botones de respuesta y su señal
        setContentView(R.layout.activity_trivia)
        btnGeorge.setOnClickListener { verificar(it) }
        btnAdolf.setOnClickListener { verificar(it) }
        btnSimon.setOnClickListener { verificar(it) }
    }


    /*
    * Funcion que verifica si la respuesta seleccionada es la correcta
    * se asigna la variable a un btn como Button
    * bloque condicion donde en caso de ser correcta la respuesta
    * muestra un toast correcto!
    * se declara un intent y ejecuta el metodo setResult y finalizamos la actividad
    * en caso de que la respuesta sea incorrecta muestra un toast vuelve a intentar
    */
    private fun verificar(view: View?) {
        val btn = view as Button
        if (btn.text == "simon bolivar"){
            Toast.makeText(this, "CORRECTO!", Toast.LENGTH_SHORT).show()
            val intent = Intent()
            setResult(Activity.RESULT_OK, intent)
            finish()
        } else Toast.makeText(this, "VUELVE A INTENTAR", Toast.LENGTH_LONG).show()
    }
}


