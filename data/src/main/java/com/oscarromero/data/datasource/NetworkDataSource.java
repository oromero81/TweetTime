package com.oscarromero.data.datasource;


import rx.Observable;

/**
 * Created by Oscar on 28/4/16.
 */
public interface NetworkDataSource<T> {
    Observable<T> callToServer();
}