package com.mix.infoShareAcademy.dao;

import com.mix.infoShareAcademy.domain.Student;
import com.mix.infoShareAcademy.repository.StudentRepository;

import java.util.Optional;

public class StudentRepositoryDao {
    public static void addUser(Student student) {
        StudentRepository.getRepository().add(student);
    }

    public Student getStudentByID(Integer id) {
        return StudentRepository.getRepository().stream().filter(i->i.getId() == id).findFirst().orElse(null);
    }

    public static Optional<Student> getLastStudent() {

        return StudentRepository.getRepository().stream().reduce((first, second) -> second);
     }
}
