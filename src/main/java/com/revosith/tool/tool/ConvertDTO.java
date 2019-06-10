package com.revosith.tool.tool;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * Desc :
 * Author: 左轮(haiyong.he@luckincoffee.com)
 * Date : 2019/6/6
 */
public class ConvertDTO implements Serializable {

    private static final long serialVersionUID = -2796807398718315645L;
    private Field targetField;
    private Field sourceField;
    private ConvertTool convertTool;
    private String param;

    public ConvertDTO(Field targetField, Field sourceField, ConvertTool convertTool, String param) {
        this.targetField = targetField;
        this.sourceField = sourceField;
        this.convertTool = convertTool;
        this.param = param;
    }

    public Field getTargetField() {
        return targetField;
    }

    public Field getSourceField() {
        return sourceField;
    }

    public ConvertTool getConvertTool() {
        return convertTool;
    }

    public String getParam() {
        return param;
    }
}
