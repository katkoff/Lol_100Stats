package com.katkov.lolachievements.application.ui.summonerinfo;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.katkov.lolachievements.domain.interactor.SummonerInfoInteractor;
import com.katkov.lolachievements.prefser.EntryInfoHolder;

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
        getViewState().showProgressBar();
        String summonerName = entryInfoHolder.getEntryInfoModel().getSummonerName();
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
