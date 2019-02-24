package com.katkov.lolachievements.application.ui.checkentryinfo;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.katkov.lolachievements.domain.model.EntryInfoModel;

public interface CheckEntryInfoView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void fillInfo(EntryInfoModel entryInfoModel);
}
