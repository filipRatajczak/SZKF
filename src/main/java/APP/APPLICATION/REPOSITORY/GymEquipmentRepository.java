package APP.APPLICATION.REPOSITORY;


import APP.APPLICATION.MODELS.GymEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymEquipmentRepository extends JpaRepository<GymEquipment, Long> {
}
