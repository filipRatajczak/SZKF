package APP.APPLICATION.REPOSITORY;


import APP.APPLICATION.MODELS.Payments;
import APP.APPLICATION.POJOS.ChartPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payments, Long> {

    @Query(value = "select new APP.APPLICATION.POJOS.ChartPojo(p.date, sum(t.price))" +
            " from Ticket t inner join Payments p on t.id = p.ticket.id " +
            "where p.date between ?2 and ?1 " +
            "group by p.date")
    List<ChartPojo> sumDailySoldTickets(LocalDate startDate, LocalDate stopDate);

    @Query(value = "select new APP.APPLICATION.POJOS.ChartPojo(pa.date, sum(pr.price))" +
            " from Products pr inner join Payments pa on pr.id = pa.products.id " +
            "where pa.date between ?2 and ?1 " +
            "group by pa.date")
    List<ChartPojo> sumDailySoldProducts(LocalDate startDate, LocalDate stopDate);

}