package com.katkov.lolachievements.data.local.repository

import com.katkov.lolachievements.data.local.prefser.LoginModelHolder
import com.katkov.lolachievements.data.mappers.LoginModelMapper
import com.katkov.lolachievements.domain.model.LoginModel
import javax.inject.Inject

class PrefLoginRepository
@Inject
constructor(
    private val loginModelHolder: LoginModelHolder,
    private val mapper: LoginModelMapper
) {

    fun saveLoginModel(loginModel: LoginModel) {
        loginModelHolder.putLoginModel(mapper.loginModelToPrefModel(loginModel))
    }

    fun getLoginModel(): LoginModel? {
        return mapper.loginPrefModelToDomainModel(loginModelHolder.getLoginModel())
    }

    fun removeLoginModel() {
        loginModelHolder.removeLoginModel()
    }
}
