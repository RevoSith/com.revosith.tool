package com.revosith.tool.util;

/**
 * Desc :
 * Author: 左轮(haiyong.he@luckincoffee.com)
 * Date : 2019/6/10
 */
public class StringUtils {

    public static boolean isBlank(CharSequence var0) {
        int var1;
        if (var0 != null && (var1 = var0.length()) != 0) {
            for(int var2 = 0; var2 < var1; ++var2) {
                if (!Character.isWhitespace(var0.charAt(var2))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }
}
