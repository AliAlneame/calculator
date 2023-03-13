package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {

     lateinit var editText: EditText
     lateinit var binaryRadioButton: RadioButton
     lateinit var decimalRadioButton: RadioButton
     lateinit var octalRadioButton: RadioButton
     lateinit var hexaRadioButton: RadioButton
     lateinit var convertButton: Button
     lateinit var convertedNumberTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        binaryRadioButton = findViewById(R.id.binary)
        decimalRadioButton = findViewById(R.id.decimal)
        octalRadioButton = findViewById(R.id.octal)
        hexaRadioButton = findViewById(R.id.hexa)
        convertButton = findViewById(R.id.button)
        convertedNumberTextView = findViewById(R.id.convertednumber)

        binaryRadioButton.setOnClickListener {
            binaryRadioButton.isChecked = true
            decimalRadioButton.isChecked = false
            octalRadioButton.isChecked = false
            hexaRadioButton.isChecked = false
        }

        decimalRadioButton.setOnClickListener {
            binaryRadioButton.isChecked = false
            decimalRadioButton.isChecked = true
            octalRadioButton.isChecked = false
            hexaRadioButton.isChecked = false
        }

        octalRadioButton.setOnClickListener {
            binaryRadioButton.isChecked = false
            decimalRadioButton.isChecked = false
            octalRadioButton.isChecked = true
            hexaRadioButton.isChecked = false
        }

        hexaRadioButton.setOnClickListener {
            binaryRadioButton.isChecked = false
            decimalRadioButton.isChecked = false
            octalRadioButton.isChecked = false
            hexaRadioButton.isChecked = true
        }

        convertButton.setOnClickListener {
            val input = editText.text.toString()

            val convertedNumber = when {
                binaryRadioButton.isChecked -> convertToBinary(input.toInt())
                decimalRadioButton.isChecked -> input.toInt().toString()
                octalRadioButton.isChecked -> convertToOctal(input.toInt())
                hexaRadioButton.isChecked -> convertToHexadecimal(input.toInt())
                else -> "Invalid selection"
            }

            convertedNumberTextView.text = "$convertedNumber"
        }
    }

    private fun convertToBinary(decimal: Int): String {
        return Integer.toBinaryString(decimal)
    }

    private fun convertToOctal(decimal: Int): String {
        return Integer.toOctalString(decimal)
    }

    private fun convertToHexadecimal(decimal: Int): String {
        return Integer.toHexString(decimal)
    }
}
