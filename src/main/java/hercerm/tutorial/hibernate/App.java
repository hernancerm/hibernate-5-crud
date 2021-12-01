package hercerm.tutorial.hibernate;

import hercerm.tutorial.hibernate.orm.EntityManagerProvider;
import javax.persistence.EntityManager;

public class App {

    public static void main(String[] args) {
        EntityManager defaultEntityManager = EntityManagerProvider
            .open(EntityManagerProvider.DEFAULT_PERSISTENCE_UNIT);
    }
}
