package zavgorodnyaya.spring_boot.model;

//TODO добавить аннотации @Size, @NotEmpty
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "email")
    private String email;

    public User(String name, int age, String email) {

        this.name = name;
        this.age = age;
        this.email = email;
    }
}
