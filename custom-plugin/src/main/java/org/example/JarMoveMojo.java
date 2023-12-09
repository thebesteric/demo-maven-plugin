package org.example;

import org.apache.commons.io.FileUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.io.IOException;

/**
 * MoveMojo
 * 实现功能：把最终打好的 jar 包移动到指定的目录
 *
 * @author wangweijun
 * @version v1.0
 * @since 2023-12-08 18:49:21
 */
@Mojo(name = "jarMove", defaultPhase = LifecyclePhase.PACKAGE)
public class JarMoveMojo extends AbstractMojo {
    @Parameter(defaultValue = "${project}")
    private MavenProject project;

    // 指定要移动到的目录的绝对路径
    @Parameter(required = true)
    private String toAbsoluteDir;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        Log log = getLog();

        // 路径：/Users/wangweijun/IdeaProjects/demo-maven-plugin/custom-plugin-test/target
        String directory = project.getBuild().getDirectory();

        // custom-plugin-test.jar
        String finalName = project.getBuild().getFinalName();
        String packaging = project.getPackaging();
        String jarName = finalName + "." + packaging;
        String jarPath = directory + File.separator + jarName;

        log.info(">>> JarName = " + jarName);
        log.info(">>> FromAbsoluteDir = " + directory);
        log.info(">>> ToAbsoluteDir = " + toAbsoluteDir);

        try {
            FileUtils.copyFileToDirectory(new File(jarPath), new File(toAbsoluteDir));
            log.info(">>> 拷贝完成：" + toAbsoluteDir + File.separator + jarName);
        } catch (IOException e) {
            log.error(e);
        }
    }
}
