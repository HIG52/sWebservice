package com.hjy.springwebservice.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WebControllerTest {
    /*
    junit5 에서 의존성 주입을 생성자 주입으로 할경우 문제가 생기는데
    왜냐하면 주체가 Spring 이 아니라 Jupiter가 되므로 @Autowired를 명시적으로 선언해주어야
    Jupiter가 Spring Container에게 빈주입을 요청할수 있게 된다.
    스프링 프레임워크의 경우 Spring Ioc 컨테이너가 등록할 Bean들을 먼저 찾아서 보관하고 있다.
    이후 생성자 주입을 요구하는경우 적절한 Bean을 찾아 생성자 주입을 수행한다.
    테스트 프레임워크의 경우 생성자 매개변수관리를 Jupiter가 하게된다.

    그래서 생성자 주입을 요구할경우 생성자 매개변수를 처리할 ParameterResolver를 열심히 뒤져보지만 해당빈은
    스프링이가지고 있기때문에 처리하지 못한다.
    하지만 @Autowired 어노테이션을 달아 명시해주면 Jupiter가 빈 주입을 스프링 컨테이너에게 요청하게되어서 정상적으로 빈 주입을 받을수
    있게된다.
     */
    @Autowired
    private TestRestTemplate restTemplate;
    /*@Autowired
    public WebControllerTest(TestRestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }*/


    @Test
    public void mainPage_Loading(){
        //when
        String body = this.restTemplate.getForObject("/", String.class);

        //then
        //assertThat(body).contains("SpringBoot로 시작하는 웹 서비스");
    }
}