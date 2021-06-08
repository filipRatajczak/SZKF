package APP.APPLICATION.CONTROLLER;


import APP.APPLICATION.MODELS.Employee;
import APP.APPLICATION.POJOS.EmployeePojo;
import APP.APPLICATION.REPOSITORY.EmployeeRepository;
import APP.APPLICATION.SERVICES.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "/admin/employee/create")
    public void createEmployee(@RequestBody EmployeePojo employeePojo) {
        employeeService.createEmployee(employeePojo);
    }

    @GetMapping(value = "/admin/employee/getAll")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping(value = "/admin/employee/{id}/delete")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping(value = "/admin/employee/{id}/edit")
    public void editEmployee(@PathVariable Long id, @RequestBody EmployeePojo employeePojo) {
        employeeService.editEmployee(id, employeePojo);
    }

}
