package hellojpa;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member extends BaseEntity{

    @Id
    @GeneratedValue()
    private String id;

    @Column(name = "USERNAME")
    private String username;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;



}
