package jpabook.start;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Embeddable
public class Period {
    @Temporal(TemporalType.DATE)
    java.util.Date startDate;
    @Temporal(TemporalType.DATE)
    java.util.Date endDate;

    public boolean isWork(Date date) {
        //.. 값 타입을 위한 메소드를 정의할 수 있다.
        return true;
    }
}
