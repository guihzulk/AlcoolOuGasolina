package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun CalcularPreco(view: View) {


        //recupera valores digitados
        //val precoAlcool = findViewById<EditText>(R.id.editTextAlcool)
        // val precoGasolina = findViewById<EditText>(R.id.editTextGasolina)
        val precoAlcool = editTextAlcool.text.toString()
        val precoGasolina = editTextGasolina.text.toString()


        val validarCampos = validarCampos(precoAlcool, precoGasolina)

        if (validarCampos) {
            calcularMelhorPreco(precoAlcool, precoGasolina)
        } else {
            textResultado.text = "Preencha os preços primeiro!"
        }


    }

    fun calcularMelhorPreco(precoAlcool : String, precoGasolina : String){
        //Converter valores de strings para numeros
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        val resultadoPreco = valorAlcool / valorGasolina
        if (resultadoPreco>= 0.7){
            textResultado.text = "Melhor utilizar alcool!!"
        }else
            textResultado.text = "Melhor utilizar Gasolina!!"
        }


    fun validarCampos(precoAlcool : String, precoGasolina : String) : Boolean{

        var camposValidados: Boolean = true
        if ( precoAlcool == null || precoAlcool.equals("")){
            camposValidados = false
        }else if(precoGasolina == null|| precoGasolina.equals("")){
            camposValidados = false
            }
        return camposValidados
    }

}