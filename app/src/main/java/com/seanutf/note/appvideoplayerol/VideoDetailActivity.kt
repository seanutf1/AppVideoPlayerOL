package com.seanutf.note.appvideoplayerol

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.seanutf.note.appvideoplayerol.databinding.ActivityVideoDetailBinding

class VideoDetailActivity: AppCompatActivity(){

    private lateinit var binding: ActivityVideoDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }




    companion object {
        fun start(context: AppCompatActivity, videoLink: String) {
            val intent = Intent(context, VideoDetailActivity::class.java)
            intent.putExtra("videoLink", videoLink)
            context.startActivity(intent)
        }
    }
}