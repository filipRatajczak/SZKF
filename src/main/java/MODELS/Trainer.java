package MODELS;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    long id;
    @Getter @Setter
    String firstName;
    @Getter @Setter
    String secondName;
    @Getter @Setter
    String description;
    @OneToMany(mappedBy = "trainer")
    private List<Client> clientList;
}
