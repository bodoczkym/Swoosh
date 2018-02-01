package com.developer.shaddox.swoosh

import java.io.Serializable

enum class League {
    MENS, WOMENS, CO_ED, NONE
}

enum class Level {
    BEGINNER, BALLER, NONE
}

data class LeagueLevelData(val league: League = League.NONE, val level: Level = Level.NONE) : Serializable