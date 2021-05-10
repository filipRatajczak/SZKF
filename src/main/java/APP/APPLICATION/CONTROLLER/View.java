package APP.APPLICATION.CONTROLLER;


import APP.APPLICATION.REPOSITORY.EmployeeRepository;
import APP.APPLICATION.SECURITY.UsernameAuth;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class View {

    private final EmployeeRepository employeeRepository;

    public View(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/employee")
    public String employee() {
        return "employee.html";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin.html";
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @GetMapping("/tickets")
    public String tickets() {
        return "ticket.html";
    }



}
