package APP.APPLICATION.POJOS;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class ClientPojo {

    private String firstName;
    private String secondName;
    private String email;
    private String birthday;
    private BigDecimal wallet;
    private LocalDate subscriptionValidity;
    private int trainerID;

}
