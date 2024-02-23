package com.sermedkerim.calculatorhomework5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.sermedkerim.calculatorhomework5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var flag = true

        val numberButtonGroup = ArrayList<Button>()
        numberButtonGroup.add(binding.button0)
        numberButtonGroup.add(binding.button1)
        numberButtonGroup.add(binding.button2)
        numberButtonGroup.add(binding.button3)
        numberButtonGroup.add(binding.button4)
        numberButtonGroup.add(binding.button5)
        numberButtonGroup.add(binding.button6)
        numberButtonGroup.add(binding.button7)
        numberButtonGroup.add(binding.button8)
        numberButtonGroup.add(binding.button9)

        for(bt in numberButtonGroup){ //When button which represents digit is clicked, digit is displayed
            bt.setOnClickListener {
                binding.textViewResult.append(bt.text)
            }
        }

        binding.buttonDouble.setOnClickListener {//When "." button is clicked, it represents decimal point
            if(flag && binding.textViewResult.text.toString() != ""){
                if(binding.textViewResult.text.toString().get(binding.textViewResult.text.length-1) != '+'){
                    binding.textViewResult.append(binding.buttonDouble.text)
                    flag = false
                }
            }
        }

        binding.buttonSum.setOnClickListener {//When summation button is clicked
            if(binding.textViewResult.text.toString() != ""){
                if(binding.textViewResult.text.toString().get(binding.textViewResult.text.length-1) != '+'){
                    binding.textViewResult.append(binding.buttonSum.text)
                    flag = true
                }
            }
        }

        binding.buttonDeleteAll.setOnClickListener {//When delete button is clicked
            binding.textViewResult.setText("")
        }

        binding.buttonResult.setOnClickListener {//When "=" button is clicked
            if(binding.textViewResult.text.toString() != ""){
                val operationStr = binding.textViewResult.text.toString()
                val sum = calculateSum(operationStr)
                binding.textViewResult.setText("${sum}")
                flag = false
            }
        }
    }

    fun calculateSum(resultText:String):Double{ //Function which calculates summing all numbers in text in app
        val numbers = resultText.split('+')

        var sum = 0.0
        for(num in numbers){
            sum += num.toDouble()
        }

        return sum
    }
}