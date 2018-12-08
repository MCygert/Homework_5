package com.mix.infoShareAcademy.repository;

import com.mix.infoShareAcademy.domain.Student;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private static List<Student> usersRepository = new ArrayList<>();

    public static List<Student> getRepository() {
        if (usersRepository.size() == 0) {
            fillRepositoryWithDefaults();
        }
        return usersRepository;
    }

    private static void fillRepositoryWithDefaults() {
        Student student1 = new Student();
        student1.setName("Mikolaj");
        student1.setId(1);
        student1.setSurname("Cygert");
        student1.setTeam("jjdd5-tailandczycy");
        student1.setTime(LocalDateTime.now());
        usersRepository.add(student1);

        Student student2 = new Student();
        student2.setName("Karol");
        student2.setId(2);
        student2.setSurname("Bemka");
        student2.setTeam("jjdd5-jbusters");
        student2.setTime(LocalDateTime.now());
        usersRepository.add(student2);

        Student student3 = new Student();
        student3.setName("Tymoteusz");
        student3.setId(3);
        student3.setSurname("Feil");
        student3.setTeam("jjdd5-niewiem");
        student3.setTime(LocalDateTime.now());
        usersRepository.add(student3);
    }

    public static boolean contains(Student student) {
        List<Student> repository = getRepository();
        for (Student studentFromList : repository) {
            if (studentFromList.getId() == student.getId()) {
                return true;
            }
        }
        return false;
    }
}
