package com.example.taskmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskmanager.databinding.ActivityMainBinding // Import the binding class

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.add.setOnClickListener{
            val intent= Intent(this, CreateCard::class.java)
            startActivity(intent)
        }

        binding.deleteAll.setOnClickListener {
            DataObject.deleteAll()
            setRecycler()
        }

        setRecycler()
    }

    private fun setRecycler(){
        binding.recyclerView.adapter = Adapter(DataObject.getAllData())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
