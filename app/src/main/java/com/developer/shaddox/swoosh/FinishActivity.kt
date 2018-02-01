package com.developer.shaddox.swoosh

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {

    private var leagueLevelData: LeagueLevelData = LeagueLevelData()

    companion object {
        val TAG = "FinishActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        leagueLevelData = intent.extras.get("leagueLevelData") as LeagueLevelData

        Log.d(TAG, "The LeagueLevelData is: $leagueLevelData")

        val league = if (leagueLevelData.league == League.CO_ED) "co-ed" else leagueLevelData.league.toString().toLowerCase()
        finishText.text = String.format(getString(R.string.searchText), league, leagueLevelData.level.toString().toLowerCase())
    }
}
