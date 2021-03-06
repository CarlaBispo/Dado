package br.com.carlabispo.dado

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_dado.*
import java.util.*

class DadoActivity : AppCompatActivity() {

    var vitorias = 0
    var derrotas = 0
    var empates = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dado)

        btPlay.setOnClickListener{
            jogar()
        }
    }

    fun jogar() {
        val geraNumero = Random()
        val numeroPlayer = geraNumero.nextInt ( 6) + 1
        val numeroPC = geraNumero.nextInt( 6) + 1
        configuraDado(numeroPlayer, ivPlayer)
        configuraDado(numeroPC,ivPC)

        if (numeroPlayer > numeroPC){
            vitorias++
            tvVitorias.text = vitorias.toString()
        }else if (numeroPlayer < numeroPC){
            derrotas++
            tvDerrotas.text = derrotas.toString()
        }else{
            empates++
            tvEmpates.text = empates.toString()
        }
    }

    fun configuraDado(numero: Int, imagem: ImageView){

        when (numero){
            1 -> imagem.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dice_1))

            2 -> imagem.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dice_2))

            3 -> imagem.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dice_3))

            4 -> imagem.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dice_4))

            5 -> imagem.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dice_5))

            6 -> imagem.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dice_6))
        }

    }
}
