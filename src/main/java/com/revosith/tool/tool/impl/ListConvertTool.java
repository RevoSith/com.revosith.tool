package com.revosith.tool.tool.impl;

import com.revosith.tool.tool.ConvertTool;
import com.revosith.tool.util.CopyUtils;

import java.util.List;

/**
 * Desc :
 * Author: 左轮(haiyong.he@luckincoffee.com)
 * Date : 2019/6/10
 */
public class ListConvertTool implements ConvertTool<Object, List> {


    @Override
    public List convert(Class<Object> target, List souceData, String param) {
        return CopyUtils.copyMulti(target, souceData);
    }
}
