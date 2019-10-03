package com.qf.sc.manage.service.MyAspect;

import common.AppException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import result.AppResult;

@Component
@Aspect
public class Resultaop {
    public AppResult arounInvoke(ProceedingJoinPoint jp) {
        System.out.println("进入了自己的切面");
        AppResult result = new AppResult();
        try {
            result = (AppResult) jp.proceed();
        } catch (Throwable ex) {
            if (ex instanceof AppException) {
                BeanUtils.copyProperties(ex, result);
                result.setSuccess(false);
            } else {
                result = new AppResult(false, 500, "系统错误", null);
            }
        }
        return  result;
    }
}
