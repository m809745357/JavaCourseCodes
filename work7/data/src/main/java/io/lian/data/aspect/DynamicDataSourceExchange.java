package io.lian.data.aspect;

import io.lian.data.aop.WatchDog;
import io.lian.data.handler.DynamicDataSourceHandler;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author m809745357
 */
@Aspect
@Component
public class DynamicDataSourceExchange {

    @Pointcut("@annotation(io.lian.data.aop.WatchDog)")
    public void dynamicDataSource() {

    }

    @Around("dynamicDataSource()")
    public Object beforeMethod(ProceedingJoinPoint pjp) throws Throwable {

        Class<?> aClass = pjp.getTarget().getClass();
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Class<?>[] parameterTypes = signature.getMethod().getParameterTypes();
        if (aClass.isAnnotationPresent(WatchDog.class)) {
            WatchDog watchDog = aClass.getAnnotation(WatchDog.class);
            DynamicDataSourceHandler.setRouteKey(watchDog.value());
        }

        Method method = aClass.getMethod(signature.getMethod().getName(), parameterTypes);
        if (method.isAnnotationPresent(WatchDog.class)) {
            WatchDog watchDog = method.getAnnotation(WatchDog.class);
            DynamicDataSourceHandler.setRouteKey(watchDog.value());
        }

        return pjp.proceed();
    }

}
