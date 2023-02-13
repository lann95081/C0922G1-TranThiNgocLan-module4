package com.example.management_player_football.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAOP {

    @Pointcut("execution(* com.example.management_player_football.controller.PlayerController.update(..))")
    public void allMethod() {
    }

    @After("allMethod()")
    public void afterAllMethod() {
        System.out.println("Trạng thái của cầu thủ đã bị chuyển đổi.");
    }

//    @Pointcut("execution(* com.example.management_player_football.controller.PlayerController.update(..))&&args(playerDto,*,*,*)")
//    public void getAllUpdate(PlayerDto playerDto) {
//    }
//
//    @After(value = "getAllUpdate(playerDto)", argNames = "playerDto")
//    public void printUpdate(PlayerDto playerDto) {
//        System.out.println("Trạng thái của cầu thủ" +playerDto.getName()+ "đã bị chuyển thành " + (!playerDto.isStatus()));
//    }
}
