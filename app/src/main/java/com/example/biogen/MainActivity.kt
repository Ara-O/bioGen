package com.example.biogen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.biogen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        val majors = ArrayList<String>()
        majors.add("Computer science")
        majors.add("Electrical Science")
        majors.add("Biology")

        val spinner: Spinner = binding.spinner
        ArrayAdapter.createFromResource(this, R.array.majors_list, android.R.layout.simple_spinner_item).also{
            adapter-> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        binding.createButton.setOnClickListener{
            var firstName = binding.firstNameInput.text.toString()
            var lastName = binding.lastNameInput.text.toString()
            var school = binding.schoolInput.text.toString()
            var yearOfGrad = binding.yearOfGrad.text.toString()
            var degree = binding.degreesInput.text.toString()
            var major = spinner.selectedItem.toString()
            var favoriteActivities = binding.favoriteActivities.text.toString()


            val intent = Intent(this, detailedBio::class.java).also {
            it.putExtra("firstName", firstName)
            it.putExtra("lastName", lastName)
            it.putExtra("school", school)
            it.putExtra("yearOfGrad", yearOfGrad)
            it.putExtra("degree", degree)
            it.putExtra("major", major)
            it.putExtra("favoriteActivities", favoriteActivities)
        }
            startActivity(intent)
        }
    }
}