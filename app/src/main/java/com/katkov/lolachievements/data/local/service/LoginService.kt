package com.katkov.lolachievements.data.local.service

import com.katkov.lolachievements.data.local.prefser.LoginModelHolder
import com.katkov.lolachievements.domain.model.LoginModel
import javax.inject.Inject

class LoginService
@Inject
constructor(private val loginModelHolder: LoginModelHolder) {

    fun saveLoginModel(loginModel: LoginModel) {
        loginModelHolder.putLoginModel(loginModel)
    }

    fun removeLoginModel() {
        loginModelHolder.removeLoginModel()
    }
}
