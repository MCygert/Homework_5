package com.mix.infoShareAcademy.dao;

import com.mix.infoShareAcademy.domain.Student;
import com.mix.infoShareAcademy.repository.StudentRepository;

public class StudentRepositoryDao {
    public static void addUser(Student student) {
        StudentRepository.getRepository().add(student);
    }

    public Student getStudentByID(Integer id) {
        return StudentRepository.getRepository().stream().filter(i->i.getId() == id).findFirst().orElse(null);
    }
}
