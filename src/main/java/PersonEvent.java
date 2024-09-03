import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
public class PersonEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Person person;
    @ManyToOne
    private Event event;
    private LocalDate signUpDate;
    private int eventFee;

    public PersonEvent(Person person, Event event, LocalDate signUpDate, int eventFee) {
        this.person = person;
        this.event = event;
        this.signUpDate = signUpDate;
        this.eventFee = eventFee;
    }
}
