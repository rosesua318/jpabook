package jpabook.start;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ChildId implements Serializable {
    // private String parent; // Child.parent 매핑
    private String parentId; // @MapsId(parentId")로 매핑

    //private String childId; // Child.childId 매핑
    @Column(name = "CHILD_ID")
    private String id;

    // equals, hashCode
}
