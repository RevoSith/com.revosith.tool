package com.revosith.tool.tool.impl;

import com.revosith.tool.tool.ConvertTool;
import com.revosith.tool.util.DateUtils;

import java.util.Date;

/**
 * Desc :
 * Author: 左轮(haiyong.he@luckincoffee.com)
 * Date : 2019/6/6
 */
public class DateConvertTool implements ConvertTool<String, Date> {

    @Override
    public String convert(Class<String> target, Date souceData, String param) {
        return DateUtils.format(souceData, param);
    }
}
