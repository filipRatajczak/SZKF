package APP.APPLICATION.POJOS;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
public class EntrancesPojo {

    int id;
    LocalDate enter;
    LocalDate leave;
    Long clientId;

}
