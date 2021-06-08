package APP.APPLICATION.REPOSITORY;

import APP.APPLICATION.MODELS.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findAll();

    @Query(value = "select Client.ID, Client.BIRTHDAY, Client.FIRST_NAME, Client.SECOND_NAME, Client.TRAINER_ID, Client.EMAIL, Client.WALLET, Client.SUBSCRIPTION_VALIDITY" +
            " from Client, Entrances" +
            " where Entrances.CLIENT_ID = Client.ID and Entrances.ENTER IS NOT NULL AND Entrances.LEAVE IS NULL", nativeQuery = true)
    List<Client> findAllByLeaveEqNull();

}
