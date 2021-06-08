package APP.APPLICATION.SERVICES;


import APP.APPLICATION.MODELS.Products;
import APP.APPLICATION.MODELS.Ticket;
import APP.APPLICATION.POJOS.ProductPojo;
import APP.APPLICATION.POJOS.TicketPojo;
import APP.APPLICATION.REPOSITORY.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Transactional
    public void createTicket(TicketPojo ticketPojo){
        Ticket ticket = new Ticket();
        ticket.setName(ticketPojo.getName());
        ticket.setPeriodOfValidity(ticketPojo.getPeriodOfValidity());
        ticket.setPrice(ticketPojo.getPrice());
        ticketRepository.save(ticket);
    }

    @Transactional
    public List<Ticket> getAllProducts(){
        return ticketRepository.findAll();
    }

    @Transactional
    public void deleteProduct(Long id){
        ticketRepository.deleteById(id);
    }

    @Transactional
    public void editProduct(Long id, TicketPojo ticketPojo){
        Optional<Ticket> ticket = ticketRepository.findById(id);

        ticket.ifPresent(e -> {
            e.setName(ticketPojo.getName());
            e.setPeriodOfValidity(ticketPojo.getPeriodOfValidity());
            e.setPrice(ticketPojo.getPrice());
        });
    }

}
