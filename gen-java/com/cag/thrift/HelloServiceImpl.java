package com.cag.thrift;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;

public class HelloServiceImpl implements com.cag.thrift.HelloService.Iface {
//    @Override
    public String doAction(com.cag.thrift.Request request) throws RequestException {
        System.out.println("Get request:" + request);
        if (StringUtils.isBlank(request.getName()) || request.getType() == null) {
            throw new com.cag.thrift.RequestException();
        }
        String result = "hello," + request.getName();
        if (request.getType() == RequestType.SAY_HELLO) {
            result += ", welcome";
        } else {
            result += ", now is " + new Date().toString();
        }
        return result;
    }

}