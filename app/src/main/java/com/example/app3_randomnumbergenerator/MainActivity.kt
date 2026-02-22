package com.example.app3_randomnumbergenerator

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val n1 : EditText = findViewById(R.id.textN1)
        val n2 : EditText = findViewById(R.id.textN2)
        val res : TextView = findViewById(R.id.textResult)
        val gBtn : Button = findViewById(R.id.generateRN)


        gBtn.setOnClickListener {
            val i : Long = n1.text.toString().toLong()
            val j : Long = n2.text.toString().toLong()
            if(i==null || j==null){
                Toast.makeText(this, "Enter limits!", Toast.LENGTH_SHORT).show()
            }
            else if(i>=j){
                Toast.makeText(this, "Enter appropriate limits!", Toast.LENGTH_SHORT).show()
            }
            else{
                val rn : Long = Random.nextLong(i,j)
                res.text = rn.toString()
                Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
            }


        }


    }
}