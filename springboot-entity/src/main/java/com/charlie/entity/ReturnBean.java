package com.charlie.entity;

import java.io.Serializable;

public class ReturnBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ReturnBean [code=" + code + ", msg=" + msg + "]";
    }

}
