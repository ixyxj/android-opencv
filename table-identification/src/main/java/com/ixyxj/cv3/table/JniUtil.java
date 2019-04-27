package com.ixyxj.cv3.table;

/**
 * For more information, you can visit https://github.com/ixyxj,
 * or contact me by xyxjun@gmail.com
 *
 * @author silen on 2019/4/27 23:56
 * Copyright (c) 2019 in FORETREE
 */
public class JniUtil {
    static {
        System.loadLibrary("native-lib");
    }

    public static native String parseTable(String imagePath);
}
