# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.
cmake_minimum_required(VERSION 3.4.1)
set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_SOURCE_DIR}/build/outputs/jniLibs/${ANDROID_ABI})
message(${ANDROID_ABI})
set( CPP_DIR src/main/cpp)

#查找系统库
#find_library( log-lib log )

#头文件
set(opencv_include_dir src/main/cpp/include)
include(AndroidNdkGdb)
include(AndroidNdkModules)
include_directories( ${opencv_include_dir} )

# 静态库
add_library( opencv_calib3d STATIC IMPORTED )
set_target_properties( opencv_calib3d PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/libs/${ANDROID_ABI}/libopencv_calib3d.a )
add_library( opencv_core STATIC IMPORTED )
set_target_properties( opencv_core PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/libs/${ANDROID_ABI}/libopencv_core.a )
add_library( opencv_features2d STATIC IMPORTED )
set_target_properties( opencv_features2d PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/libs/${ANDROID_ABI}/libopencv_features2d.a )
add_library( opencv_imgcodecs STATIC IMPORTED )
set_target_properties( opencv_imgcodecs PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/libs/${ANDROID_ABI}/libopencv_imgcodecs.a )
add_library( opencv_imgproc STATIC IMPORTED )
set_target_properties( opencv_imgproc PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/libs/${ANDROID_ABI}/libopencv_imgproc.a )
add_library( opencv_objdetect STATIC IMPORTED )
set_target_properties( opencv_objdetect PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/libs/${ANDROID_ABI}/libopencv_objdetect.a )
add_library( opencv_photo STATIC IMPORTED )
set_target_properties( opencv_photo PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/libs/${ANDROID_ABI}/libopencv_photo.a )
add_library( opencv_shape STATIC IMPORTED )
set_target_properties( opencv_shape PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/libs/${ANDROID_ABI}/libopencv_shape.a )

add_library( native-lib SHARED
        src/main/cpp/native-lib.cpp)

target_link_libraries(
        native-lib
        opencv_calib3d
        opencv_core
        opencv_features2d
        opencv_imgcodecs
        opencv_imgproc
        opencv_objdetect
        opencv_photo
        opencv_shape
        android
        log
)