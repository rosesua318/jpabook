package jpabook.start;

import javax.persistence.*;

@Entity
//@IdClass(ParentId.class)
public class Parent {
    //@Id
    //@Column(name = "PARENT_ID1")
    //private String id1; // ParentId.id1과 연결

    //@Id
    //@Column(name = "PARENT_ID2")
    //private String id2; // ParentId.id2와 연결

    //@EmbeddedId
    //@Id @Column(name = "PARENT_ID")
    @Id @GeneratedValue
    @Column(name = "PARENT_ID")
    private ParentId id;
    private String name;
}
