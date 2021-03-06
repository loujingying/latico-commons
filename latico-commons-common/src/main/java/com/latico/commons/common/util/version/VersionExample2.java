package com.latico.commons.common.util.version;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * <PRE>
 * 记录程序的版本信息
 * 使用示例
 Version version = new Version();
 System.out.println(version.getVersionInfosByMarkdown());
 * </PRE>
 *
 * @author: latico
 * @date: 2020-01-13 10:07
 * @version: 1.0
 */
public class VersionExample2 {

    /**
     * 存储的版本信息
     */
    private final Queue<VersionInfo> versionInfos = new ConcurrentLinkedQueue<>();

    /**
     * @return 所有版本信息
     */
    public Queue<VersionInfo> getVersionInfos() {
        return versionInfos;
    }


    /**
     * markdown的格式
     *
     * @return
     */
    public String getVersionInfosByMarkdown() {
        return VersionUtils.toVersionInfosToMarkdownStr(versionInfos);
    }

    /**
     * HTML的格式
     *
     * @return
     */
    public String getVersionInfosByHtml() {
        return VersionUtils.toVersionInfosToHtmlTable(versionInfos);
    }

    /**
     * 增加一个版本信息
     *
     * @param version    版本号
     * @param author     作者
     * @param updateTime 更新时间
     * @param updateInfo 更新信息
     */
    private void addVersionInfo(String projectName, String version, String author, String updateTime, String updateInfo) {
        versionInfos.add(VersionInfo.build(projectName, version, author, updateTime, updateInfo));
    }

    /**
     * 初始化项目版本信息
     */
    public VersionExample2() {
        //在这里不断增加
        addVersionInfo("项目名称", "1.0", "latico", "2020-01-13", "构建项目");
    }

}
