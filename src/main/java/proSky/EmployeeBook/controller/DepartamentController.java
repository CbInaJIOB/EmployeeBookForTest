package proSky.EmployeeBook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proSky.EmployeeBook.model.Employee;
import proSky.EmployeeBook.service.DepartamentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departament")
public class DepartamentController {
    private final DepartamentService departamentService;

    public DepartamentController(DepartamentService departamentService) {
        this.departamentService = departamentService;
    }

    @GetMapping("/{id}/salary/sum")
    public String sumSalary(@PathVariable("id") int dep) {
        return departamentService.sumSalary(dep);
    }

    @GetMapping("/{id}/salary/max")
    public Employee max(@PathVariable("id") int dep) {
        return departamentService.max(dep);
    }

    @GetMapping("/{id}/salary/min")
    public Employee min(@PathVariable("id") int dep) {
        return departamentService.min(dep);
    }

    @GetMapping("/{id}/employees")
    public Collection<Employee> byDep(@PathVariable("id") int dep) {
        return departamentService.byDep(dep);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> all() {
        return departamentService.all();
    }
}
