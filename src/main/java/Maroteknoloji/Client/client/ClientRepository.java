package Maroteknoloji.Client.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository
        extends JpaRepository<Client, Long> {


    // SELECT * FROM student WHERE name = ?
    @Query("SELECT c FROM Client c WHERE c.name = ?1")
    Optional<Client> findClientByName(String name);

}