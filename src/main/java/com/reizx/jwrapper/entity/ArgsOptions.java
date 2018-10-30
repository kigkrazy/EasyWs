package com.reizx.jwrapper.entity;

import lombok.Data;
import org.kohsuke.args4j.Option;

/**
 * 参数实体类
 */
@Data
public class ArgsOptions  {
    @Option(name="-c", aliases = "--config", usage="config path")
    private String config;//环境地址

    @Option(name="-d", aliases = "--debug", usage="debug module, print some log")
    private boolean debug;//是否debug模式

    @Option(name="-h", aliases = "--help", usage="show help")
    private boolean help;//帮助
}
