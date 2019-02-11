package com.katkov.lolachievements.presentation.summonerinfo;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.katkov.lolachievements.di.BindingNamesUtils;
import com.katkov.lolachievements.domain.interactor.SummonerInfoInteractor;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

@InjectViewState
public class SummonerInfoPresenter extends MvpPresenter<SummonerInfoView> {

    private final SummonerInfoInteractor summonerInfoInteractor;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final String summonerName;

    @Inject
    public SummonerInfoPresenter(
            SummonerInfoInteractor summonerInfoInteractor,
            @Named(BindingNamesUtils.SUMMONER_NAME) String summonerName) {
        this.summonerInfoInteractor = summonerInfoInteractor;
        this.summonerName = summonerName;
    }

    @Override
    protected void onFirstViewAttach() {
        getViewState().showProgressBar();
        Disposable disposable = summonerInfoInteractor.getSummonerDTO(summonerName)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(summonerDTO -> {
                            getViewState().hideProgressBar();
                            getViewState().fillSummonerInfo(summonerDTO);
                        },
                        throwable -> {
                            getViewState().hideProgressBar();
                            getViewState().showError(new Error(throwable));
                            throwable.printStackTrace();
                        });
        compositeDisposable.add(disposable);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }
}
