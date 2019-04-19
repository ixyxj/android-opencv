package com.ixyxj.opencv.samples

import android.app.Application
import org.opencv.android.OpenCVLoader

/**
 * For more information, you can visit https://github.com/ixyxj,
 * or contact me by xyxjun@gmail.com
 * @author silen on 2019/4/19 2:45
 * Copyright (c) 2019 in FORETREE
 */
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        OpenCVLoader.initDebug()
    }
}