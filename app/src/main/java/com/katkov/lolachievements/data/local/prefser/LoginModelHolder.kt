package com.katkov.lolachievements.data.local.prefser

import com.github.pwittchen.prefser.library.rx2.Prefser
import com.katkov.lolachievements.data.local.model.LoginPrefModel
import javax.inject.Inject

class LoginModelHolder
@Inject
constructor(private val prefser: Prefser) {

    fun getLoginModel(): LoginPrefModel? {
        return prefser.get(LOGIN_MODEL_KEY, LoginPrefModel::class.java, null)
    }

    fun putLoginModel(loginPrefModel: LoginPrefModel) {
        prefser.put(LOGIN_MODEL_KEY, loginPrefModel)
    }

    fun removeLoginModel() {
        prefser.remove(LOGIN_MODEL_KEY)
    }

    companion object {
        private const val LOGIN_MODEL_KEY = "login_model_key"
    }
}
