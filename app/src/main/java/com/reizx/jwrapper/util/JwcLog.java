package com.reizx.jwrapper.util;

import lombok.NonNull;
import trikita.log.Log;

public class JwcLog {
    private static String tag = "xlog";

    public static void init(String tag) {
        init(tag, Log.V);
    }

    /**
     * log初始化函数
     *
     * @param tag
     * @param minilevel 低于这个级别的log将不会显示
     */
    public static void init(String tag, int minilevel) {
        JwcLog.tag = tag;
        Log.usePrinter(Log.SYSTEM, true);
        Log.level(minilevel);
    }

    public static void d(@NonNull String message) {
        Log.d(message);
    }

    public static void dt(@NonNull String tag, @NonNull String message) {
        message = String.format("[%s] : %s", tag, message);
        Log.d(message);
    }

    public static void dd(@NonNull String message, Object... args) {
        Log.d(String.format(message, args));
    }

    public static void ddt(@NonNull String tag, @NonNull String message, Object... args) {
        message = String.format("[%s] : %s", tag, String.format(message, args));
        Log.d(message);
    }

    public static void i(@NonNull String message) {
        Log.i(message);
    }

    public static void it(@NonNull String tag, @NonNull String message) {
        message = String.format("[%s] : %s", tag, message);
        Log.i(message);
    }

    public static void ii(@NonNull String message, Object... args) {
        Log.i(String.format(message, args));
    }

    public static void iit(@NonNull String tag, @NonNull String message, Object... args) {
        message = String.format("[%s] : %s", tag, String.format(message, args));
        Log.i(message);
    }

    public static void v(@NonNull String message) {
        Log.v(message);
    }

    public static void vt(@NonNull String tag, @NonNull String message) {
        message = String.format("[%s] : %s", tag, message);
        Log.v(message);
    }

    public static void vv(@NonNull String message, Object... args) {
        Log.v(String.format(message, args));
    }

    public static void vvt(@NonNull String tag, @NonNull String message, Object... args) {
        message = String.format("[%s] : %s", tag, String.format(message, args));
        Log.v(message);
    }

    public static void w(@NonNull String message) {
        Log.w(message);
    }

    public static void wt(@NonNull String tag, @NonNull String message) {
        message = String.format("[%s] : %s", tag, message);
        Log.w(message);
    }

    public static void ww(@NonNull String message, Object... args) {
        Log.w(String.format(message, args));
    }

    public static void wwt(@NonNull String tag, @NonNull String message, Object... args) {
        message = String.format("[%s] : %s", tag, String.format(message, args));
        Log.w(message);
    }


    public static void e(@NonNull String message) {
        Log.e(message);
    }

    public static void et(@NonNull String tag, @NonNull String message) {
        message = String.format("[%s] : %s", tag, message);
        Log.e(message);
    }

    public static void ee(@NonNull String message, Object... args) {
        Log.e(String.format(message, args));
    }

    public static void eet(@NonNull String tag, @NonNull String message, Object... args) {
        message = String.format("[%s] : %s", tag, String.format(message, args));
        Log.e(message);
    }

}
