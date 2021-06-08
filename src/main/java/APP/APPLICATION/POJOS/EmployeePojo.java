package APP.APPLICATION.POJOS;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmployeePojo {

    private long id;
    private String name;
    private String pass;
    private String role;

}
