package com.revosith.tool.tool.impl;

import com.revosith.tool.tool.ConvertTool;
import com.revosith.tool.util.CopyUtils;

/**
 * Desc :
 * Author: 左轮(haiyong.he@luckincoffee.com)
 * Date : 2019/6/10
 */
public class SimpleConvertTool implements ConvertTool {


    @Override
    public Object convert(Class target, Object souceData, String param) {
        return CopyUtils.copySigle(target, souceData);
    }
}
