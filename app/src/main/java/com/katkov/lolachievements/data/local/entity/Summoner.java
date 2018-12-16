package com.katkov.lolachievements.data.local.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Summoner {

    @PrimaryKey
    private long id;
    private String name;
    private int level;
    private boolean isAvailable;

    public Summoner(long id, String name, int level, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.isAvailable = isAvailable;
    }

    public long getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
