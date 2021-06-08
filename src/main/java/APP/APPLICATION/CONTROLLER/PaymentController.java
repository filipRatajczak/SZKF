package APP.APPLICATION.CONTROLLER;

import APP.APPLICATION.POJOS.ChartPojo;
import APP.APPLICATION.SERVICES.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class PaymentController {

    private final PaymentService paymentService;


    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping(value = "/employee/payments/tickets/month")
    public List<ChartPojo> getMonthTicketData(){
        return paymentService.getMonthTicketData(LocalDate.now(), LocalDate.now().minusMonths(1));
    }

    @GetMapping(value = "/employee/payments/tickets/quarter")
    public List<ChartPojo> getQuarterTicketData(){
        return paymentService.getMonthTicketData(LocalDate.now(), LocalDate.now().minusMonths(3));
    }

    @GetMapping(value = "/employee/payments/tickets/year")
    public List<ChartPojo> getYearTicketData(){
        return paymentService.getMonthTicketData(LocalDate.now(), LocalDate.now().minusYears(1));
    }

    @GetMapping(value = "/employee/payments/products/month")
    public List<ChartPojo> getMonthProductsData(){
        return paymentService.getMonthProductData(LocalDate.now(), LocalDate.now().minusMonths(1));
    }

    @GetMapping(value = "/employee/payments/products/quarter")
    public List<ChartPojo> getQuarterProductsData(){
        return paymentService.getQuarterProductData(LocalDate.now(), LocalDate.now().minusMonths(3));
    }

    @GetMapping(value = "/employee/payments/products/year")
    public List<ChartPojo> getYearProductsData(){
        return paymentService.getYearProductData(LocalDate.now(), LocalDate.now().minusYears(1));
    }

}
