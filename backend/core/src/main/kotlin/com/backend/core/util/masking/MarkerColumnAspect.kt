package com.backend.core.util.masking

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component

@Aspect
@Component
class MarkerColumnAspect {

    @Pointcut("@annotation(com.backend.core.masking.MarkerConvert)")
    fun columnAnnotationPointcut() {
    }

    @AfterReturning(
        value = "columnAnnotationPointcut()",
        returning = "result"
    )
    fun process(joinPoint: JoinPoint, result: Any?) {
        println()
    }
}
