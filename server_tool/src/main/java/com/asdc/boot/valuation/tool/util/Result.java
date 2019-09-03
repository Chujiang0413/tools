package com.asdc.boot.valuation.tool.util;

import lombok.Data;
import javax.persistence.Enumerated;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    private static final long serialVersionUID = -5187599213345479920L;
    private String msg;
    private Object data;
    @Enumerated
    private ResultStatus status;

    public enum ResultStatus{
        ERROR,SUCCESS,NOTLOGIN,VALIDATE_ERROR
    }

    public static Result handleSuccess(){
        return handleResult(ResultStatus.SUCCESS,null,null);
    }
    public static Result handleSuccess(Object data){
        return handleResult(ResultStatus.SUCCESS,null,data);
    }
    public static Result handleSuccess(String msg){
        return handleResult(ResultStatus.SUCCESS,msg,null);
    }
    public static Result handleSuccess(String msg,Object data){
        return handleResult(ResultStatus.SUCCESS,msg,data);
    }

    public static Result handleError(){
        return handleResult(ResultStatus.ERROR,null,null);
    }
    public static Result handleError(Object data){
        return handleResult(ResultStatus.ERROR,null,data);
    }
    public static Result handleError(String msg){
        return handleResult(ResultStatus.ERROR,msg,null);
    }
    public static Result handleError(String msg,Object data){
        return handleResult(ResultStatus.ERROR,msg,data);
    }

    public static Result handleNotLogin(String msg,Object data){
        return handleResult(ResultStatus.NOTLOGIN,msg,data);
    }

    public static Result handleException(ResultStatus status,String msg){
        return handleResult(status,msg,null);
    }
    public static Result handleException(ResultStatus status,Object data){
        return handleResult(status,"表单验证错误",data);
    }    public static Result handleException(ResultStatus status,String msg,Object data){
        return handleResult(status,msg,data);
    }

    private static Result handleResult(ResultStatus status,String msg,Object data){
        Result result = new Result();
        result.setData(data);
        result.setStatus(status);
        result.setMsg(msg);
        return result;
    }

}
