/*******************************************************************************
 * Copyright(c) FriarTuck Pte Ltd ("FriarTuck"). All Rights Reserved.
 *
 * This software is the confidential and proprietary information of FriarTuck.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with FriarTuck.
 *
 * FriarTuck MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
 * SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR NON-
 * INFRINGEMENT. FriarTuck SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE
 * AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 ******************************************************************************/

package loi.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * This aspect will record all methods executed in chronological order and provide
 * detailed analytic at the end of a request.
 *
 * @author James Tran
 *
 */
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
