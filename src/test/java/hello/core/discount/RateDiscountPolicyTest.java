package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
//import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// static 메소드를 import static을 사용해서 클래스명 없이 바로 사용가능
// JDK1.5부터 지원하는 기능
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    //성공테스트
    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o(){
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        //Assertions.assertThat(discount).isEqualTo(1000);
        //import static을 사용하여 호출한 클래스로 클래스명을 생략할 수 있다
        assertThat(discount).isEqualTo(1000);

    }

    //실패테스트
    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    void vip_x(){
        //given
        Member member = new Member(2L, "memberVIP", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
//        Assertions.assertThat(discount).isEqualTo(1000);
        //import static을 사용하여 호출한 클래스로 클래스명을 생략할 수 있다
        assertThat(discount).isEqualTo(1000);

    }
}