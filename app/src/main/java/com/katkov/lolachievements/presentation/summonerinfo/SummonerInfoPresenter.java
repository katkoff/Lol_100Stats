package com.katkov.lolachievements.presentation.summonerinfo;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.katkov.lolachievements.domain.interactor.SummonerInfoInteractor;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class SummonerInfoPresenter extends MvpPresenter<SummonerInfoView> {

    private final SummonerInfoInteractor summonerInfoInteractor;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    public SummonerInfoPresenter(SummonerInfoInteractor summonerInfoInteractor) {
        this.summonerInfoInteractor = summonerInfoInteractor;
    }

    @Override
    protected void onFirstViewAttach() {
        Disposable disposable = summonerInfoInteractor.getSummonerInfo()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        summoner -> getViewState().fillSummonerInfo(summoner),
                        Throwable::printStackTrace
                );
        compositeDisposable.add(disposable);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }
}
