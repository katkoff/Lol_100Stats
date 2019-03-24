package com.katkov.lolachievements.data.local.prefser

import com.github.pwittchen.prefser.library.rx2.Prefser
import com.katkov.lolachievements.domain.model.EntryInfoModel

import javax.inject.Inject

class EntryInfoHolder
@Inject
constructor(private val prefser: Prefser) {

    fun getEntryInfo(): EntryInfoModel? {
        return prefser.get(ENTRY_INFO_KEY, EntryInfoModel::class.java, null)
    }

    fun putEntryInfo(entryInfoModel: EntryInfoModel) {
        prefser.put(ENTRY_INFO_KEY, entryInfoModel)
    }

    fun removeEntryInfo() {
        prefser.remove(ENTRY_INFO_KEY)
    }

    companion object {

        private const val ENTRY_INFO_KEY = "entry_info_key"
    }
}
