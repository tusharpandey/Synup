package com.app.synuptest.model.api;


import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.app.synuptest.model.api.ViewType.CONTENT;
import static com.app.synuptest.model.api.ViewType.ERROR;
import static com.app.synuptest.model.api.ViewType.LOADER;

@Retention(RetentionPolicy.SOURCE)
@IntDef({LOADER, ERROR, CONTENT})
public @interface ViewType {
    int LOADER = 1;
    int ERROR = 2;
    int CONTENT = 5;
}

