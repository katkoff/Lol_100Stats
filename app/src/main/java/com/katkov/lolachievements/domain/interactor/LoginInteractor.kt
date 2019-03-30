package com.katkov.lolachievements.domain.interactor

import com.katkov.lolachievements.data.local.repository.LoginRepository
import com.katkov.lolachievements.domain.model.LoginModel
import javax.inject.Inject

class LoginInteractor
@Inject constructor(
    private val loginRepository: LoginRepository
) {
    fun saveLoginModel(loginModel: LoginModel) {
        loginRepository.saveLoginModel(loginModel)
    }

    fun getLoginModel(): LoginModel? {
        return loginRepository.getLoginModel()
    }

    fun removeLoginModel() {
        loginRepository.removeLoginModel()
    }
}