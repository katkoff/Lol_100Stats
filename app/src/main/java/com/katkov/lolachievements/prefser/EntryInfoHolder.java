package com.katkov.lolachievements.prefser;

import com.github.pwittchen.prefser.library.rx2.Prefser;
import com.katkov.lolachievements.domain.model.EntryInfoModel;

import javax.inject.Inject;

public class EntryInfoHolder {

    private static final String ENTRY_INFO_KEY = "entry_info_key";

    private final Prefser prefser;

    @Inject
    public EntryInfoHolder(Prefser prefser) {
        this.prefser = prefser;
    }

    public void putEntryInfo(EntryInfoModel entryInfoModel) {
        prefser.put(ENTRY_INFO_KEY, entryInfoModel);
    }

    public EntryInfoModel getEntryInfoModel() {
        return prefser.get(ENTRY_INFO_KEY, EntryInfoModel.class, null);
    }

    public void removeEntryInfo() {
        prefser.remove(ENTRY_INFO_KEY);
    }
}
