package APP.APPLICATION.REPOSITORY;

import APP.APPLICATION.MODELS.Entrences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrencesRepository extends JpaRepository<Entrences, Long> {
}
