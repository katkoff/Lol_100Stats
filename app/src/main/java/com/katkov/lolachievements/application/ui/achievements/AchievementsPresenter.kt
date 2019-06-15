package com.katkov.lolachievements.application.ui.achievements

import com.arellomobile.mvp.InjectViewState
import com.katkov.lolachievements.application.base.BasePresenter
import com.katkov.lolachievements.data.commonrepository.MatchReferenceRepository
import com.katkov.lolachievements.domain.model.AchievementModel
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@InjectViewState
class AchievementsPresenter
@Inject
internal constructor(
    private val matchReferenceRepository: MatchReferenceRepository
) : BasePresenter<AchievementsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        fillAchievements()
    }

    private fun fillAchievements() {
        getMatches()
    }

    private fun getMatches() {
        matchReferenceRepository.getMatches()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ matches ->
                val achievements = getMatchAchievements(matches.size)
                viewState.fillAchievements(achievements)
                viewState.setProgressEnable(false)
            }, {
                viewState.setProgressEnable(false)
                viewState.showError(Error(it))
                it.printStackTrace()
            }).also { compositeDisposable.add(it) }
    }

    // TODO вынести в другой слой
    private fun getMatchAchievements(matchesCount: Int): MutableList<AchievementModel> {
        val achievements = mutableListOf<AchievementModel>()

        val fiveMatchesProgress = if (matchesCount >= 5) 5 else matchesCount
        val twentyFiveMatchesProgress = if (matchesCount >= 25) 25 else matchesCount
        val oneHundredFiveMatchesProgress = if (matchesCount >= 100) 100 else matchesCount
        val fiveHundredMatchesProgress = if (matchesCount >= 500) 500 else matchesCount
        val oneThousandMatchesProgress = if (matchesCount >= 1000) 1000 else matchesCount
        val oneThousandAndFiveHundredMatchesProgress =
            if (matchesCount >= 1500) 1500 else matchesCount
        val twoThousandMatchesProgress = if (matchesCount >= 2000) 2000 else matchesCount
        val threeThousandMatchesProgress = if (matchesCount >= 3000) 3000 else matchesCount

        achievements.add(
            AchievementModel(
                "http://www.clandlan.net/foros/uploads/profile/photo-thumb-42218.png?_r=1547587404",
                "Начинающий",
                "Сыграть 5 матчей",
                0,
                5,
                fiveMatchesProgress))
        achievements.add(
            AchievementModel(
                "http://www.clandlan.net/foros/uploads/profile/photo-thumb-42218.png?_r=1547587404",
                "Бывалый",
                "Сыграть 25 матчей",
                0,
                25,
                twentyFiveMatchesProgress))
        achievements.add(
            AchievementModel(
                "http://www.clandlan.net/foros/uploads/profile/photo-thumb-42218.png?_r=1547587404",
                "Ветеран",
                "Сыграть 100 матчей",
                0,
                100,
                oneHundredFiveMatchesProgress))
        achievements.add(
            AchievementModel(
                "http://www.clandlan.net/foros/uploads/profile/photo-thumb-42218.png?_r=1547587404",
                "Верховный",
                "Сыграть 500 матчей",
                0,
                500,
                fiveHundredMatchesProgress))
        achievements.add(
            AchievementModel(
                "http://www.clandlan.net/foros/uploads/profile/photo-thumb-42218.png?_r=1547587404",
                "Наиверховнейший",
                "Сыграть 1000 матчей",
                0,
                1000,
                oneThousandMatchesProgress))
        achievements.add(
            AchievementModel(
                "http://www.clandlan.net/foros/uploads/profile/photo-thumb-42218.png?_r=1547587404",
                "Сенатор Палпатин",
                "Сыграть 1500 матчей",
                0,
                1500,
                oneThousandAndFiveHundredMatchesProgress))
        achievements.add(
            AchievementModel(
                "http://www.clandlan.net/foros/uploads/profile/photo-thumb-42218.png?_r=1547587404",
                "Танос",
                "Сыграть 2000 матчей",
                0,
                2000,
                twoThousandMatchesProgress))
        achievements.add(
            AchievementModel(
                "http://www.clandlan.net/foros/uploads/profile/photo-thumb-42218.png?_r=1547587404",
                "Абасраца",
                "Сыграть 3000 матчей",
                0,
                3000,
                threeThousandMatchesProgress))

        return achievements
    }
}