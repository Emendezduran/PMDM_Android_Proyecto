package com.example.proyectoandroid

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_camera.*

class CameraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //declaracion de ContentView con la descripcion y boton que abre la camara
        setContentView(R.layout.activity_camera)
        btnCamera.setOnClickListener { tomarFoto(it) }
    }

    /*
    * Funcion que abre la camara con un intent ejecutando startActivityForResult
    */
    fun tomarFoto(viev: View?) {
        viev as Button
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, 1)
            }
        }
    }

    /*
    * Funcion que maneja el Result de la camara
    * almacenando la imagen como un Bitmap
    * si el resultCode es RESULT_OK muestra la imagen capturada en un cuadro de imagen
    */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {
            val imageBitmap = data!!.extras!!.get("data") as Bitmap
            image.setImageBitmap(imageBitmap)
        }
    }

}
