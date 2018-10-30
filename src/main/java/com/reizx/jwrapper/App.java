package com.reizx.jwrapper;

import com.reizx.jwrapper.entity.ArgsOptions;
import org.apache.commons.lang3.StringUtils;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class App {
    private static AppContext app;//全局上下文

    /**
     * 程序入口
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        parseArgs(args);//解析参数
    }


    public static void parseArgs(String[] args) throws CmdLineException {
        ArgsOptions options = new ArgsOptions();
        CmdLineParser parser = new CmdLineParser(options);
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
