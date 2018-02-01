package com.developer.shaddox.swoosh

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_level_select.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import java.io.Serializable

class LevelSelectActivity : AppCompatActivity() {
    private var leagueLevelData: LeagueLevelData = LeagueLevelData()

    companion object {
        val TAG = "LevelSelectActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called")

        leagueLevelData = intent.extras.get("leagueLevelData") as LeagueLevelData

        setContentView(R.layout.activity_level_select)

        Log.d(TAG, "The LeagueLevelData is: $leagueLevelData")

        finishButton.setOnClickListener {
            if (leagueLevelData.level == Level.NONE) {
                toast("Please select your level!")
            } else {
                startActivity<FinishActivity>("leagueLevelData" to leagueLevelData as Serializable)
            }
        }

        beginnerButton.setOnClickListener {
            leagueLevelData = LeagueLevelData(leagueLevelData.league, Level.BEGINNER)
            setButtonBackgrounds(beginnerButton)
        }

        ballerButton.setOnClickListener {
            leagueLevelData = LeagueLevelData(leagueLevelData.league, Level.BALLER)
            setButtonBackgrounds(ballerButton)
        }
    }

    private fun setButtonBackgrounds(btn: Button) {
        when (btn) {
            beginnerButton -> {
                beginnerButton.setBackgroundResource(R.drawable.btn_open_pressed)
                ballerButton.setBackgroundResource(R.drawable.btn_open)
            }
            ballerButton -> {
                beginnerButton.setBackgroundResource(R.drawable.btn_open)
                ballerButton.setBackgroundResource(R.drawable.btn_open_pressed)
            }
        }
    }
}
