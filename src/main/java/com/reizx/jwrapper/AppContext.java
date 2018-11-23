package com.reizx.jwrapper;

import com.reizx.jwrapper.constants.Constants;
import lombok.Data;

import java.io.File;

/**
 * 全局上下文
 */
@Data
public class AppContext {
    private static AppContext app;//上下文
    private String configPath = System.getProperty("user.dir")+ File.separator + Constants.CONFIG_DEFUALT_NAME;//环境配置根目录, 默认为当前工作目录
    private boolean debug = false;//是否调试模式

    public static AppContext getApp() {
        if (app == null)
            app = new AppContext();
        return app;
    }
}
