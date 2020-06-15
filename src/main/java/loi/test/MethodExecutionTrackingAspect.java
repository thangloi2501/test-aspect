package loi.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodExecutionTrackingAspect {

//    @Pointcut("within(loi.tracked..*)")
//    public void trackedItems() {}

    @Pointcut("@annotation(loi.test.LogTracked)")
    public void logTracked() {}

//    @Pointcut("(trackedItems() || logTracked())")
    @Pointcut("(logTracked())")
    public void trackedMethods() {}

    @Around("trackedMethods()")
    public Object trackedMethods(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Around tracked methods!!!!! Kind: " +  pjp.getKind());

        Object proceed = pjp.proceed();

        System.out.println("Around tracked methods!!!!! Kind: " +  pjp.getKind());

        return proceed;
    }
}
