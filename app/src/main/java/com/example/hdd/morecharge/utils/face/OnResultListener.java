/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.example.hdd.morecharge.utils.face;

import com.example.hdd.morecharge.utils.FaceError;

public interface OnResultListener<T> {
    void onResult(T result);

    void onError(FaceError error);
}
