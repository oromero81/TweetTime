package com.oscarromero.domain.interactor;

import rx.Observable;

/**
 * Created by Oscar on 28/4/16.
 */
public interface Interactor<T> {
     Observable<T> run();
}