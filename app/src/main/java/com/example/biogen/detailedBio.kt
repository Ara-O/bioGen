package com.example.biogen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.biogen.databinding.ActivityDetailedBioBinding

private lateinit var binding: ActivityDetailedBioBinding

class detailedBio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedBioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var fullText = ""
        var firstName = intent.getStringExtra("firstName")
        var lastName = intent.getStringExtra("lastName")
        var yearOfGrad = intent.getStringExtra("yearOfGrad")
        var school = intent.getStringExtra("school")
        var degree = intent.getStringExtra("degree")
        var major = intent.getStringExtra("major")
        var favoriteActivities = intent.getStringExtra("favoriteActivities")

        fullText =  "$firstName $lastName graduated in $yearOfGrad with a $degree with a concentration in $major from $school.\nTheir favorite activities are $favoriteActivities."
        binding.bioSummary.setText(fullText)
    }
}