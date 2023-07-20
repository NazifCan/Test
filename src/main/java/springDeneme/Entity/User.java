package springDeneme.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "Users")
public class User extends BaseUser{
    @Id
    @SequenceGenerator(name = "seq_gen",initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_gen")
    private Long id;

    @Column(name = "ad")
    private String name;

    @Column(name = "soyad")
    private String surname;

}
