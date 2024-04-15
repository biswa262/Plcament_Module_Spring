package com.example.placementmodule;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExceptionFound extends RuntimeException{
    private String resouseName;        //table to be searched
    private String fieldname;     // searched through column name
    private Object fieldvalue;
    public ExceptionFound(String resouseName, String fieldname, Object fieldvalue){
        super(String.format("IN %s TABLE, For %s:%s ,DATA NOT FOUND ",resouseName,fieldname,fieldvalue));
        this.resouseName = resouseName;
        this.fieldname = fieldname;
        this.fieldvalue = fieldvalue;
    }

    public String getResouseName() {
        return resouseName;
    }

    public void setResouseName(String resouseName) {
        this.resouseName = resouseName;
    }

    public String getFieldname() {
        return fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }

    public Object getFieldvalue() {
        return fieldvalue;
    }

    public void setFieldvalue(Object fieldvalue) {
        this.fieldvalue = fieldvalue;
    }
}
