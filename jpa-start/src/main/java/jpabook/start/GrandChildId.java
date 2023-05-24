package jpabook.start;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class GrandChildId implements Serializable {
    //private ChildId child; // GrandChild.child 매핑
    private ChildId childId; // @MapsId("childId")로 매핑

    @Column(name = "GRANDCHILD_ID")
    private String id; // GrandChild.id 매핑

    // equals, hashCode
}

