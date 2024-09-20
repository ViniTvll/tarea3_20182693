package com.example.tarea3_20182693.repository;

import com.example.tarea3_20182693.model.bean.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByName(String textoIngresado);

    @Query(nativeQuery = true, value = "SELECT * FROM hr.employees where firstName = ?1")
    List<Employee> buscarPorNombre(String textoIngreso);

    @Query(nativeQuery = true, value = "SELECT * FROM hr.employees where lastName like %?1%")
    List<Employee> buscarPorApellido(String apellido);


    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE hr.employees SET firstName = ?1 WHERE EmployeeID = ?2")
    void actualizarNombre(String firstName, int employeeId);
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE hr.employees SET lastName = ?1 WHERE EmployeeID = ?2")
    void actualizarApellido(String lastName, int employeeId);
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE hr.employees SET email = ?1 WHERE EmployeeID = ?2")
    void actualizarCorrreo(String email, int employeeId);


}