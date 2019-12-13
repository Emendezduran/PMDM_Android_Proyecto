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
        setContentView(R.layout.activity_math)
        btnVerificar.setOnClickListener { verificar(it, respuesta) }
    }

    private fun verificar(view: View?, respuesta: EditText) {
        try {
            var res = Integer.parseInt(respuesta.text.toString())
            if ( res == 2020){
                Toast.makeText(this, "CORRECTO!", Toast.LENGTH_SHORT).show()
                val intent = Intent()
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else Toast.makeText(this, "CALCULA NUEVAMENTE", Toast.LENGTH_LONG).show()

        }catch (nfe: NumberFormatException){
            Toast.makeText(this, "Numero Invalido", Toast.LENGTH_SHORT).show()
        }
    }
}
