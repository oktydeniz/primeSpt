package com.facility.primeSport.demo;

import com.facility.primeSport.util.CommonUtil;
import jakarta.servlet.http.HttpSession;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;

@Aspect
public class DemoAspect {

    @Around("@annotation(com.facility.primeSport.demo.Demo) && execution (* *.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable{
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();
        Demo annotation = method.getAnnotation(Demo.class);
        Object[] args = point.getArgs();

        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes servletRequestAttributes){
            HttpSession session = servletRequestAttributes.getRequest().getSession();
            Boolean demo = null;
            if(session != null){
                demo = (Boolean) session.getAttribute("demo");
                if (demo == null){
                    demo = (Boolean) session.getAttribute("forceDome");
                }
            }
            if (CommonUtil.isTrue(demo)){
                return point.proceed();
            }
        }else {
            return point.proceed();
        }
        String name = annotation.value();
        switch (name){
            case "one":{
                return "deneme Calisti";

            }
            default:
                return point.proceed();
        }
    }
}
