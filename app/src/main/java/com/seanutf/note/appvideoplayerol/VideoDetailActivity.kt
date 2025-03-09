package com.seanutf.note.appvideoplayerol

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.seanutf.note.appvideoplayerol.databinding.ActivityVideoDetailBinding
import com.shuyu.gsyvideoplayer.GSYBaseActivityDetail
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer


class VideoDetailActivity: GSYBaseActivityDetail<StandardGSYVideoPlayer>() {

    private lateinit var binding: ActivityVideoDetailBinding
    private var videoLink: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseDetailIntent()
        binding = ActivityVideoDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.detailVideoPlayer.titleTextView.visibility = View.GONE
        binding.detailVideoPlayer.backButton.visibility = View.GONE
        initVideoBuilderMode()
    }

    private fun parseDetailIntent() {
        videoLink = intent.getStringExtra("videoLink") ?: ""
    }


    override fun getGSYVideoPlayer(): StandardGSYVideoPlayer {
        return binding.detailVideoPlayer
    }

    override fun getGSYVideoOptionBuilder(): GSYVideoOptionBuilder {
        //内置封面可参考SampleCoverVideo
        val imageView = ImageView(this)
        //loadCover(imageView, url)
        return GSYVideoOptionBuilder()
            .setThumbImageView(imageView)
            .setUrl(videoLink)
            .setCacheWithPlay(true)
            .setVideoTitle(" ")
            .setIsTouchWiget(true)
            .setRotateViewAuto(false)
            .setLockLand(false)
            .setShowFullAnimation(false)
            .setNeedLockFull(true)
            .setSeekRatio(1f)
    }

    private fun loadCover(imageView: ImageView, url: String) {
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.mipmap.ic_launcher);
        binding.detailVideoPlayer.thumbImageView = imageView;
    }

    override fun clickForFullScreen() {
    }

    override fun getDetailOrientationRotateAuto(): Boolean {
        return false
    }

    companion object {
        fun start(context: AppCompatActivity, videoLink: String) {
            val intent = Intent(context, VideoDetailActivity::class.java)
            intent.putExtra("videoLink", videoLink)
            context.startActivity(intent)
        }
    }
}