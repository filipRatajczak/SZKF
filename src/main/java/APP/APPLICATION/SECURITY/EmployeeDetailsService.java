package APP.APPLICATION.SECURITY;

import APP.APPLICATION.MODELS.Employee;
import APP.APPLICATION.REPOSITORY.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeDetailsService implements UserDetailsService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> employee = employeeRepository.findByName(username);

        employee.orElseThrow(() -> new UsernameNotFoundException("Not found" +  username));


        return employee.map(EmployeesDetails::new).get();
    }
}
