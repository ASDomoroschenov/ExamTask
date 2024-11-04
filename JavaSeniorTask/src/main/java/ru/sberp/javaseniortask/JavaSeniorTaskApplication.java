package ru.sberp.javaseniortask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class JavaSeniorTaskApplication {

  public static void main(String[] args) {
    SpringApplication.run(JavaSeniorTaskApplication.class, args);
  }
}
