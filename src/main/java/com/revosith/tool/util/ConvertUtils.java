package com.revosith.tool.util;

import com.revosith.tool.annotation.CopyConvert;
import com.revosith.tool.tool.ConvertDTO;
import com.revosith.tool.tool.ConvertTool;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Desc :
 * Author: 左轮(haiyong.he@luckincoffee.com)
 * Date : 2019/6/6
 */
public class ConvertUtils {

    public static <T, S> void convert(T target, S source) {

        List<ConvertDTO> convertDTOS = getConvertDTOList(target.getClass(), source.getClass());

        for (ConvertDTO convertDTO : convertDTOS) {
            ConvertTool convertTool = convertDTO.getConvertTool();
            Field targetField = convertDTO.getTargetField();
            Field sourceField = convertDTO.getSourceField();

            targetField.setAccessible(true);
            sourceField.setAccessible(true);
            try {
                targetField.set(target, convertTool.convert(targetField.getType(), sourceField.get(source), convertDTO.getParam()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static <T, S> List<ConvertDTO> getConvertDTOList(Class<T> targetClazz, Class<S> sourceClass) {

        String name = targetClazz.getName() + sourceClass.getName();

        List<ConvertDTO> list = convertDTOMap.get(name);

        if (list == null) {
            list = initConvertDTOList(targetClazz, sourceClass);
            convertDTOMap.put(name, list);
        }
        return list;
    }

    private static Map<String, List<ConvertDTO>> convertDTOMap = new HashMap<>(10);

    private static Map<String, ConvertTool> convertToolMap = new HashMap<>(10);

    private static <T, S> List<ConvertDTO> initConvertDTOList(Class<T> targetClazz, Class<S> sourceClass) {

        Field[] fields = targetClazz.getDeclaredFields();
        List<ConvertDTO> convertDTOS = new ArrayList<>(2);

        for (Field field : fields) {
            CopyConvert copyConvert = field.getAnnotation(CopyConvert.class);

            if (copyConvert == null) {
                continue;
            }
            try {
                Field sourceField = sourceClass.getDeclaredField(field.getName());
                convertDTOS.add(new ConvertDTO(field, sourceField, getConvertTool(copyConvert.convertClass(), copyConvert.param()), copyConvert.param()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return convertDTOS;
    }

    private static ConvertTool getConvertTool(String clazzName, String param) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        ConvertTool convertTool = convertToolMap.get(clazzName + param);
        Class clazz = Class.forName(clazzName);

        if (convertTool == null) {
            convertTool = (ConvertTool) clazz.newInstance();
            convertToolMap.put(clazzName, convertTool);
        }
        return convertTool;
    }
}
