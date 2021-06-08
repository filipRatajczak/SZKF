package APP.APPLICATION.CONTROLLER;

import APP.APPLICATION.SERVICES.EntrancesService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntrancesController {

    private final EntrancesService entrancesService;

    public EntrancesController(EntrancesService entrancesService) {
        this.entrancesService = entrancesService;
    }

    @PostMapping(value = "employee/entrances/{id}/enter")
    public void enter(@PathVariable Long id){
        System.out.println("entrances employee/entrances/{id}/enter");
        entrancesService.userEnter(id);
    }

    @PutMapping(value = "employee/entrances/{id}/leave")
    public void leave(@PathVariable Long id){
        System.out.println("entrances employee/entrances/{id}/leave");
        entrancesService.userLeave(id);
    }

}
