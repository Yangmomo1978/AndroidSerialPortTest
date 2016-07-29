LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE := serial_port
LOCAL_LDFLAGS := -Wl,--build-id
LOCAL_LDLIBS := \
	-llog \

LOCAL_SRC_FILES := \
	/Users/omarfaroque/AndroidSerialPortTest/app/src/main/jni/Android.mk \
	/Users/omarfaroque/AndroidSerialPortTest/app/src/main/jni/Application.mk \
	/Users/omarfaroque/AndroidSerialPortTest/app/src/main/jni/gen_SerialPort_h.sh \
	/Users/omarfaroque/AndroidSerialPortTest/app/src/main/jni/SerialPort.c \

LOCAL_C_INCLUDES += /Users/omarfaroque/AndroidSerialPortTest/app/src/main/jni
LOCAL_C_INCLUDES += /Users/omarfaroque/AndroidSerialPortTest/app/src/debug/jni

include $(BUILD_SHARED_LIBRARY)
