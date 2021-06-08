package APP.APPLICATION.SERVICES;


import APP.APPLICATION.MODELS.Client;
import APP.APPLICATION.MODELS.Entrances;
import APP.APPLICATION.REPOSITORY.ClientRepository;
import APP.APPLICATION.REPOSITORY.EntrancesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;


@Service
public class EntrancesService {


    private final ClientRepository clientRepository;
    private final EntrancesRepository entrencesRepository;

    public EntrancesService(ClientRepository clientRepository, EntrancesRepository entrencesRepository) {
        this.clientRepository = clientRepository;
        this.entrencesRepository = entrencesRepository;
    }

    @Transactional
    public void userEnter(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        client.ifPresent(cli -> {
            Entrances entrences = new Entrances();
            entrences.setEnter(LocalDate.now());
            cli.addEntrance(entrences);
            clientRepository.save(cli);
        });
    }

    @Transactional
    public void userLeave(Long id) {
        Optional<Entrances> entrances = entrencesRepository.findByLeaveEqNull(id).stream().findFirst();
        entrances.ifPresent(e -> e.setLeave(LocalDate.now()));
    }

}
