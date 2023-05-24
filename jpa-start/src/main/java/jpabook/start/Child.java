package jpabook.start;

import javax.persistence.*;

@Entity
//@IdClass(ChildId.class)
public class Child {
    //@Id
    //private String id;

    //@Id
    //@ManyToOne
    //@JoinColumns({
    //      @JoinColumn(name = "PARENT_ID1", referencedColumnName = "PARENT_ID1"),
    //    @JoinColumn(name = "PARENT_ID2", referencedColumnName = "PARENT_ID2")
    //})
    //@JoinColumn(name = "PARENT_ID")
    //@MapsId("parentId") // ChildId.parentId 매핑
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Parent parent;

    //@Id @Column(name = "CHILD_ID")
    //@EmbeddedId
    //private String childId;
    @Id @GeneratedValue
    @Column(name = "CHILD_ID")
    private Long id;

    private String name;
}
