package com.katkov.lolachievements.domain.service;

import com.katkov.lolachievements.domain.model.EntryInfoModel;
import com.katkov.lolachievements.prefser.EntryInfoHolder;

import javax.inject.Inject;

public class LoginService {

    private final EntryInfoHolder entryInfoHolder;

    @Inject
    public LoginService(EntryInfoHolder entryInfoHolder) {
        this.entryInfoHolder = entryInfoHolder;
    }

    public void saveEntryInfo(EntryInfoModel entryInfoModel) {
        entryInfoHolder.putEntryInfo(entryInfoModel);
    }

    public void removeEntryInfo() {
        entryInfoHolder.removeEntryInfo();
    }
}
