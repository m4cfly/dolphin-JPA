import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Person {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    // 1:1 relation
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private PersonDetail personDetail;

    public Person(String name) {
        this.name = name;
    }

    // Relationer 1:M
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<Fee> fees = new HashSet<>();

    // 1:M
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<PersonEvent> events = new HashSet<>();

//    // Relationer M:M
//    @ManyToMany(cascade = CascadeType.PERSIST)
//    private Set<Event> events = new HashSet<>();

//    // UNI-Directional ADD
//    public void addEvent(Event event) {
//        this.events.add(event);
//    }

    // UNI-Directional ADD
    public void addEvent(Person person, Event event, LocalDate signUpDate,int eventFee) {
        PersonEvent personEvent = new PersonEvent(person,event,signUpDate,eventFee);
        this.events.add(personEvent);
    }



    // Bi-directional update
    public void addPersonDetail(PersonDetail personDetail){
        this.personDetail = personDetail;
        if(personDetail != null){
            personDetail.setPerson(this);
        }
    }
    public void addFee(Fee fee){
        this.fees.add(fee);
        if (fee != null){
            fee.setPerson(this);
        }
    }
}
