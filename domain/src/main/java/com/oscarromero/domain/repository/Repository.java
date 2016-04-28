package com.oscarromero.domain.repository;

import rx.Observable;

/**
 * Created by Oscar on 28/4/16.
 */
public interface Repository<T> {
    Observable<T> getEntities();
}