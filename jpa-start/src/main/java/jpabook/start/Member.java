package jpabook.start;

import javax.persistence.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="MEMBER", uniqueConstraints = {@UniqueConstraint( // 추가
        name = "NAME_AGE_UNIQUE",
        columnNames = {"NAME", "AGE"} )})
public class Member {
    @Id @GeneratedValue
    @Column(name = "ID")
    private String id; // 아이디

    // 역방향
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<Order>();

    @Column(name = "NAME", nullable = false, length = 10) // 추가
    private String username; // 이름

    //@ManyToMany
    //@JoinTable(name = "MEMBER_PRODUCT", joinColumns = @JoinColumn(name = "MEMBER_ID"),
    //        inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    //private List<Product> products = new ArrayList<Product>();

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    // 연관관계 매핑
    @ManyToOne
    @JoinColumn(name="TEAM_ID", insertable = false, updatable = false)
    private Team team;

    // 연관관계 설정
    public void setTeam(Team team) {
        // 기존 팀과 관계를 제거
        if(this.team != null) {
            this.team.getMembers().remove(this);
        }

        this.team = team;
        team.getMembers().add(this);
    }

    // 매핑 정보가 없는 필드
    private Integer age; // 나이

    //== 추가 ==
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    // Getter, Setter
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}