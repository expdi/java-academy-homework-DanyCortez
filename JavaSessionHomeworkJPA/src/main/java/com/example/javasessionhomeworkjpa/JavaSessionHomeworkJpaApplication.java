package com.example.javasessionhomeworkjpa;

import com.example.javasessionhomeworkjpa.clases.Adopter;
import com.example.javasessionhomeworkjpa.service.AdopterService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class JavaSessionHomeworkJpaApplication {

    public static void main(String[] args) {

        SpringApplication.run(JavaSessionHomeworkJpaApplication.class, args);

    }

}

@Component
class MyRunner implements CommandLineRunner {

    final AdopterService adopterService;

    public MyRunner(AdopterService adopterService){
        this.adopterService = adopterService;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Adopter> adopters = adopterService.getAll();

       adopters.forEach(System.out::println);
    }
}