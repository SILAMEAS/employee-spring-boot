package net.javaguide.emsbackend.repository;

import java.util.Optional;
import net.javaguide.emsbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
  Optional<Employee> findByEmail(String empEmail);

}
