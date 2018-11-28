package com.reizx.jwrapper;

import com.reizx.jwrapper.entity.ArgsOptions;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.https.HttpsUtils;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.util.concurrent.TimeUnit;

public class App {
    private static AppContext app = AppContext.getApp();//全局上下文
    private static ArgsOptions options = new ArgsOptions();//参数解析

    /**
     * 程序入口
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        parseArgs(args);//解析参数
        initHttpUtils();

    }

    /**
     * 解析参数
     *
     * @param args 参数
     * @throws CmdLineException
     */
    public static void parseArgs(String[] args) throws CmdLineException {
        ArgsOptions options = new ArgsOptions();
        CmdLineParser parser = new CmdLineParser(options);
        parser.parseArgument(args);
        if (options.isHelp()) {//当help参数不为空的时候，显示帮助
            System.out.println("show the jwrapper helpe : ");
            parser.printUsage(System.out);
            System.exit(0);
        }

        if (!StringUtils.isEmpty(options.getConfig())) {//设置配置路径
            AppContext.getApp().setConfigPath(options.getConfig());
        }

        AppContext.getApp().setDebug(options.isDebug());//设置debug标志位
    }

    /**
     * 初始化http工具类
     */
    public static void initHttpUtils() {
        long timeout = 15 * 1000;
        if (AppContext.getApp().isDebug()){
            timeout = 60 * 1000;
        }

        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)//设置可访问所有的https网站
                //.addInterceptor(new LoggerInterceptor("TAG"))去掉日志
                .connectTimeout(timeout, TimeUnit.MILLISECONDS)
                .readTimeout(timeout, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }
}
