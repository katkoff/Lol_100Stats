package com.katkov.lolachievements.data.local.prefser

import com.github.pwittchen.prefser.library.rx2.Prefser
import com.katkov.lolachievements.domain.model.LoginModel

import javax.inject.Inject

class LoginModelHolder
@Inject
constructor(private val prefser: Prefser) {

    fun getLoginModel(): LoginModel? {
        return prefser.get(LOGIN_MODEL_KEY, LoginModel::class.java, null)
    }

    fun putLoginModel(loginModel: LoginModel) {
        prefser.put(LOGIN_MODEL_KEY, loginModel)
    }

    fun removeLoginModel() {
        prefser.remove(LOGIN_MODEL_KEY)
    }

    companion object {

        private const val LOGIN_MODEL_KEY = "login_model_key"
    }
}
