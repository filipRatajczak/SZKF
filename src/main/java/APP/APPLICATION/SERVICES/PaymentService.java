package APP.APPLICATION.SERVICES;

import APP.APPLICATION.POJOS.ChartPojo;
import APP.APPLICATION.REPOSITORY.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Transactional
    public List<ChartPojo> getMonthTicketData(LocalDate start, LocalDate stop){
        return paymentRepository.sumDailySoldTickets(start, stop);
    }

    @Transactional
    public List<ChartPojo> getMonthProductData(LocalDate start, LocalDate stop){
        return paymentRepository.sumDailySoldProducts(start, stop);
    }

    @Transactional
    public List<ChartPojo> getQuarterTicketData(LocalDate start, LocalDate stop){
        return paymentRepository.sumDailySoldTickets(start, stop);
    }

    @Transactional
    public List<ChartPojo> getQuarterProductData(LocalDate start, LocalDate stop){
        return paymentRepository.sumDailySoldProducts(start, stop);
    }

    @Transactional
    public List<ChartPojo> getYearTicketData(LocalDate start, LocalDate stop){
        return paymentRepository.sumDailySoldTickets(start, stop);
    }

    @Transactional
    public List<ChartPojo> getYearProductData(LocalDate start, LocalDate stop){
        return paymentRepository.sumDailySoldProducts(start, stop);
    }


}
