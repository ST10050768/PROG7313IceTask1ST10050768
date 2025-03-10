package com.varsitycollege.st10050768

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Statistics : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)

        val editNumber = findViewById<EditText>(R.id.editNumber)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val storedNumbers = findViewById<TextView>(R.id.storedNumbers)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val btnAverage = findViewById<Button>(R.id.btnAverage)
        val btnMinMax = findViewById<Button>(R.id.btnMinMax)
        val txtStatsAnswer = findViewById<TextView>(R.id.txtStatsAnswers)
        val numbers = arrayOf("","","","","","","","","","")
        var count = 0


        btnAdd.setOnClickListener(){
            try {
                numbers.set(count, editNumber.text.toString())
                count++
                storedNumbers.text =
                    "${numbers[0]} " + numbers[1] + " ${numbers[2]} " + numbers[3] +
                            " ${numbers[4]} " + numbers[5] + " ${numbers[6]} " + numbers[7] + " ${numbers[8]} " + numbers[9]
            }
            catch(e: ArrayIndexOutOfBoundsException){
                txtStatsAnswer.text = "Can't store more than ten numbers"
            }
        }
        btnClear.setOnClickListener(){
            numbers.set(0,"")
            numbers.set(1,"")
            numbers.set(2,"")
            numbers.set(3,"")
            numbers.set(4,"")
            numbers.set(5,"")
            numbers.set(6,"")
            numbers.set(7,"")
            numbers.set(8,"")
            numbers.set(9,"")
            count = 0
            storedNumbers.text = ""
            txtStatsAnswer.text = ""
        }
        btnAverage.setOnClickListener(){
            if(numbers[1] == ""){
                numbers.set(1,"0")
                numbers.set(2,"0")
                numbers.set(3,"0")
                numbers.set(4,"0")
                numbers.set(5,"0")
                numbers.set(6,"0")
                numbers.set(7,"0")
                numbers.set(8,"0")
                numbers.set(9,"0")
            }
            if(numbers[2] == ""){
                numbers.set(2,"0")
                numbers.set(3,"0")
                numbers.set(4,"0")
                numbers.set(5,"0")
                numbers.set(6,"0")
                numbers.set(7,"0")
                numbers.set(8,"0")
                numbers.set(9,"0")
            }
            if(numbers[3] == ""){
                numbers.set(3,"0")
                numbers.set(4,"0")
                numbers.set(5,"0")
                numbers.set(6,"0")
                numbers.set(7,"0")
                numbers.set(8,"0")
                numbers.set(9,"0")
            }
            if(numbers[4] == ""){
                numbers.set(4,"0")
                numbers.set(5,"0")
                numbers.set(6,"0")
                numbers.set(7,"0")
                numbers.set(8,"0")
                numbers.set(9,"0")
            }
            if(numbers[5] == ""){
                numbers.set(5,"0")
                numbers.set(6,"0")
                numbers.set(7,"0")
                numbers.set(8,"0")
                numbers.set(9,"0")
            }
            if(numbers[6] == ""){
                numbers.set(6,"0")
                numbers.set(7,"0")
                numbers.set(8,"0")
                numbers.set(9,"0")
            }
            if(numbers[7] == ""){
                numbers.set(7,"0")
                numbers.set(8,"0")
                numbers.set(9,"0")
            }
            if(numbers[8] == ""){
                numbers.set(8,"0")
                numbers.set(9,"0")
            }
            if(numbers[9] == ""){
                numbers.set(9,"0")
            }
            val average = (numbers[0].toDouble()+numbers[1].toDouble()+numbers[2].toDouble()+numbers[3].toDouble()+numbers[4].toDouble()+numbers[5].toDouble()+numbers[6].toDouble()+numbers[7].toDouble()+numbers[8].toDouble()+numbers[9].toDouble())/count

            txtStatsAnswer.text = "The average is "+String.format("%.2f", average).replace(",00"," ")
        }
        btnMinMax.setOnClickListener(){
            if(numbers[1] == ""){
                numbers.set(1,"0")
                numbers.set(2,"0")
                numbers.set(3,"0")
                numbers.set(4,"0")
                numbers.set(5,"0")
                numbers.set(6,"0")
                numbers.set(7,"0")
                numbers.set(8,"0")
                numbers.set(9,"0")
            }
            if(numbers[2] == ""){
                numbers.set(2,"0")
                numbers.set(3,"0")
                numbers.set(4,"0")
                numbers.set(5,"0")
                numbers.set(6,"0")
                numbers.set(7,"0")
                numbers.set(8,"0")
                numbers.set(9,"0")
            }
            if(numbers[3] == ""){
                numbers.set(3,"0")
                numbers.set(4,"0")
                numbers.set(5,"0")
                numbers.set(6,"0")
                numbers.set(7,"0")
                numbers.set(8,"0")
                numbers.set(9,"0")
            }
            if(numbers[4] == ""){
                numbers.set(4,"0")
                numbers.set(5,"0")
                numbers.set(6,"0")
                numbers.set(7,"0")
                numbers.set(8,"0")
                numbers.set(9,"0")
            }
            if(numbers[5] == ""){
                numbers.set(5,"0")
                numbers.set(6,"0")
                numbers.set(7,"0")
                numbers.set(8,"0")
                numbers.set(9,"0")
            }
            if(numbers[6] == ""){
                numbers.set(6,"0")
                numbers.set(7,"0")
                numbers.set(8,"0")
                numbers.set(9,"0")
            }
            if(numbers[7] == ""){
                numbers.set(7,"0")
                numbers.set(8,"0")
                numbers.set(9,"0")
            }
            if(numbers[8] == ""){
                numbers.set(8,"0")
                numbers.set(9,"0")
            }
            if(numbers[9] == ""){
                numbers.set(9,"0")
            }
            var max = numbers[0].toDouble()
            var maxArrayCount = 0
            for(i in numbers){
                if(max < i.toDouble()){
                    max = i.toDouble()
                }
                maxArrayCount++
                if(maxArrayCount == count){
                    break
                }
            }
            var minArrayCount = 0
            var min = numbers[0].toDouble()
            for(i in numbers){
                if(min > i.toDouble()){
                    min = i.toDouble()
                }
                minArrayCount++
                if(minArrayCount == count){
                    break
                }
            }
            txtStatsAnswer.text = "The max number is "+String.format("%.2f", max).replace(",00"," ")+"\n"+
                    "The min number is "+String.format("%.2f", min).replace(",00"," ")

        }

    }
}