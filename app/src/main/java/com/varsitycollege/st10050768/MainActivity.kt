package com.varsitycollege.st10050768

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editNum1 = findViewById<EditText>(R.id.editNum1)
        val editNum2 = findViewById<EditText>(R.id.editNum2)
        val btnAddition = findViewById<Button>(R.id.btnAddition)
        val btnSubtraction = findViewById<Button>(R.id.btnSubtraction)
        val btnMultiplication = findViewById<Button>(R.id.btnMultiplication)
        val btnDivision = findViewById<Button>(R.id.btnDivision)
        val btnSquareRoot = findViewById<Button>(R.id.btnSquareRoot)
        val btnPower = findViewById<Button>(R.id.btnPower)
        val btnStats = findViewById<Button>(R.id.btnStats)
        val txtAnswers = findViewById<TextView>(R.id.txtAnswers)

        btnAddition.setOnClickListener() {
            if(editNum1.text.toString().isNotEmpty() && editNum2.text.toString().isNotEmpty()){
            val answer = editNum1.text.toString().toDouble() + editNum2.text.toString().toDouble()
            txtAnswers.text = (""+editNum1.text.toString()+" + "+editNum2.text.toString()+" = "+String.format("%.2f", answer)).replace(",00"," ")
            }
            else {
                txtAnswers.text = ("Number not entered.\n Please enter a number.")
            }
        }
        btnSubtraction.setOnClickListener() {
            if(editNum1.text.toString().isNotEmpty() && editNum2.text.toString().isNotEmpty()){
                val answer = editNum1.text.toString().toDouble() - editNum2.text.toString().toDouble()
                txtAnswers.text = (""+editNum1.text.toString()+" - "+editNum2.text.toString()+" = "+String.format("%.2f", answer)).replace(",00"," ")
            }
            else {
                txtAnswers.text = ("Number not entered.\n Please enter a number.")
            }
        }
        btnMultiplication.setOnClickListener() {
            if(editNum1.text.toString().isNotEmpty() && editNum2.text.toString().isNotEmpty()){
                val answer = editNum1.text.toString().toDouble() * editNum2.text.toString().toDouble()
                txtAnswers.text = (""+editNum1.text.toString()+" x "+editNum2.text.toString()+" = "+String.format("%.2f", answer)).replace(",00"," ")
            }
            else {
                txtAnswers.text = ("Number not entered.\n Please enter a number.")
            }
    }
        btnDivision.setOnClickListener() {
            if(editNum1.text.toString().isNotEmpty() && editNum2.text.toString().isNotEmpty()){
                val answer = editNum1.text.toString().toDouble() / editNum2.text.toString().toDouble()
                txtAnswers.text = (""+editNum1.text.toString()+" / "+editNum2.text.toString()+" = "+String.format("%.2f", answer))
                if(editNum1.text.toString().toDouble()%editNum2.text.toString().toDouble()==0.0){
                    txtAnswers.text = (""+editNum1.text.toString()+" / "+editNum2.text.toString()+" = "+answer.toInt())
                }
                if(editNum2.text.toString().toDouble()==0.0){
                    txtAnswers.text = (""+editNum1.text.toString()+" / "+editNum2.text.toString()+" = "+" can't divide by 0")
                }
            }
            else {
                txtAnswers.text = ("Number not entered.\n Please enter a number.")
            }
        }
        btnSquareRoot.setOnClickListener(){
            if(editNum1.text.toString().isEmpty()){
                txtAnswers.text = ("Number not entered.\n Please enter a number.")
                }
            else {
                val answer = sqrt(editNum1.text.toString().toDouble())
                txtAnswers.text = ("sqrt("+editNum1.text.toString()+") "+" = "+String.format("%.2f", answer)).replace(",00"," ")
                if(editNum1.text.toString().toDouble() < 0){
                    val number = -1 * editNum1.text.toString().toDouble()
                    val answer = sqrt(number)
                    txtAnswers.text = ("sqrt("+editNum1.text.toString()+") "+" = "+String.format("%.2f", answer)).replace(",00"," ")+" i"
                }
            }
            }

        btnPower.setOnClickListener(){
            if(editNum1.text.toString().isEmpty() || editNum2.text.toString().isEmpty()){
                txtAnswers.text = ("Number not entered.\n Please enter a number.")
            }
            else{
                var answer =  editNum1.text.toString().toDouble()
                var denominator = editNum1.text.toString().toDouble()
                for(i in 1..editNum2.text.toString().toDouble().toInt()-1){
                    answer = answer * editNum1.text.toString().toDouble()
                }
                txtAnswers.text = (""+editNum1.text.toString()+" ^ "+editNum2.text.toString()+" = "+String.format("%.2f", answer)).replace(",00"," ")
                if(editNum2.text.toString().toDouble() < 0){
                    for(i in 1..((-1*editNum2.text.toString().toDouble().toInt())-1)){
                        denominator = denominator * editNum1.text.toString().toDouble()
                    }
                    answer = 1/denominator
                    txtAnswers.text = (""+editNum1.text.toString()+" ^ "+editNum2.text.toString()+" = "+String.format("%.2f", answer)).replace(",00"," ")
                    if(answer < 0.01){
                        txtAnswers.text = ""+editNum1.text.toString()+" ^ "+editNum2.text.toString()+" = "+answer
                    }
                }
                if(editNum2.text.toString().contains(".")){
                    answer = Math.pow(editNum1.text.toString().toDouble(),editNum2.text.toString().toDouble())
                    txtAnswers.text = (""+editNum1.text.toString()+" ^ "+editNum2.text.toString()+" = "+String.format("%.2f", answer)).replace(",00"," ")
                }
                if(editNum2.text.toString().contains(".") && editNum2.text.toString().toDouble() < 0){
                    answer = Math.pow(editNum1.text.toString().toDouble(),editNum2.text.toString().toDouble())
                    txtAnswers.text = ""+editNum1.text.toString()+" ^ "+editNum2.text.toString()+" = "+answer
                }
                if(editNum2.text.toString().toDouble() == 0.0){
                    txtAnswers.text = ""+editNum1.text.toString()+" ^ "+editNum2.text.toString()+" = 1"
                }
            }
        }
        btnStats.setOnClickListener(){
            val stats = Intent(this,Statistics::class.java)
            startActivity(stats)
        }
}
    }