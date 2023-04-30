package com.backend.core.util.masking

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component

@Aspect
@Component
class MarkerColumnAspect {

    @Pointcut("@annotation(com.backend.core.util.masking.MarkerConvert)")
    fun columnAnnotationPointcut() {
    }

    @Around("columnAnnotationPointcut()")
    fun process(joinPoint: ProceedingJoinPoint): Any? {
        println()
        return joinPoint.proceed()
    }
}
