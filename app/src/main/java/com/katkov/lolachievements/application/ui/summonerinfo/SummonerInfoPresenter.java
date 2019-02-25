package com.katkov.lolachievements.application.ui.summonerinfo;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.katkov.lolachievements.data.local.prefser.EntryInfoHolder;
import com.katkov.lolachievements.domain.interactor.SummonerInfoInteractor;
import com.katkov.lolachievements.domain.model.ChampionMasteryDTO;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

@InjectViewState
public class SummonerInfoPresenter extends MvpPresenter<SummonerInfoView> {

    private final SummonerInfoInteractor summonerInfoInteractor;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final EntryInfoHolder entryInfoHolder;

    @Inject
    public SummonerInfoPresenter(
            SummonerInfoInteractor summonerInfoInteractor,
            EntryInfoHolder entryInfoHolder) {
        this.summonerInfoInteractor = summonerInfoInteractor;
        this.entryInfoHolder = entryInfoHolder;
    }

    @Override
    protected void onFirstViewAttach() {
        getSummonerInfo();
    }

    private void getSummonerInfo() {
        getViewState().setProgressEnable(true);
        String summonerName = entryInfoHolder.getEntryInfoModel().getSummonerName();
        Disposable disposable = summonerInfoInteractor.getSummonerDTO(summonerName)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(summonerDTO -> {
                            getViewState().fillSummonerInfo(summonerDTO);

                            getChampionsMastery(summonerDTO.getId());
                        },
                        throwable -> {
                            getViewState().setProgressEnable(false);
                            getViewState().showError(new Error(throwable));
                            throwable.printStackTrace();
                        });
        compositeDisposable.add(disposable);
    }

    private void getChampionsMastery(String encryptedSummonerId) {
        Disposable disposable = summonerInfoInteractor.getChampionsMastery(encryptedSummonerId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(championsMasteryList -> {
                            getViewState().setProgressEnable(false);
                            getViewState().fillChestCount(getChestCount(championsMasteryList));
                        },
                        throwable -> {
                            getViewState().setProgressEnable(false);
                            getViewState().showError(new Error(throwable));
                            throwable.printStackTrace();
                        });
        compositeDisposable.add(disposable);
    }

    private int getChestCount(List<ChampionMasteryDTO> masteryDTOS) {
        int count = 0;
        for (ChampionMasteryDTO item : masteryDTOS) {
            if (item.isChestGranted()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }
}
