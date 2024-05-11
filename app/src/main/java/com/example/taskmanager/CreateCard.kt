package com.example.taskmanager

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taskmanager.databinding.ActivityCreateCardBinding

class CreateCard : AppCompatActivity() {

    private lateinit var binding: ActivityCreateCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.saveButton.setOnClickListener {
            val title = binding.createTitle.text.toString().trim()
            val priority = binding.createPriority.text.toString().trim()

            if (title.isNotEmpty() && priority.isNotEmpty()) {
                DataObject.setData(title, priority)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
