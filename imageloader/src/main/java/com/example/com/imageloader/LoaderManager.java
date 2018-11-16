package com.example.com.imageloader;

/**
 * 图片加载管理，可定制图片加载框架
 * Created by 710330 on 2018/11/16.
 */
public class LoaderManager {
    private static ILoader innerLoader;
    private static ILoader externalLoader;

    public static void setLoader(ILoader loader) {
        if (externalLoader == null && loader != null) {
            externalLoader = loader;
        }
    }

    public static ILoader getLoader() {
        if (innerLoader == null) {
            synchronized (LoaderManager.class) {
                if (innerLoader == null) {
                    if (externalLoader != null) {
                        innerLoader = externalLoader;
                    } else {
                        innerLoader = new GlideLoader();
                    }
                }
            }
        }
        return innerLoader;
    }
}
