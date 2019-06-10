package com.revosith.tool.tool;

/**
 * Desc :
 * Author: 左轮(haiyong.he@luckincoffee.com)
 * Date : 2019/6/6
 */
public interface ConvertTool<T, S> {
    T convert(Class<T> target, S souceData, String param);
}
