package com.example.proyectoandroid

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_math.*

class MathActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //declaracion de ContentView con la descripcion el boton y su señal
        setContentView(R.layout.activity_math)
        btnVerificar.setOnClickListener { verificar(it, respuesta) }
    }

    /*
    * Funcion que verifica si el resultado ingresado es el correcto
    * dentro de un bloque Try Catch para prevenir ingreso de datos indeseados
    * almacenamos la respuesta en una variable asegurando que sea de tipo int
    * se almacena el texto del boton en una variable
    * se muestra un toast correcto si es correcto y de no ser asi un toast calcula nuevamente
    * de ser correcto se declara un intent y ejecuta el metodo setResult y finalizamos la actividad
    * captura la excepcion mostrando un toast informando que el Numero es invalido
    */
    private fun verificar(view: View?, respuesta: EditText) {
        try {
            var res = Integer.parseInt(respuesta.text.toString())
            if (res == 2020) {
                Toast.makeText(this, "CORRECTO!", Toast.LENGTH_SHORT).show()
                val intent = Intent()
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else Toast.makeText(this, "CALCULA NUEVAMENTE", Toast.LENGTH_LONG).show()

        } catch (nfe: NumberFormatException) {
            Toast.makeText(this, "Numero Invalido", Toast.LENGTH_SHORT).show()
        }
    }
}
