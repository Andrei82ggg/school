package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService service;

    public FacultyController(FacultyService service) {
        this.service = service;
    }
    @PostMapping
    public void add(@RequestBody Faculty faculty){
        service.add(faculty);
    }
    @GetMapping("/id")
    public Faculty get(@PathVariable long id){
        return service.get(id);
    }
    @PutMapping
    public Faculty update(@RequestBody Faculty faculty){
        return service.update(faculty);
    }
    @DeleteMapping
    public boolean remove(@PathVariable long id){
        return service.remove(id);
    }
    @GetMapping("/byColor")
    public Collection<Faculty> byColor(@RequestParam String color){
        return service.filterByColor(color);
    }
}
