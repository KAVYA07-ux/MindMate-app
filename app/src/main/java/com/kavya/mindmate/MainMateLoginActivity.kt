package com.kavya.mindmate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainMateLoginActivity : AppCompatActivity() {

    private lateinit var viewModel: MoodViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_mate_login)

        viewModel = ViewModelProvider(this)[MoodViewModel::class.java]

        val etMoodText = findViewById<EditText>(R.id.etMoodText)
        val btnAnalyze = findViewById<Button>(R.id.btnAnalyze)
        val btnHistory = findViewById<Button>(R.id.btnHistory)

        val moodButtons = listOf(
            Pair(R.id.btnHappy, "Happy"),
            Pair(R.id.btnSad, "Sad"),
            Pair(R.id.btnAnxious, "Anxious"),
            Pair(R.id.btnAngry, "Angry"),
            Pair(R.id.btnCalm, "Calm"),
            Pair(R.id.btnTired, "Tired")
        )

        moodButtons.forEach { (id, mood) ->
            findViewById<LinearLayout>(id).setOnClickListener {
                viewModel.insertMood(mood)
                Toast.makeText(this, "Mood saved!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, QuoteActivity::class.java)
                intent.putExtra("mood", mood)
                startActivity(intent)
            }
        }

        btnAnalyze.setOnClickListener {
            val text = etMoodText.text.toString().trim()
            if (text.isEmpty()) {
                Toast.makeText(this, "Please describe how you feel", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            viewModel.insertMood("Custom", text)
            val intent = Intent(this, QuoteActivity::class.java)
            intent.putExtra("mood", "Custom")
            startActivity(intent)
        }

        btnHistory.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }
    }
}