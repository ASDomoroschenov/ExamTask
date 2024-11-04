package ru.sberp.javaseniortask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sberp.javaseniortask.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
