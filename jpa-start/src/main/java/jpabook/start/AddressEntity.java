package jpabook.start;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AddressEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded Address address;
}
