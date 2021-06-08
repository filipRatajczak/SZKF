package APP.APPLICATION.MODELS;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String secondName;
    private String email;
    private String birthday;
    private BigDecimal wallet;
    private LocalDate subscriptionValidity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;
    @JsonIgnore
    @OneToMany(mappedBy = "client", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Payments> payments;
    @JsonIgnore
    @OneToMany(mappedBy = "client", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Entrances> entrances;


    public void addEntrance(Entrances entrance) {
        this.entrances.add(entrance);
        entrance.setClient(this);

    }

    public void addPayment(Payments payments) {
        this.payments.add(payments);
        payments.setClient(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, email, birthday, wallet, subscriptionValidity, trainer, payments, entrances);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", birthday='" + birthday + '\'' +
                ", wallet=" + wallet +
                ", subscriptionValidity=" + subscriptionValidity +
                '}';
    }
}
