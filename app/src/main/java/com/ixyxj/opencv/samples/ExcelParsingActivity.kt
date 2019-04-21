package com.ixyxj.opencv.samples;

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity

/**
 * For more information, you can visit https://github.com/ixyxj,
 * or contact me by xyxjun@gmail.com
 *
 * @author silen on 2019/4/19 2:33
 * Copyright (c) 2019 in FORETREE
 */
class ExcelParsingActivity: AppCompatActivity() {
    private val CODE_REQUEST_WRITE_PERMISSION = 110;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excel_parsing)
        initWritePermission()
    }

    private fun initWritePermission() {
        val hasWriteStoragePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (hasWriteStoragePermission == PackageManager.PERMISSION_GRANTED) {
            initExcelParsing()
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), CODE_REQUEST_WRITE_PERMISSION)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == CODE_REQUEST_WRITE_PERMISSION) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                initExcelParsing()
            }
        }
    }

    private fun initExcelParsing() {
        //灰度图片
    }
}
