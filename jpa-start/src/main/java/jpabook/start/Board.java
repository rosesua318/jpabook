package jpabook.start;

import javax.persistence.*;

@Entity
@Table(name = "BOARD")
@SecondaryTable(name = "BOARD_DETAIL", pkJoinColumns = @PrimaryKeyJoinColumn(name = "BOARD_DETAIL_ID"))
public class Board {
    @Id @GeneratedValue
    @Column(name = "BOARD_ID")
    private Long id;

    private String title;

    //@OneToOne(mappedBy = "board")
    //private BoardDetail boardDetail;

    @Column(table = "BOARD_DETAIL")
    private String content;
}
