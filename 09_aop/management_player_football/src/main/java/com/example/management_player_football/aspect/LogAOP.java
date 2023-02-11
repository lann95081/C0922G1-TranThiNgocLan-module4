package com.example.management_player_football.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAOP {

    @Pointcut("within(com.example.management_player_football.controller.PlayerController*)")
    public void allMethod(){
    }

    public void afterAllMethod(JoinPoint joinPoint){
        System.out.println("");
    }


}
