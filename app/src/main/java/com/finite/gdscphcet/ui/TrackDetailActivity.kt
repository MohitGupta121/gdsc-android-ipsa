package com.finite.gdscphcet.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgs
import com.finite.gdscphcet.R

class TrackDetailActivity : AppCompatActivity() {
    private val args by navArgs<TrackDetailActivityArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track_detail)

        val position = args.position
    }
}