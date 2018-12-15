package com.katkov.lolachievements.data.local.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Summoner {

    @PrimaryKey
    private long id;
    private String name;
    private boolean isLoggedIn;

    public Summoner(long id, String name, boolean isLoggedIn) {
        this.id = id;
        this.name = name;
        this.isLoggedIn = isLoggedIn;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }
}
