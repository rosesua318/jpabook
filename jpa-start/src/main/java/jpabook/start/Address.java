package jpabook.start;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Address {
    //@Column(name = "city") // 매핑할 컬럼 정의 가능
    String city;
    String street;
    String state;
    @Embedded Zipcode zipcode; // 임베디드 타입 포함
}
