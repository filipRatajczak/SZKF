package APP.APPLICATION.CONTROLLER;


import APP.APPLICATION.MODELS.Client;
import APP.APPLICATION.POJOS.TicketPojo;
import APP.APPLICATION.REPOSITORY.ClientRepository;
import APP.APPLICATION.POJOS.ClientPojo;
import APP.APPLICATION.SERVICES.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ClientController {

    private final ClientRepository clientRepository;
    private final ClientService clientService;

    public ClientController(ClientRepository clientRepository, ClientService clientService) {
        this.clientRepository = clientRepository;
        this.clientService = clientService;
    }

    @PostMapping(value = "/employee/client/create")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        System.out.println("client /employee/client/create");
        return ResponseEntity.ok(clientRepository.save(client));
    }

    @GetMapping(value = "employee/client/getAll")
    public ResponseEntity<List<Client>> getAllClients() {
        System.out.println("client employee/client/getAll");
        return ResponseEntity.ok(clientRepository.findAll());
    }

    @Transactional
    @PutMapping(value = "employee/users/{id}/funds")
    public void addFunds(@PathVariable Long id, @RequestBody ClientPojo clientPojo) {
        System.out.println("client employee/users/{id}/funds");
        clientService.addFunds(id, clientPojo);
    }

    @Transactional
    @PutMapping(value = "employee/users/{id}/ticket")
    public void addTicket(@PathVariable Long id, @RequestBody TicketPojo ticketPojo) throws Exception {
        System.out.println("client employee/users/{id}/ticket");
        clientService.addTicket(id, ticketPojo);
    }

    @DeleteMapping(value = "employee/client/delete/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

    @PutMapping(value = "employee/client/edit/{id}")
    public void editClient(@PathVariable Long id,@RequestBody ClientPojo clientPojo) {
        clientService.editClient(id, clientPojo);
    }

    @GetMapping(value = "employee/client/getAll/active")
    public List<Client> getActiveClients(){
        return clientService.getActiveClients();
    }

}
