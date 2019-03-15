package com.lcy.yikao.web.Util;

import java.util.UUID;

/**
 * 生成随机数
 *
 * @author Lcy
 * @date 2019/1/23 21:20
 */
public class IDUtil {
    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
