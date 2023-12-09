package org.example;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

/**
 * AnnotationMojo
 *
 * @author wangweijun
 * @version v1.0
 * @since 2023-12-08 18:11:38
 * 使用 @Mojo(name = "annotation") 实现注解定义 plugin
 * name：就是 mojo 的名字
 * defaultPhase：默认的执行阶段
 */
@Mojo(name = "annotation", defaultPhase = LifecyclePhase.PACKAGE)
public class AnnotationMojo extends AbstractMojo {

    /**
     * 用于支持 maven 表达式写法，用于注入插件的配置信息（configuration）
     */
    @Parameter(defaultValue = "${project}")
    private MavenProject project;

    /**
     * 必须要有的属性
     */
    @Parameter(required = true)
    private String name;

    /**
     * 非必须的属性
     */
    @Parameter
    private Integer age;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        Log log = getLog();
        log.info(">>> 执行了 goal:annotation 的 execute 方法");
        log.info(">>> packaging = " + project.getPackaging());
        log.info(">>> FinalName = " + project.getBuild().getFinalName());
        log.info(">>> name = " + name);
        log.info(">>> age = " + age);
    }
}
