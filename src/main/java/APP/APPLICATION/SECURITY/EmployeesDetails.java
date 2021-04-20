package APP.APPLICATION.SECURITY;

import APP.APPLICATION.MODELS.Employee;
import APP.APPLICATION.REPOSITORY.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.*;
import java.util.stream.Collectors;


public class EmployeesDetails implements UserDetails {

    @Autowired
    String username;
    String password;
    List<GrantedAuthority> role;

    public EmployeesDetails(Employee employee) {
        this.username = employee.getName();
        this.password = employee.getPass();
        this.role = Arrays.stream(
                employee.getRole().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role;
    }

    @Override
    public String getPassword() {

        return password;
    }

    @Override
    public String getUsername() {

        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
