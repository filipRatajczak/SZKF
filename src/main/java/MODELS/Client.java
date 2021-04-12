package MODELS;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Getter @Setter
    private String firstName;
    @Getter @Setter
    private String secondName;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String birthday;
    @Getter @Setter
    private BigDecimal wallet;
    @Getter @Setter
    private LocalDate subscriptionValidity;
    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;
    @OneToMany(mappedBy = "client")
    private List<Payment> paymentList;



}
