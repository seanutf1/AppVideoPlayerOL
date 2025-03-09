package com.seanutf.note.appvideoplayerol

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.seanutf.note.appvideoplayerol.databinding.ActivityAudioDetailBinding

class AudioDetailActivity: AppCompatActivity(){

    private lateinit var binding: ActivityAudioDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAudioDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object {
        fun start(context: AppCompatActivity, audioLink: String) {
            val intent = Intent(context, AudioDetailActivity::class.java)
            intent.putExtra("audioLink", audioLink)
            context.startActivity(intent)
        }
    }
}