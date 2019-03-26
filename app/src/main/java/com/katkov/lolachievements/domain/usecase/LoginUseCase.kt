package com.katkov.lolachievements.domain.usecase

import com.katkov.lolachievements.data.local.service.LoginService
import com.katkov.lolachievements.domain.model.LoginModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginUseCase
@Inject
constructor(private val loginService: LoginService) {

    fun saveLoginModel(loginModel: LoginModel) {
        loginService.saveLoginModel(loginModel)
    }

    fun removeLoginModel() {
        loginService.removeLoginModel()
    }
}
