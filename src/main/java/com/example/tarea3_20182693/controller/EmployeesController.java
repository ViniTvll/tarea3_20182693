package com.example.tarea3_20182693.controller;

import com.example.tarea3_20182693.model.bean.Employee;
import com.example.tarea3_20182693.model.bean.Job;
import com.example.tarea3_20182693.model.repository.EmployeeDAO;
import com.example.tarea3_20182693.model.repository.JobDAO;
import com.example.tarea3_20182693.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EmployeesController {

    private final EmployeeRepository employeeRepository;
    private EmployeeDAO employeesDAO = new EmployeeDAO();
    private JobDAO jobsDAO = new JobDAO();

    public EmployeesController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping({"employee/list", "employee"})
    public String listarEmpleados(Model model) {
        List<Employee> listaEmpleados = employeesDAO.findAll();
        model.addAttribute("listaEmpleados", listaEmpleados);
        return "employeeList";
    }

    @GetMapping("/employee/info/{id}")
    public String informEmpleado(@PathVariable("id") int id, Model model) {
        Employee employee = employeesDAO.findById(id);
        List<Job> listaTrabajos = jobsDAO.findAll();
        model.addAttribute("employee", employee);
        model.addAttribute("listaTrabajos", listaTrabajos);
        return "employeeInfo";
    }


    @GetMapping("/employee/delete/{id}") /* popup hecho */
    public String borrarEmpleado(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        boolean eliminado = employeesDAO.deleteById(id);
        if (eliminado) {
            redirectAttributes.addAttribute("msg", "Se borró el empleado");
        } else {
            redirectAttributes.addAttribute("msg", "No se pudo borrar el empleado");
        }
        return "redirect:/employee";
    }
    @PostMapping("/buscarPorNombre")
    public String buscarPorNombre(@RequestParam("searchField") String searchField, Model model) {

        //List<Shipper> lista =  shipperRepository.findByCompanyName(searchField);
        List<Employee> lista = employeeRepository.buscarPorNombre(searchField);
        model.addAttribute("employeeList", lista);
        model.addAttribute("textoBuscado", searchField);

        return "employee/list";
    }

}