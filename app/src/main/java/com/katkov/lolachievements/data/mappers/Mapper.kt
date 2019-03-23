package com.katkov.lolachievements.data.mappers

import java.util.*

abstract class Mapper<S, D> {

    abstract fun map(source: S): D

    fun mapList(sourceItems: List<S>): List<D> {
        val result = ArrayList<D>()

        for (item in sourceItems) {
            result.add(map(item))
        }

        return result
    }
}