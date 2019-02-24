package com.katkov.lolachievements.data.mappers;

import java.util.ArrayList;
import java.util.List;

public abstract class Mapper<S, D> {

    public abstract D map(S source);

    public final List<D> mapList(List<S> sourceItems) {
        List<D> result = new ArrayList<>();

        for (final S item : sourceItems) {
            result.add(map(item));
        }

        return result;
    }
}