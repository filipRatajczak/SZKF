package MODELS;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GymEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    int id;
    @Getter @Setter
    String name;
    @Getter @Setter
    int numberOfItems;
    @Getter @Setter
    int availability;

}
