package APP.APPLICATION.POJOS;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductPojo {

    private String productName;
    private BigDecimal price;

}
