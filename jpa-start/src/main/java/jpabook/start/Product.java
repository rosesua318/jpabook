package jpabook.start;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Product {
    @Id @Column(name = "PRODUCT_ID")
    private String id;

    //@ManyToMany(mappedBy = "products") // 역방향 추가
    //private List<Member> members;

    private String name;
}
