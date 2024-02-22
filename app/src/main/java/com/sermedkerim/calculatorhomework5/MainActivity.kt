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
//        numberButtonGroup.add(binding.buttonDouble)
//        numberButtonGroup.add(binding.buttonSum)

        for(bt in numberButtonGroup){
            bt.setOnClickListener {
                binding.textViewResult.append(bt.text)
            }
        }

        binding.buttonDouble.setOnClickListener {
            if(flag){
                flag = false
                binding.textViewResult.append(binding.buttonDouble.text)
            }
        }

        binding.buttonSum.setOnClickListener {
            binding.textViewResult.append(binding.buttonSum.text)
            flag = true
        }

        binding.buttonDeleteAll.setOnClickListener {
            binding.textViewResult.setText("")
        }

        binding.buttonResult.setOnClickListener {
            if(binding.textViewResult.text != ""){
                val operationStr = binding.textViewResult.text.toString()

                val numbers = operationStr.split('+')

                var sum = 0.0
                for(num in numbers){
                    sum += num.toDouble()
                }

                binding.textViewResult.setText("${sum}")
            }
        }
    }
}