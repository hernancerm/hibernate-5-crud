package hercerm.tutorial.hibernate.daos;

import java.util.List;

import hercerm.tutorial.hibernate.entities.Movie;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MovieDao {

    private final EntityManager EM;

    public MovieDao(EntityManager entityManager) {
        this.EM = entityManager;
    }

    public void create(Movie movie) {
        EntityTransaction transaction = EM.getTransaction();

        try {
            transaction.begin();
            EM.persist(movie);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public List<Movie> findAll() {
        String queryFindAll = "SELECT m FROM Movie m";

        return EM.createQuery(queryFindAll, Movie.class).getResultList();
    }

    public void update(Movie movie) {
        EntityTransaction transaction = EM.getTransaction();

        try {
            transaction.begin();

            // If the entity is not managed in the current persistence context,
            // perform a merge to attach it and consider the changes provided.
            // This will allow transaction.commit() to propagate changes to the DB.
            if (!EM.contains(movie)) {
                EM.merge(movie);
            }

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public void delete(Movie movie) {
        EntityTransaction transaction = EM.getTransaction();

        try {
            transaction.begin();
            EM.remove(movie);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public void deleteAll() {
        findAll().stream().forEach(this::delete);
    }
}
