package APP.APPLICATION.MODELS;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String productName;
    private BigDecimal price;
    @JsonIgnore
    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Payments> payments;
}
