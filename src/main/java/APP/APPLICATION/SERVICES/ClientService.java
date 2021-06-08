package APP.APPLICATION.SERVICES;


import APP.APPLICATION.MODELS.Client;
import APP.APPLICATION.MODELS.Payments;
import APP.APPLICATION.MODELS.Ticket;
import APP.APPLICATION.POJOS.ClientPojo;
import APP.APPLICATION.POJOS.TicketPojo;
import APP.APPLICATION.REPOSITORY.ClientRepository;
import APP.APPLICATION.REPOSITORY.PaymentRepository;
import APP.APPLICATION.REPOSITORY.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {


    private final ClientRepository clientRepository;
    private final TicketRepository ticketRepository;
    private final PaymentRepository paymentRepository;

    public ClientService(ClientRepository clientRepository, TicketRepository ticketRepository, PaymentRepository paymentRepository) {
        this.clientRepository = clientRepository;
        this.ticketRepository = ticketRepository;
        this.paymentRepository = paymentRepository;
    }

    @Transactional
    public void addFunds(Long id, ClientPojo clientPojo) {
        clientRepository.findById(id)
                .ifPresent(client -> client.setWallet(client.getWallet().add(clientPojo.getWallet())));
    }

    @Transactional
    public void addTicket(Long id, TicketPojo ticketPojo) {
        Ticket ticket = ticketRepository.findByName(ticketPojo.getName());
        Optional<Client> client = clientRepository.findById(id);

        if (client.get().getWallet().compareTo(ticket.getPrice()) >= 0) {
            LocalDate date = client.get().getSubscriptionValidity() == null ? LocalDate.now() : client.get().getSubscriptionValidity();
            client.ifPresent(e -> e.setSubscriptionValidity(date.plusDays(ticket.getPeriodOfValidity())));
            client.ifPresent(e -> e.setWallet(e.getWallet().subtract(ticket.getPrice())));
            Payments payments = new Payments();
            payments.setClient(client.get());
            payments.setTicket(ticket);
            payments.setDate(LocalDate.now());
            paymentRepository.save(payments);
        }
    }

    @Transactional
    public void deleteClient(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        client.ifPresent(clientRepository::delete);
    }

    @Transactional
    public void editClient(Long id, ClientPojo clientPojo) {
        System.out.println(clientPojo.toString());
        Optional<Client> client = clientRepository.findById(id);
        client.ifPresent(e -> {
            e.setFirstName(clientPojo.getFirstName());
            e.setSecondName(clientPojo.getSecondName());
            e.setEmail(clientPojo.getEmail());
        });
    }

    @Transactional
    public List<Client> getActiveClients() {
        return clientRepository.findAllByLeaveEqNull();
    }

}


