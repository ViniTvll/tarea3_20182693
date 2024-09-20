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


}