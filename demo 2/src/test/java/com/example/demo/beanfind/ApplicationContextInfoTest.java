package com.example.demo.beanfind;

import com.example.demo.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {
    //AnnotationConfigApplicationContext  자바 어노테이션을 이용한 클래스로부터 객체 설정 정보를 가져온다.
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
 
    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + "object = " + bean);

        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기") // 내가 등록한 빈을 출력
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            //BeanDefinition bean 하나하나에 대한 메타데이터 정보
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            // Role ROLE_APPLICATION 직접 등록한 애플리케이션 빈
            // Role ROLE_INFRASTRUCTURE 스프링이 내부에서 사용하는 본
            if(beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + "object = " + bean);

            }
        }
    }
}
