import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello Dolphin");
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

        try(EntityManager em = emf.createEntityManager())
        {
            Person p1 = new Person("Hanzi");
            PersonDetail pd1 = new PersonDetail("Nygade 41", 3720,"aakirkeby", 44);
            p1.addPersonDetail(pd1);
            Fee f1 = new Fee(100, LocalDate.of(2024,10,10));
            Fee f2 = new Fee(100, LocalDate.of(2024,9,22));
            p1.addFee(f1);
            p1.addFee(f2);

            em.getTransaction().begin();
            em.persist(p1);
            //em.remove(p1);
            em.getTransaction().commit();
        }
    }
}
