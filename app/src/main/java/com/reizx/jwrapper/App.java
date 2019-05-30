package com.reizx.jwrapper;

import com.reizx.jwrapper.entity.ArgsOptions;
import org.apache.commons.lang3.StringUtils;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import trikita.log.Log;

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
        EnvHelper.initEnv("jwc-log", Log.V, 10 * 1000);
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
}
