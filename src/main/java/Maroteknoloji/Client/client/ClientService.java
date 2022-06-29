package Maroteknoloji.Client.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public String getClient(Long clientId){
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalStateException(
                        "client with id " + clientId + " does not exist"));
        return client.toString();
    }

    public void addNewClient(Client client) {
        Optional<Client> clientOptional = clientRepository
                .findClientByName(client.getName());
        if (clientOptional.isPresent()){
            throw new IllegalStateException("name taken");
        }
        clientRepository.save(client);
    }

    @Transactional
    public void deleteClient(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalStateException(
                        "client with id " + clientId + " does not exist"));
        if (client.getStatus() == 'p'){
            throw new IllegalStateException(client.getName() + " is already passive");
        }
        client.setStatus('p');
    }

    @Transactional
    public void updateClient(Long clientId,
                              String name,
                              String location) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalStateException(
                        "client with id " + clientId + " does not exist"));


        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(client.getName(), name)){
            client.setName(name);
        }

        if (location != null &&
                location.length() > 0 &&
                !Objects.equals(client.getLocation(), location)) {
            client.setLocation(location);
        }
    }

    @Transactional
    public void setActive(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalStateException(
                        "client with id " + clientId + " does not exist"));

        if (client.getStatus() == 'a'){
            throw new IllegalStateException(client.getName() + " is already active");
        }
        client.setStatus('a');
    }
}

