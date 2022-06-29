package Maroteknoloji.Client.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> selectAllClients() {
        return clientService.getClients();
    }

    @GetMapping(path = "{clientId}")
    public String selectClient(@PathVariable("clientId") Long clientId) {
        return clientService.getClient(clientId);
    }

    @PostMapping(path = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerNewClient(@RequestBody Client client){
        clientService.addNewClient(client);
    }

    @DeleteMapping(path = "delete/{clientId}")
    public void deleteClient(
            @PathVariable("clientId") Long clientId){
        clientService.deleteClient(clientId);
    }

    @PutMapping(path = "update/{clientId}")
    public void updateClient(
            @PathVariable("clientId") Long clientId,
            @RequestBody(required = false) Client client){
        clientService.updateClient(clientId, client.getName(), client.getLocation());
    }

    @PutMapping(path = "active/{clientId}")
    public void setActive(
            @PathVariable("clientId") Long clientId){
        clientService.setActive(clientId);
    }

}