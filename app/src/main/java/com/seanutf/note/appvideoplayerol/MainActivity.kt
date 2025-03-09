package com.seanutf.note.appvideoplayerol

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.seanutf.note.appvideoplayerol.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val defaultVideoLink = "https://www.w3schools.com/html/movie.mp4"
    private val defaultAudioLink = "https://www.w3schools.com/html/movie.mp4"
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnEnterAudioDetail.setOnClickListener {
            val link = binding.etAudioLink.text.toString().ifBlank {
                defaultAudioLink
            }
            enterAudioDetailPage(link)
        }

        binding.btnEnterVideoDetail.setOnClickListener {
            val link = binding.etVideoLink.text.toString().ifBlank {
                defaultVideoLink
            }
            enterVideoDetailPage(link)
        }
    }

    private fun enterVideoDetailPage(videoLink: String) {
       VideoDetailActivity.start(this@MainActivity, videoLink)
    }

    private fun enterAudioDetailPage(audioLink: String) {
        AudioDetailActivity.start(this@MainActivity, audioLink)
    }
}