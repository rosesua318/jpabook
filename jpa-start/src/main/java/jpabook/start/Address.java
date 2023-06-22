package jpabook.start;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Address {
    //@Column(name = "city") // 매핑할 컬럼 정의 가능
    String city;
    String street;
    //String state;
    //@Embedded Zipcode zipcode; // 임베디드 타입 포함
    private String zipcode;

    protected Address() {} // JPA에서 기본 생성자는 필수다.

    // 생성자로 초기 값을 설정한다.
    public Address(String city) {
        this.city = city;
    }

    // 접근자(Getter)는 노출한다.
    public String getCity() {
        return city;
    }

    // 수정자(Setter)는 만들지 않는다.
}
