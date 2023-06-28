package jpabook.start;

import javax.persistence.*;
import java.sql.Array;
import java.util.*;

@Entity
@Table(name="MEMBER", uniqueConstraints = {@UniqueConstraint( // 추가
        name = "NAME_AGE_UNIQUE",
        columnNames = {"NAME", "AGE"} )})
@NamedQueries({
        @NamedQuery(name = "Member.findByUsername", query = "select m from Member m where m.username = :username"),
        @NamedQuery(name = "Member.count", query = "select count(m) from Member m")
})
public class Member {
    @Id @GeneratedValue
    @Column(name = "ID")
    private String id; // 아이디

    // 역방향
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<Order>(); // 연관 필드(컬렉션 값 연관 필드)

    @Column(name = "NAME", nullable = false, length = 10) // 추가
    private String username; // 상태 필드

    //@ManyToMany
    //@JoinTable(name = "MEMBER_PRODUCT", joinColumns = @JoinColumn(name = "MEMBER_ID"),
    //        inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    //private List<Product> products = new ArrayList<Product>();

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    // 연관관계 매핑
    @ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name="TEAM_ID", insertable = false, updatable = false)
    private Team team; // 연관 필드(단일 값 연관 필드)

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
    private Integer age; // 상태 필드

    // 근무 기간
    //@Temporal(TemporalType.DATE)
    //java.util.Date startDate;
    //@Temporal(TemporalType.DATE)
    //java.util.Date endDate;

    // 집 주소 표현
    //private String city;
    //private String street;
    //private String zipcode;

    @Embedded Period workPeriod; // 근무 기간

    //@Embedded Address Address; // 임베디드 타입 포함
    @Embedded PhoneNumber phoneNumber; // 임베디드 타입 포함

    @Embedded
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOODS", joinColumns = @JoinColumn(name = "MEMBER_ID"))
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<String>();

    //@ElementCollection
    //@CollectionTable(name = "ADDRESS", joinColumns = @JoinColumn(name = "MEMBER_ID"))
    //private List<Address> addressHistory = new ArrayList<Address>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressEntity> addressHistory = new ArrayList<>();

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