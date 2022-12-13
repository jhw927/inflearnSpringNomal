package com.example.demo.discount;

import com.example.demo.member.Grade;
import com.example.demo.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인")
    void vip_o() {
        // given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        // when
        int discount = discountPolicy.discount(member, 10000);

        // then
        Assertions.assertThat(discount).isEqualTo(1000);

    }

    @Test
    @DisplayName("VIP가 아닌 경우")
    void vip_x(){
        Member member = new Member(1L, "memberBASIC", Grade.BASIC);

        int discount = discountPolicy.discount(member,10000);

        Assertions.assertThat(discount).isEqualTo(0);
    }

}