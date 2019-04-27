#include <jni.h>
#include <string>
#include <opencv2/opencv.hpp>

using namespace cv;
using namespace std;

extern "C"
JNIEXPORT jstring JNICALL Java_com_ixyxj_cv3_table_JniUtil_parseTable(JNIEnv *env, jclass jcl, jstring imagePath_) {
    const char *imagePath = env->GetStringUTFChars(imagePath_, 0);
    //读取图片, 并转灰阶
    const Mat image = imread(imagePath, 1);
    Mat gray;
//    if (image.channels() != 1) {
//        cvtColor(image, gray, CV_RGB2GRAY);
//    } else {
//        gray = image;
//    };
//    //二值化
//    Mat threshold;
//    adaptiveThreshold(~gray, threshold, 255, ADAPTIVE_THRESH_MEAN_C, THRESH_BINARY, 161, -2);
//    Mat h = threshold.clone();
//    Mat v = threshold.clone();
//
//    int scale = 15;

//    //水平线提取
//    int h_size = h.cols / scale;
//    //机构化元素
//    Mat element = getStructuringElement(MORPH_RECT, Size(h_size, 1));
//    erode(h, h, element, Point(-1, -1));
//    dilate(h, h, element, Point(-1, -1));
//    //竖直线提取
//    int v_size = v.rows / scale;
//    Mat v_element = getStructuringElement(MORPH_RECT, Size(1, v_size));
//    erode(v, v, v_element, Point(-1, -1));
//    dilate(v, v, v_element, Point(-1, -1));
//
//    //将两张图片进行操作
//    bitwise_and(h, v, image);
//    imshow("table", image);
//    Mat mask = h + v;
//    imshow("mask", mask);
//    env->ReleaseStringUTFChars(imagePath_, imagePath);
    return env->NewStringUTF("success");
}
