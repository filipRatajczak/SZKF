package APP.APPLICATION.SERVICES;

import APP.APPLICATION.MODELS.Employee;
import APP.APPLICATION.POJOS.EmployeePojo;
import APP.APPLICATION.REPOSITORY.EmployeeRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    public EmployeeService(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional()
    public void createEmployee(@RequestBody EmployeePojo employeePojo) {
        Employee employee = new Employee();
        employee.setName(employeePojo.getName());
        employee.setRole(employeePojo.getRole());
        employee.setPass(passwordEncoder.encode(employeePojo.getPass()));
        employeeRepository.save(employee);
    }

    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Transactional
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Transactional
    public void editEmployee(Long id, EmployeePojo employeePojo) {
        Optional<Employee> employee = employeeRepository.findById(id);
        employee.ifPresent(e -> {
            e.setName(employeePojo.getName());
            e.setRole(employeePojo.getRole());
            e.setPass(passwordEncoder.encode(e.getPass()));
        });
    }


}
