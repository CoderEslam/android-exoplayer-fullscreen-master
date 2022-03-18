package com.exoplayer.fullscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ui.PlayerView
import com.norulab.exofullscreen.MediaPlayer
import com.norulab.exofullscreen.preparePlayer
import com.norulab.exofullscreen.setSource

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playerView: PlayerView = findViewById(R.id.playerView)

        MediaPlayer.initialize(applicationContext)
        MediaPlayer.exoPlayer?.preparePlayer(playerView, true)
        MediaPlayer.exoPlayer?.setSource(applicationContext, "http://html5videoformatconverter.com/data/images/happyfit2.mp4")
        MediaPlayer.startPlayer()
    }

    public override fun onPause() {
        super.onPause()
        MediaPlayer.pausePlayer()
    }

    public override fun onDestroy() {
        MediaPlayer.stopPlayer()
        super.onDestroy()
    }
}