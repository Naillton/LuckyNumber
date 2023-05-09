package com.example.luckynumberapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.Random

class Activity2 : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val tv: TextView = findViewById(R.id.text3)
        val button: Button = findViewById(R.id.btn2)
        val bundle: Bundle? = intent.extras
        val value = bundle?.get("name")
        val random = Random()
        val r: Int = random.nextInt(100)

        tv.text = "Ola "+value+"\n"+
        "seu numero da sorte e "+r

        button.setOnClickListener {
            shareIntent(r)
        }
    }
    private fun shareIntent(result: Int) {
        // usando o shareIntent e passando como paremetro uma acao de envio
        val shareIntent = Intent(Intent.ACTION_SEND)
        // definindo o tipo da intent
        shareIntent.type = "text/plain"
        // usando o putExtra passando o EXTRA_TEXT e um valor como corpo da mensagem
        shareIntent.putExtra(Intent.EXTRA_TEXT, "meu numero da sorte e $result")
        // usando o putExtra e passando como parametro o subject para criar um assunto
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Olha o meu numero da sorte")
        startActivity(Intent.createChooser(shareIntent, "Numero da sorte"))
    }
}