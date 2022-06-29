package Maroteknoloji.Client.client;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Client {

    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    private long id;
    private String name;
    private String location;
    private LocalDateTime createDate = LocalDateTime.now();
    private String createUser;
    private char status = 'a';

    public Client() {
    }

    public Client(long id,
                   String name,
                  String location,
                   String createUser) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.createUser = createUser;
    }

    public Client(String name,
                  String location,
                   String createUser) {
        this.name = name;
        this.location = location;
        this.createUser = createUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Client {" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", location = '" + location + '\'' +
                ", createDate = " + createDate +
                ", createUser = '" + createUser + '\'' +
                ", status = " + status +
                '}';
    }
}
