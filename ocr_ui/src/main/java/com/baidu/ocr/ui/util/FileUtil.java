/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.ocr.ui.util;

import android.content.Context;

import java.io.File;

public class FileUtil {
    public static File getSaveFrontFile(Context context) {
        File file = new File(context.getFilesDir(), "frontpic.jpg");
        return file;
    }

    public static File getSaveBackFile(Context context) {
        File file = new File(context.getFilesDir(), "backpic.jpg");
        return file;
    }
}
