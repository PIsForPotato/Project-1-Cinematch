import java.util.ArrayList;

/**
 * Provides the hard-coded "existing movie database" used in place of a real
 * external database (per the MVP scope). Contains 50 real movies, 10 for
 * each supported genre: C (Comedy), A (Action), H (Horror), S (Sci-Fi),
 * D (Drama).
 */
public class MovieDatabase {

    public static MovieList buildDatabase() {
        ArrayList<Movie> list = new ArrayList<>();

        // Comedy (C)
        list.add(new Movie("Elf", 'C'));
        list.add(new Movie("Ted", 'C'));
        list.add(new Movie("Superbad", 'C'));
        list.add(new Movie("Anchorman", 'C'));
        list.add(new Movie("Dodgeball", 'C'));
        list.add(new Movie("Grown Ups", 'C'));
        list.add(new Movie("Tootsie", 'C'));
        list.add(new Movie("Airplane", 'C'));
        list.add(new Movie("Clueless", 'C'));
        list.add(new Movie("Zoolander", 'C'));

        // Action (A)
        list.add(new Movie("Speed", 'A'));
        list.add(new Movie("Gladiator", 'A'));
        list.add(new Movie("Rambo", 'A'));
        list.add(new Movie("Predator", 'A'));
        list.add(new Movie("Commando", 'A'));
        list.add(new Movie("Taken", 'A'));
        list.add(new Movie("Skyfall", 'A'));
        list.add(new Movie("Salt", 'A'));
        list.add(new Movie("Tenet", 'A'));
        list.add(new Movie("RoboCop", 'A'));

        // Horror (H)
        list.add(new Movie("Saw", 'H'));
        list.add(new Movie("It", 'H'));
        list.add(new Movie("Us", 'H'));
        list.add(new Movie("Carrie", 'H'));
        list.add(new Movie("Halloween", 'H'));
        list.add(new Movie("Psycho", 'H'));
        list.add(new Movie("Scream", 'H'));
        list.add(new Movie("Jaws", 'H'));
        list.add(new Movie("Split", 'H'));
        list.add(new Movie("Smile", 'H'));

        // Sci-Fi (S)
        list.add(new Movie("Dune", 'S'));
        list.add(new Movie("Arrival", 'S'));
        list.add(new Movie("Gravity", 'S'));
        list.add(new Movie("Avatar", 'S'));
        list.add(new Movie("Elysium", 'S'));
        list.add(new Movie("Prometheus", 'S'));
        list.add(new Movie("Looper", 'S'));
        list.add(new Movie("Moon", 'S'));
        list.add(new Movie("Interstellar", 'S'));
        list.add(new Movie("Her", 'S'));

        // Drama (D)
        list.add(new Movie("Room", 'D'));
        list.add(new Movie("Joker", 'D'));
        list.add(new Movie("Moonlight", 'D'));
        list.add(new Movie("Rocky", 'D'));
        list.add(new Movie("Big", 'D'));
        list.add(new Movie("Selma", 'D'));
        list.add(new Movie("Fences", 'D'));
        list.add(new Movie("Nomadland", 'D'));
        list.add(new Movie("CODA", 'D'));
        list.add(new Movie("Whiplash", 'D'));

        return new MovieList(list);
    }
}
