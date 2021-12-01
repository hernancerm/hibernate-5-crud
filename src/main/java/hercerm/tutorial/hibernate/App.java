package hercerm.tutorial.hibernate;

import java.util.List;

import hercerm.tutorial.hibernate.daos.MovieDao;
import hercerm.tutorial.hibernate.entities.Movie;
import hercerm.tutorial.hibernate.orm.EntityManagerProvider;
import javax.persistence.EntityManager;

public class App {

    private static MovieDao movieDao;

    static {
        EntityManager defaultEntityManager = EntityManagerProvider
                .open(EntityManagerProvider.DEFAULT_PERSISTENCE_UNIT);

        movieDao = new MovieDao(defaultEntityManager);
    }

    public static void main(String[] args) {
        /* create */
        Movie movie01 = new Movie("The Shining", 1980);
        Movie movie02 = new Movie("The Tenant", 1976);
        
        movieDao.create(movie01);
        movieDao.create(movie02);

        /* read */
        List<Movie> movies = movieDao.findAll();

        movies.stream().forEach(System.out::println);

        /* update */
        movie01.setTitle("Annihilation");
        movie01.setReleaseYear(2018);
        movieDao.update(movie01);

        /* delete */
        movieDao.delete(movie02);

        // print state of movies after updates.
        printMovies();

        // clean-up data so program can be re-run.
        movieDao.deleteAll();
    }

    private static void printMovies() {
        movieDao.findAll().stream().forEach(System.out::println);
    }
}
