package com.katkov.lolachievements.data.mappers

import com.katkov.lolachievements.data.local.model.LoginPrefModel
import com.katkov.lolachievements.domain.model.LoginModel
import javax.inject.Inject

class LoginModelMapper
@Inject
constructor() {

    fun loginModelToPrefModel(loginModel: LoginModel): LoginPrefModel {
        return LoginPrefModel(loginModel.summonerName, loginModel.serverCode)
    }

    fun loginPrefModelToDomainModel(loginPrefModel: LoginPrefModel?): LoginModel? {
        return loginPrefModel?.let {
            LoginModel(it.summonerName, it.serverCode)
        }
    }
}