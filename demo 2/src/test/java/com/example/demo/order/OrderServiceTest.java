package com.example.demo.order;

import com.example.demo.AppConfig;
import com.example.demo.member.Grade;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        appConfig.memberService();
        appConfig.orderService();
    }
    @Test
    void 주문하기(){
        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(), "itemA",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
