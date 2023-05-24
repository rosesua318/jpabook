package jpabook.start;

import javax.persistence.*;

@Entity
//@IdClass(GrandChildId.class)
public class GrandChild {
    //@Id
    //@MapsId("childId") // GrandChildId.childID 매핑
    @ManyToOne
    //@JoinColumns({
    //        @JoinColumn(name = "PARENT_ID"),
    //        @JoinColumn(name = "CHILD_ID")
    //})
    @JoinColumn(name = "CHILD_ID")
    private Child child;

    //@Id @Column(name = "GRANDCHILD_ID")
    //@EmbeddedId
    //private GrandChildId id;
    @Id @GeneratedValue
    @Column(name = "GRANDCHILD_ID")
    private Long id;

    private String name;
}
