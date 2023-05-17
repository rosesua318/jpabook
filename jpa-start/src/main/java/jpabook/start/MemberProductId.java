package jpabook.start;

import java.io.Serializable;

public class MemberProductId implements Serializable {
    private String member; // MemberProduct.member와 연결
    private String product; // MemberProduct.product와 연결

    // hashCode and equals

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}