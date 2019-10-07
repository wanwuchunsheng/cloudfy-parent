package cn.cloudfy.common.annotation;

import cn.cloudfy.common.pojo.Logical;

import java.lang.annotation.*;

/**
 * 自定义注解，权限注解。
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresPermissions {


    /**
     * 权限的名称
     * @return
     */
    String[] value();


    /**
     * 在指定多个角色时进行权限检查的逻辑操作。AND是默认值
     * @return
     */
    Logical logical() default Logical.AND;

}