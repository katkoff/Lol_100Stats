package com.katkov.lolachievements.data.commonrepository

import com.katkov.lolachievements.data.cloud.model.match.MatchApiModel
import com.katkov.lolachievements.data.cloud.repository.MatchApiRepository
import com.katkov.lolachievements.data.local.repository.MatchDbRepository
import com.katkov.lolachievements.data.mappers.MatchMapper
import com.katkov.lolachievements.domain.model.MatchReferenceModel
import com.katkov.lolachievements.domain.model.SummonerModel
import io.reactivex.Completable
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MatchRepository
@Inject
constructor(
    private val mapper: MatchMapper,
    private val matchApiRepository: MatchApiRepository,
    private val matchDbRepository: MatchDbRepository,
    private val summonerRepository: SummonerRepository,
    private val matchReferenceRepository: MatchReferenceRepository
) {

    fun loadMatchesToDb(): Completable {
        return getSummonerName()
            .flatMapCompletable { summonerModel ->
                getMatchReferenceList()
                    .flatMapCompletable { matchReferenceList ->
                        Completable.concat(
                            getMatchCompletableList(
                                matchReferenceList, summonerModel))
                    }
            }
    }

    //TODO Заканчивается с ошибкой 503 Service Unavailable.
    // сохраняет рандомом было и 800+ матчей и 250+
    private fun getMatchCompletableList(
        matchReferenceList: List<MatchReferenceModel>,
        summonerModel: SummonerModel
    ): List<Completable> {
        val summonerName = summonerModel.name
        val resultList = mutableListOf<Completable>()

        matchReferenceList.forEach {
            val completable =
                matchApiRepository.getMatchApiModel(it.gameId)
                    .delay(1000, TimeUnit.MILLISECONDS)
                    .flatMapCompletable { matchApiModel ->
                        saveMatchToDb(matchApiModel, summonerName)
                    }

            resultList.add(completable)
        }

        return resultList
    }

    private fun saveMatchToDb(matchApiModel: MatchApiModel, summonerName: String): Completable {
        val matchDbModel = mapper.mapApiMatchToDbModel(matchApiModel, summonerName)
        return matchDbRepository.saveMatchDbModel(matchDbModel)
    }

    private fun getSummonerName(): Single<SummonerModel> =
        summonerRepository.getSummoner()

    private fun getMatchReferenceList(): Single<List<MatchReferenceModel>> =
        matchReferenceRepository.getMatches()

    fun getRowsCount(): Single<Int> = matchDbRepository.getRowsCount()

//
//    fun getChampionList(): Single<List<ChampionModel>> =
//        championDbRepository.getChmpionDbList()
//            .map { mapper.mapDbToDomainList(it) }
//
//    fun updateChampion(): Completable = summonerRepository.getSummoner()
//        .flatMapCompletable { summonerModel ->
//            championApiRepository.getApiChampion(summonerModel.encryptedId)
//                .map { mapper.mapApiToDbList(it) }
//                .flatMapCompletable { masteryDbList ->
//                    championDbRepository.updateChampionDbList(masteryDbList)
//                }
//        }
//
//    fun removeTable(): Completable = championDbRepository.removeTable()
}