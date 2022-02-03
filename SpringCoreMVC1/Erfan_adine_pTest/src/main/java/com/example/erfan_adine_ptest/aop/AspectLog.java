package com.example.erfan_adine_ptest.aop;


import ch.qos.logback.classic.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


import java.util.Arrays;
import java.util.stream.Collectors;

//@RestController
@Component
@Aspect
@Profile("test")
public class AspectLog {




    Logger logger = (Logger) LoggerFactory.getLogger(AspectLog.class);

    @Around("execution(* com.example.erfan_adine_p1.service.*.*(..) ) || " +
            "execution(* com.example.erfan_adine_p1.entity.*.*(..)) || " +
            "execution(* com.example.erfan_adine_p1.repository.*.*(..) ) )")
    public void logServicePackage(ProceedingJoinPoint jp )  {
        String params = Arrays.stream(jp.getArgs()).map(Object::toString).collect( Collectors.joining( "," ) );
        logger.info("Before method: " +jp.getSignature().getDeclaringTypeName()+"." + jp.getSignature().getName()+"("+ params+")");
        Object proceed=null;
        try {
            proceed = jp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        logger.debug("After method: "+jp.getSignature().getDeclaringTypeName()+"."+ jp.getSignature().getName() +":"+ proceed);
    }


//lsjflsjfls
//    @Around("execution(* com.Erfan.*.sendEmail(..))")
//    public void userAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
//        Object[] args = joinPoint.getArgs();
//        for (Object arg:args){
//            System.out.println(arg);
//        }
//        StopWatch watch = new StopWatch();
//        watch.start();
//        joinPoint.proceed();
//        watch.stop();
//        System.out.println("@Around: csll took_"+watch.getTotalTimeMillis()+"ms");
//
//    }
//
//    @Before("@annotation(com.Erfan.Logging) *")
//    public void check(){
//        System.out.println("hello0000000000000000");
//    }

    //////////////////////////////////////////////////////////////////
//
//    private final Logger log = LoggerFactory.getLogger(this.getClass());
//
//    @Pointcut("within(@org.springframework.stereotype.Service *)")
//    public void springBeanPointcut() {
//        // Method is empty as this is just a Pointcut, the implementations are in the advices.
//    }
//
//
//    @Around("springBeanPointcut()")
//    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        Object[] args = joinPoint.getArgs();
//        log.info("Params: ");
//        for(Object arg : args) {
//            log.info(arg.toString());
//        }
//        Object result = joinPoint.proceed();
//        Object target = joinPoint.getTarget();
//        log.debug("Return value: "+target.toString());
//        return result;
//    }
//
//
//
//
//
//    static Logger logger = Logger.getLogger("com.example.erfan_adine_p1");
//
////    @GetMapping
//    @Around("execution(* com.example.erfan_adine_p1.*.*(..))")
//    public void userAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
//        FileHandler fileHandler = new FileHandler();
//        logger.addHandler(fileHandler);
//
//
//        System.out.println("parametr's :");
//        Object[] args = joinPoint.getArgs();
//        for (Object arg : args) {
//            System.out.println(arg);
//        }
//        System.out.println("--");
//        StopWatch watch = new StopWatch();
//        watch.start();
//        joinPoint.proceed();
//        watch.stop();
//        System.out.println("@Around: csll took_" + watch.getTotalTimeMillis() + "ms");
//
//    }


}
