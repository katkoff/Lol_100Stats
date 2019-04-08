package com.katkov.lolachievements.domain.interactor

import com.katkov.lolachievements.data.local.repository.PrefLoginRepository
import com.katkov.lolachievements.domain.model.LoginModel
import javax.inject.Inject

class LoginInteractor
@Inject constructor(
    private val prefLoginRepository: PrefLoginRepository
) {
    fun saveLoginModel(loginModel: LoginModel) = prefLoginRepository.saveLoginModel(loginModel)

    fun getLoginModel(): LoginModel? = prefLoginRepository.getLoginModel()

    fun removeLoginModel() = prefLoginRepository.removeLoginModel()
}