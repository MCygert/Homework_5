package com.mix.infoShareAcademy.dao;

import com.mix.infoShareAcademy.domain.Student;
import com.mix.infoShareAcademy.repository.StudentRepository;

import javax.ejb.Stateless;
import java.util.concurrent.ThreadLocalRandom;

@Stateless
public class RandomStudentDao {
    public Student getRandomStudent() {
        int randomNum = ThreadLocalRandom.current().nextInt(1,3+1);
        StudentRepositoryDao studentRepositoryDao = new StudentRepositoryDao();
        return studentRepositoryDao.getStudentByID(randomNum);
    }

}
