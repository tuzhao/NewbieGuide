package com.app.hubert.guide.util;

import android.text.TextUtils;
import android.util.Log;

import com.app.hubert.guide.NewbieGuide;

import java.util.Locale;

/**
 * 简易控制日志输出的util
 */
public class LogUtil {

    private static final int NONE = 8;
    private static final String tagPrefix = NewbieGuide.TAG;

    /**
     * 修改打印级别
     */
    private static int level = NONE;

    /**
     * 对外开发一个设置log输出级别的方法
     *
     * @param logLevel 定义在android.util.Log类中得几种log级别
     */
    public static void setLogLevel(int logLevel) {
        level = logLevel;
    }

    /**
     * 得到tag（所在类.方法（L:行））
     */
    private static String generateTag() {
        String tag = tagPrefix;
        try {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
            String callerClazzName = stackTraceElement.getClassName();
            callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1);
            tag = "%s.%s(L:%d)";
            tag = String.format(Locale.CHINA, tag, callerClazzName, stackTraceElement.getMethodName(), stackTraceElement.getLineNumber());
            //给tag设置前缀
            tag = TextUtils.isEmpty(tagPrefix) ? tag : tagPrefix + ":" + tag;
        } catch (Exception e) {
            Log.w("LogUtil", "generate tag error", e);
        }
        return tag;
    }

    public static void v(String msg) {
        if (level <= Log.VERBOSE) {
            String tag = generateTag();
            Log.v(tag, msg);
        }
    }

    public static void v(String msg, Throwable tr) {
        if (level <= Log.VERBOSE) {
            String tag = generateTag();
            Log.v(tag, msg, tr);
        }
    }

    public static void d(String msg) {
        if (level <= Log.DEBUG) {
            String tag = generateTag();
            Log.d(tag, msg);
        }
    }

    public static void d(String msg, Throwable tr) {
        if (level <= Log.DEBUG) {
            String tag = generateTag();
            Log.d(tag, msg, tr);
        }
    }

    public static void i(String msg) {
        if (level <= Log.INFO) {
            String tag = generateTag();
            Log.i(tag, msg);
        }
    }

    public static void i(String msg, Throwable tr) {
        if (level <= Log.INFO) {
            String tag = generateTag();
            Log.i(tag, msg, tr);
        }
    }

    public static void w(String msg) {
        if (level <= Log.WARN) {
            String tag = generateTag();
            Log.w(tag, msg);
        }
    }

    public static void w(String msg, Throwable tr) {
        if (level <= Log.WARN) {
            String tag = generateTag();
            Log.w(tag, msg, tr);
        }
    }

    public static void e(String msg) {
        if (level <= Log.ERROR) {
            String tag = generateTag();
            Log.e(tag, msg);
        }
    }

    public static void e(String msg, Throwable tr) {
        if (level <= Log.ERROR) {
            String tag = generateTag();
            Log.e(tag, msg, tr);
        }
    }
}  