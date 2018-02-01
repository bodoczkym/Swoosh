package com.developer.shaddox.swoosh

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.welcome_activity.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_activity)

        getStartedButton.setOnClickListener { startActivity<DesiredLeagueActivity>() }
    }
}
