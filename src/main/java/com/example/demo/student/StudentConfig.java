package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student joyce = new Student(
                    "joyce",
                    "joyce.kim@outlook.com",
                    LocalDate.of(2000, Month.MAY,16));

            Student alex = new Student(
                    "alex",
                    "alex.kim@outlook.com",
                    LocalDate.of(2003, Month.JUNE, 13)
            );

            Student sissi = new Student(
                    "sissi",
                    "sissi.kim@outlook.com",
                    LocalDate.of(2010, Month.DECEMBER, 03));

            repository.saveAll(
                    List.of(joyce, alex, sissi)
            );
        };
    }
}
