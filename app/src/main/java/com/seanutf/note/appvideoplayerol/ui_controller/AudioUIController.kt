package com.seanutf.note.appvideoplayerol.ui_controller

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.SeekBar
import com.seanutf.note.appvideoplayerol.R
import com.shuyu.gsyvideoplayer.utils.Debuger
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer

class AudioUIController constructor(context: Context, attrs: AttributeSet?):
    StandardGSYVideoPlayer(context, attrs) {

    override fun getLayoutId(): Int {
        return R.layout.layout_audio_controller_detail
    }

    override fun touchSurfaceMoveFullLogic(absDeltaX: Float, absDeltaY: Float) {
        super.touchSurfaceMoveFullLogic(absDeltaX, absDeltaY)
        mChangePosition = false
        mChangeVolume = false
        mBrightness = false
    }

    override fun touchDoubleUp(e: MotionEvent?) {
        //super.touchDoubleUp();
        //不需要双击暂停
    }

    override fun changeUiToPlayingShow() {
        super.changeUiToPlayingShow()
//        Debuger.printfLog("Sample changeUiToPlayingShow")
//        if (!byStartedClick) {
            setViewShowState(mProgressBar, VISIBLE)
//            setViewShowState(mProgressBar, VISIBLE)
//            //mProgressBar.setProgress()
//        }
    }

    override fun touchSurfaceUp() {
        super.touchSurfaceUp()
    }

    override fun setProgressAndTime(
        progress: Long,
        secProgress: Long,
        currentTime: Long,
        totalTime: Long,
        forceChange: Boolean
    ) {
        super.setProgressAndTime(progress, secProgress, currentTime, totalTime, forceChange)
        Log.d("VideoProgrgedd", "progress: $progress")
        findViewById<SeekBar>(R.id.progress).progress = progress.toInt()
    }
}