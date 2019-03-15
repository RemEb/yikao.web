package com.lcy.yikao.web.Util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 进行m5加密
 *
 * @author Lcy
 * @date 2019/1/26 20:16
 */
public class m5Password {
    public static String encrypt(String pwd, String slat) {
        String md5Hex = DigestUtils.md5Hex(pwd + slat).toUpperCase();
        return md5Hex;
    }
}
