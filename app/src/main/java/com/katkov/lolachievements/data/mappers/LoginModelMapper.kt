package com.katkov.lolachievements.data.mappers

import com.katkov.lolachievements.data.local.model.LoginPrefModel
import com.katkov.lolachievements.domain.model.LoginModel
import javax.inject.Inject

class LoginModelMapper
@Inject
constructor() {

    fun loginModelToPrefModel(loginModel: LoginModel): LoginPrefModel =
        LoginPrefModel(loginModel.summonerName, loginModel.serverCode)

    fun loginPrefModelToDomainModel(loginPrefModel: LoginPrefModel?): LoginModel? =
        loginPrefModel?.let {
            LoginModel(it.summonerName, it.serverCode)
        }
}