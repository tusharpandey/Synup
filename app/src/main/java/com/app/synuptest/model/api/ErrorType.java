package com.app.synuptest.model.api;


import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.app.synuptest.model.api.ErrorType.API_ERROR;
import static com.app.synuptest.model.api.ErrorType.DEFAULT_ERROR;
import static com.app.synuptest.model.api.ErrorType.EMPTY_RESULT;
import static com.app.synuptest.model.api.ErrorType.NETWORK_FAILURE_AFTER_API_HIT;
import static com.app.synuptest.model.api.ErrorType.NONE;
import static com.app.synuptest.model.api.ErrorType.NO_NETWORK_ERROR;


@Retention(RetentionPolicy.SOURCE)
@IntDef({API_ERROR, NO_NETWORK_ERROR, NETWORK_FAILURE_AFTER_API_HIT, EMPTY_RESULT, DEFAULT_ERROR, NONE})
public @interface ErrorType {
    int API_ERROR = 1;
    int NO_NETWORK_ERROR = 2;
    int NETWORK_FAILURE_AFTER_API_HIT = 5;
    int EMPTY_RESULT = 6;
    int DEFAULT_ERROR = 7;
    int NONE = 8;
}

