package APP.APPLICATION.POJOS;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
public class TicketPojo {

    String name;
    BigDecimal price;
    int periodOfValidity;

}
