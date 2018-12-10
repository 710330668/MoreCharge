/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.example.hdd.morecharge.utils.face;

import com.example.hdd.morecharge.utils.FaceError;

/**
 * JSON解析
 * @param <T>
 */
public interface Parser<T> {
    T parse(String json) throws FaceError;
}
