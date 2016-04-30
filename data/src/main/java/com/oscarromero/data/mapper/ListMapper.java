package com.oscarromero.data.mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oscar on 30/4/16.
 */
public class ListMapper<F, T> implements Mapper<List<F>, List<T>> {
    private Mapper<F, T> mapper;

    public ListMapper(Mapper<F, T> mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<T> transform(List<F> origin) {
        List<T>transformed = new ArrayList<>();

        if (origin != null && !origin.isEmpty()) {
            for (F from : origin) {
                transformed.add(mapper.transform(from));
            }
        }
        return transformed;
    }
}