package ru.sberp.javaseniortask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sberp.javaseniortask.models.EmailData;

@Repository
public interface EmailDataRepository extends JpaRepository<EmailData, Long> {

}
