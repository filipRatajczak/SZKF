package APP.APPLICATION.REPOSITORY;

import APP.APPLICATION.MODELS.Entrances;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntrancesRepository extends JpaRepository<Entrances, Long> {

    @Query(value = "select * from Entrences ent where ent.client_id = ?1 and ent.leave is null", nativeQuery = true)
    List<Entrances> findByLeaveEqNull(Long id);

}
