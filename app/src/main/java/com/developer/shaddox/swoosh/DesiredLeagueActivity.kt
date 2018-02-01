package com.developer.shaddox.swoosh

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import kotlinx.android.synthetic.main.activity_desired_league.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import java.io.Serializable

class DesiredLeagueActivity : AppCompatActivity() {
    private var leagueLevelData: LeagueLevelData = LeagueLevelData()

    companion object {
        val TAG = "DesiredLeagueActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desired_league)

        toLevelSelectActivityButton.setOnClickListener {
            if (leagueLevelData.league == League.NONE) {
                toast("Please select your league!")
            } else {
                startActivity<LevelSelectActivity>("leagueLevelData" to leagueLevelData as Serializable)
            }
        }

        mensLeagueButton.setOnClickListener {
            leagueLevelData = LeagueLevelData(League.MENS)
            setButtonBackgrounds(mensLeagueButton)
        }
        womensLeagueButton.setOnClickListener {
            leagueLevelData = LeagueLevelData(League.WOMENS)
            setButtonBackgrounds(womensLeagueButton)
        }
        coedLeagueButton.setOnClickListener {
            leagueLevelData = LeagueLevelData(League.CO_ED)
            setButtonBackgrounds(coedLeagueButton)
        }
    }

    private fun setButtonBackgrounds(btn: Button) {
        when (btn) {
            mensLeagueButton -> {
                mensLeagueButton.setBackgroundResource(R.drawable.btn_open_pressed)
                womensLeagueButton.setBackgroundResource(R.drawable.btn_open)
                coedLeagueButton.setBackgroundResource(R.drawable.btn_open)
            }
            womensLeagueButton -> {
                mensLeagueButton.setBackgroundResource(R.drawable.btn_open)
                womensLeagueButton.setBackgroundResource(R.drawable.btn_open_pressed)
                coedLeagueButton.setBackgroundResource(R.drawable.btn_open)
            }
            coedLeagueButton -> {
                mensLeagueButton.setBackgroundResource(R.drawable.btn_open)
                womensLeagueButton.setBackgroundResource(R.drawable.btn_open)
                coedLeagueButton.setBackgroundResource(R.drawable.btn_open_pressed)
            }
        }
    }
}
