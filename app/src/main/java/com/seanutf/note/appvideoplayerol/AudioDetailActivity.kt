package com.seanutf.note.appvideoplayerol

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.seanutf.note.appvideoplayerol.databinding.ActivityAudioDetailBinding
import com.seanutf.note.appvideoplayerol.ui_controller.AudioUIController
import com.shuyu.gsyvideoplayer.GSYBaseActivityDetail
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder

class AudioDetailActivity: GSYBaseActivityDetail<AudioUIController>() {

    private lateinit var binding: ActivityAudioDetailBinding
    private var audioLink: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseDetailIntent()
        binding = ActivityAudioDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickEvent()
        initVideoBuilderMode()
    }

    private fun setOnClickEvent() {
        //binding.detailAudioPlayer.onVideoPause()
    }

    private fun parseDetailIntent() {
        audioLink = intent.getStringExtra("audioLink") ?: ""
    }

    override fun getGSYVideoPlayer(): AudioUIController {
        return binding.detailAudioPlayer
    }

    override fun getGSYVideoOptionBuilder(): GSYVideoOptionBuilder {
        //内置封面可参考SampleCoverVideo
        val imageView = ImageView(this)
        //loadCover(imageView, url)
        return GSYVideoOptionBuilder()
            .setThumbImageView(imageView)
            .setUrl(audioLink)
            .setCacheWithPlay(true)
            .setVideoTitle(" ")
            .setIsTouchWiget(true)
            .setRotateViewAuto(false)
            .setLockLand(false)
            .setShowFullAnimation(false)
            .setNeedLockFull(true)
            .setSeekRatio(1f)
    }

    override fun clickForFullScreen() {
         TODO("Not yet implemented")
    }

    override fun getDetailOrientationRotateAuto(): Boolean {
        return false
    }

    override fun isAutoFullWithSize(): Boolean {
        return super.isAutoFullWithSize()
    }

    companion object {
        fun start(context: AppCompatActivity, audioLink: String) {
            val intent = Intent(context, AudioDetailActivity::class.java)
            intent.putExtra("audioLink", audioLink)
            context.startActivity(intent)
        }
    }
}