package com.tutorial.Repository;

import com.tutorial.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // query delete
    // @Query("DELETE FROM Employee AS e WHERE e.id = ?1")
    // void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);

    /**
     * Repository akan berkaitan dengan DTO.. DTO sendiri adalah data trasfer objek..
     * yang mana ini akan menangai query secara otomatis jadi JPA
     * untuk menggunakanya kita perlu extends iterface JpaRepository<Entity objekEntity, Long priemaryKeyEntity>
     * otomatis sudah bisa implemtasi JpaRepository dari JPA
     */


}
