package com.katkov.lolachievements.domain.usecase

import com.katkov.lolachievements.data.local.service.LoginService
import com.katkov.lolachievements.domain.model.EntryInfoModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginUseCase
@Inject
constructor(private val loginService: LoginService) {

    fun saveEntryInfo(entryInfoModel: EntryInfoModel) {
        loginService.saveEntryInfo(entryInfoModel)
    }

    fun removeEntryInfo() {
        loginService.removeEntryInfo()
    }
}
