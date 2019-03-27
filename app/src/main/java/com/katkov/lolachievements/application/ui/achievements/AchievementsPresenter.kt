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
            "http://www.clandlan.net/foros/uploads/profile/photo-thumb-42218.png?_r=1547587404",
            "Test title 1",
            "Test description 1"))
        achievements.add(AchievementModel(
            "http://www.clandlan.net/foros/uploads/profile/photo-thumb-42218.png?_r=1547587404",
            "Test title 2",
            "Test description 2"))
        achievements.add(AchievementModel(
            "http://www.clandlan.net/foros/uploads/profile/photo-thumb-42218.png?_r=1547587404",
            "Test title 3",
            "Test description 3"))

        viewState.fillAchievements(achievements)
    }
}