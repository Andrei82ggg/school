package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final Map<Long, Faculty> storage = new HashMap<>();
    private long counter = 0;
    public  void add(Faculty faculty){
        storage.put(counter++, faculty);
    }
    public Faculty get(long id){
        return storage.get(id);
    }
    public boolean remove(long id){
        return storage.remove(id) != null;
    }
    public Faculty update(Faculty faculty){
        if (storage.containsKey(faculty.getId())){
            storage.put(faculty.getId(), faculty);
            return faculty;
        }
        return null;
    }

    public Collection<Faculty> filterByColor(String color) {
        return storage.values()
                .stream()
                .filter(f -> f.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());
    }
}
