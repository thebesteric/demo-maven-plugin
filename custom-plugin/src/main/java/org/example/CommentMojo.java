package org.example;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;

/**
 * CommentMojo
 *
 * @goal comment
 * @author wangweijun
 * @version v1.0
 * @since 2023-12-08 17:39:19
 *
 * mojo: maven old java object，每一个 mojo 类，都是 maven plugin 的一个执行目标（goal）
 * 使用 @goal 来设置插件的名字
 * 注意：注释的方式不能和注解的方式混用，文档注释也不能写在 @goal 注释下面
 */
public class CommentMojo extends AbstractMojo {

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        Log log = getLog();
        log.info(">>> 执行了 goal:comment 的 execute 方法");
    }
}
