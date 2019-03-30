package com.katkov.lolachievements.utils

import java.util.*

object ServerNamesHandler {

    val serverCodes = arrayOf(
        "EUN1",
        "EUW1",
        "JP1",
        "KR",
        "LA1",
        "LA2",
        "NA",
        "NA1",
        "OC1",
        "TR1",
        "RU",
        "PBE1")

    val serverNames = arrayOf(
        "EU Nordic and East",
        "EU West", "Japan",
        "Korea",
        "Latin America North",
        "Latin America South",
        "Северная амер",
        "Северная амер 1",
        "Oceania",
        "Turkey",
        "Russia",
        "Public Beta")

    fun getCodeByName(name: String): String {
        val codeIndex = Arrays.asList(*serverNames).indexOf(name)
        return serverCodes[codeIndex]
    }

    fun getNameByCode(code: String): String {
        val nameIndex = Arrays.asList(*serverCodes).indexOf(code)
        return serverNames[nameIndex]
    }

    fun getNameByIndex(index: Int): String {
        return serverNames[index]
    }

    fun getCodeByIndex(index: Int): String {
        return serverCodes[index]
    }
}
