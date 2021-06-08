package APP.APPLICATION.POJOS;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;



@Getter
@Setter
@ToString
public class ChartPojo {

    private LocalDate date;
    private BigDecimal price;

    public ChartPojo(LocalDate date, BigDecimal price) {
        this.date = date;
        this.price = price;
    }
}
