package com.revosith.tool.tool.impl;

import com.revosith.tool.tool.ConvertTool;

import java.util.Date;

/**
 * Desc :
 * Author: 左轮(haiyong.he@luckincoffee.com)
 * Date : 2019/6/6
 */

public class DefaultConvertTool implements ConvertTool<String, Date> {


    @Override
    public String convert(Class<String> target, Date date, String param) {
        return param;
    }
}
