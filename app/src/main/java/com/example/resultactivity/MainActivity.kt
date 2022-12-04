package com.example.resultactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    private lateinit var btn: Button
    private lateinit var input: RadioGroup
    private lateinit var str: String

    private val launcher: ActivityResultLauncher<String> =
        registerForActivityResult(ActivityContract()) { result: String? ->
            result?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.btn)
        input = findViewById(R.id.input)

        input.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId) {
                R.id.odd -> str = "홀"
                R.id.even -> str = "짝"
            }

        }
        btn.setOnClickListener {
            try {
                launcher.launch(str)
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Please enter a number between 1 and 12", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}

