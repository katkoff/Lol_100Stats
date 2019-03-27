package com.katkov.lolachievements.application.ui.achievements

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.katkov.lolachievements.domain.model.AchievementModel
import javax.inject.Inject

@InjectViewState
class AchievementsPresenter
@Inject
internal constructor() : MvpPresenter<AchievementsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        //In future replace to Repository
        val achievements = mutableListOf<AchievementModel>()
        achievements.add(AchievementModel(
            "http://ddragon.leagueoflegends.com/cdn/9.3.1/img/spell/SummonerBarrier.png",
            "Готов к бою",
            "Прошел обучение"))
        achievements.add(AchievementModel(
            "http://www.clandlan.net/foros/uploads/profile/photo-thumb-42218.png?_r=1547587404",
            "Test title 2",
            "Сыграть 5 матчей"))
        achievements.add(AchievementModel(
            "http://www.clandlan.net/foros/uploads/profile/photo-thumb-42218.png?_r=1547587404",
            "Бывалый",
            "Сыграть 25 матчей"))
        achievements.add(AchievementModel(
            "http://www.clandlan.net/foros/uploads/profile/photo-thumb-42218.png?_r=1547587404",
            "Ветеран",
            "Сыграть 100 матчей"))
        achievements.add(AchievementModel(
            "http://www.clandlan.net/foros/uploads/profile/photo-thumb-42218.png?_r=1547587404",
            "Верховный",
            "Сыграть 500 матчей"))

        viewState.fillAchievements(achievements)
    }
}