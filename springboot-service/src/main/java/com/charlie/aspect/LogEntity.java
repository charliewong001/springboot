package com.charlie.aspect;

import java.util.HashMap;
import java.util.Map;

public class LogEntity {
    private Class<?> targetClass;
    private String[] paramNames;
    private Object[] paramValues;
    private String methodName;
    private Map<String, Object> params;

    public LogEntity(Class<?> targetClass, String[] paramNames,
            Object[] paramValues, String methodName) {
        this.targetClass = targetClass;
        this.paramNames = paramNames;
        this.paramValues = paramValues;
        this.methodName = methodName;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class<?> targetClass) {
        this.targetClass = targetClass;
    }

    public String[] getParamNames() {
        return paramNames;
    }

    public void setParamNames(String[] paramNames) {
        this.paramNames = paramNames;
    }

    public Object[] getParamValues() {
        return paramValues;
    }

    public void setParamValues(Object[] paramValues) {
        this.paramValues = paramValues;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Map<String, Object> getParams() {
        if (params == null) {
            params = new HashMap<String, Object>();
            if (paramValues != null && paramValues.length > 0
                    && paramNames != null && paramNames.length > 0) {
                params = new HashMap<String, Object>();
                for (int i = 0; i < paramValues.length; i++) {
                    params.put(paramNames[i], paramValues[i]);
                }
            }
        }
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

}
