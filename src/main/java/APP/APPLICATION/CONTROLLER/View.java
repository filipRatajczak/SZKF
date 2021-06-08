package APP.APPLICATION.CONTROLLER;


import APP.APPLICATION.REPOSITORY.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class View {

    public View() {
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


}
