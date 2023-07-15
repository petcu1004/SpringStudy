package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount = 1000; //1000원 할인

    //VIP면 1000원 할인, 아니면 할인 없음
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){ //enum타입이면 == 쓰는게 맞음
            return discountFixAmount;
        }else{
            return 0;
        }

    }
}
