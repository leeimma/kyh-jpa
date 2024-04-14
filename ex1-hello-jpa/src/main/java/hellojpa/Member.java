package hellojpa;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
//@Table(name = "MBR")
//@Table(uniqueConstraints = "")
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SEQ",
        initialValue = 1, allocationSize = 1
)
public class Member {

    @Id
    @GeneratedValue()
    private String id;

    @Column(name = "USERNAME")
    private String username;
//    @Column(name = "TEAM_ID")
//    private Long teamId;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

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

    public Team getTeam() {
        return team;
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Column(name = "name", nullable = false/*, columnDefinition = "varchar(100) default 'empty'"*/)
//    private String username;
//
//    private Integer age;
//
////    private BigDecimal age;
//
//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;
//
//    // enum 의 종류: ordinal / string
//    // ordinal : 순서를 데이터베이스에 저장
//    // string : 이름을 데이터베이스에 저장
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//
//    private LocalDate createDate2;
//    private LocalDateTime createDateTime;
//
//    @Lob
//    private String description;
//
//    @Transient
//    private int temp;
//
//    public Member() {
//    }
//
//    public Member(Long id, String username) {
//        this.id = id;
//        this.username = username;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return username;
//    }
//
//    public void setName(String username) {
//        this.username = username;
//    }
}
