package ru.sberp.javaseniortask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sberp.javaseniortask.models.PhoneData;

@Repository
public interface PhoneDataRepository extends JpaRepository<PhoneData, Long> {

}
