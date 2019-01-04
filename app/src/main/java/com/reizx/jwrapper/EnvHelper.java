package com.reizx.jwrapper;

import com.reizx.jwrapper.util.JwcLog;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.https.HttpsUtils;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * 环境初始化工具类。
 * 用于初始化各个通用的工具类
 */
public class EnvHelper {

    public static void initEnv(String logTag, int logLevel, long timeout) {
        initLog(logTag, logLevel);//初始化日志工具类
        initHttpUtils(logTag, timeout);//初始化okhttputils工具类
    }

    /**
     * 初始化log工具类
     */
    private static void initLog(String logTag, int logLevel) {
        // 非debug模式下只显示W级别以上的日志
        JwcLog.init(logTag, logLevel);
    }

    /**
     * 初始化HTTP工具类
     */
    private static void initHttpUtils(String logTag, long timeout) {
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)//设置可访问所有的https网站
//                .addInterceptor(new HmsLogInterceptor(logTag))
                .connectTimeout(timeout, TimeUnit.MILLISECONDS)
                .readTimeout(timeout, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }
}
