package com.cenozoic.number.annotation;

import java.lang.annotation.*;

/**
 * <p>
 *
 * @author xucaifeng
 * @since 2020-12-27
 **/
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelColumn {

    /**
     * Excel标题
     *
     * @return
     */
    String value() default "";

    /**
     * Excel从左往右排列位置
     *
     * @return
     */
    int col() default 0;

}
