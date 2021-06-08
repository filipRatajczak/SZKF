package APP.APPLICATION.CONTROLLER;


import APP.APPLICATION.MODELS.Ticket;
import APP.APPLICATION.POJOS.TicketPojo;
import APP.APPLICATION.SERVICES.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {


    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping(value = "/employee/ticket/create")
    public void createTicket(@RequestBody TicketPojo ticketPojo) {
        ticketService.createTicket(ticketPojo);
    }

    @GetMapping(value = "/employee/ticket/getAll")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllProducts();
    }

    @DeleteMapping(value = "employee/ticket/{id}/delete")
    public void deleteProduct(@PathVariable Long id) {
        ticketService.deleteProduct(id);
    }

    @PutMapping(value = "employee/ticket/{id}/edit")
    public void editProduct(@PathVariable Long id, @RequestBody TicketPojo ticketPojo) {
        ticketService.editProduct(id, ticketPojo);
    }
}
