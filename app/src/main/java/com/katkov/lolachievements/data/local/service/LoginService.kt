package com.katkov.lolachievements.data.local.service

import com.katkov.lolachievements.data.local.prefser.EntryInfoHolder
import com.katkov.lolachievements.domain.model.EntryInfoModel
import javax.inject.Inject

class LoginService
@Inject
constructor(private val entryInfoHolder: EntryInfoHolder) {

    fun saveEntryInfo(entryInfoModel: EntryInfoModel) {
        entryInfoHolder.putEntryInfo(entryInfoModel)
    }

    fun removeEntryInfo() {
        entryInfoHolder.removeEntryInfo()
    }
}
