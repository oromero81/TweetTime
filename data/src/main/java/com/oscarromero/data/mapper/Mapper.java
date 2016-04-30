package com.oscarromero.data.mapper;

/**
 * Created by Oscar on 30/4/16.
 */
public interface Mapper<F, T> {
    T transform(F origin);
}