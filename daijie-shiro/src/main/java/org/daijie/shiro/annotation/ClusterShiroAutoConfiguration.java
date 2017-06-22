package org.daijie.shiro.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.daijie.shiro.configure.ClusterShiroConfigure;
import org.springframework.context.annotation.Import;

/**
 * 此注解实现了集群shiro redis
 * 注解集成了spring boot，在任何被扫描类加上此注册即可使用
 * @author daijie
 * @date 2017年6月22日
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ClusterShiroConfigure.class)
public @interface ClusterShiroAutoConfiguration {

}
