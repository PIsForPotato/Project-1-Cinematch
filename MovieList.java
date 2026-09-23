import java.util.ArrayList;

/**
 * Represents and manages a collection of Movie objects using an ArrayList.
 * An ArrayList was chosen because the list needs to support simple
 * append/remove operations and full iteration for searches, without
 * requiring fast random access by key or automatic ordering.
 */
public class MovieList {

    private ArrayList<Movie> movies;

    public MovieList() {
        movies = new ArrayList<>();
    }

    public MovieList(ArrayList<Movie> movies) {
        // Guard against a null list being passed in so the program never crashes.
        this.movies = (movies != null) ? movies : new ArrayList<>();
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    /**
     * Prints every movie in the list. Prints nothing (and does not crash)
     * if the list is empty.
     */
    public void printList() {
        for (Movie m : movies) {
            System.out.println(m.getTitle() + " - " + m.getGenre());
        }
    }

    public void addMovie(Movie newMovie) {
        if (newMovie != null) {
            movies.add(newMovie);
        }
    }

    /**
     * Removes movieToRemove if present. Does nothing if it is not found,
     * so the program never crashes on a missing entry.
     */
    public void removeMovie(Movie movieToRemove) {
        movies.remove(movieToRemove);
    }

    /**
     * Returns all movies whose title matches (case-insensitive).
     * Returns an empty list if nothing is found.
     */
    public ArrayList<Movie> titleSearch(String title) {
        ArrayList<Movie> results = new ArrayList<>();
        if (title == null) {
            return results;
        }
        for (Movie m : movies) {
            if (m.getTitle() != null && m.getTitle().equalsIgnoreCase(title)) {
                results.add(m);
            }
        }
        return results;
    }

    /**
     * Returns all movies matching the given genre.
     * Returns an empty list if nothing is found.
     */
    public ArrayList<Movie> genreSearch(char genre) {
        ArrayList<Movie> results = new ArrayList<>();
        for (Movie m : movies) {
            if (m.getGenre() == genre) {
                results.add(m);
            }
        }
        return results;
    }

    /**
     * Returns a new list containing this list's movies with any entries
     * found in otherList removed (used to filter out already-watched movies
     * from search results). Returns a copy of this list if otherList is empty
     * or null.
     */
    public ArrayList<Movie> removeOtherList(ArrayList<Movie> otherList) {
        ArrayList<Movie> results = new ArrayList<>();
        if (otherList == null || otherList.isEmpty()) {
            results.addAll(movies);
            return results;
        }
        for (Movie m : movies) {
            if (!otherList.contains(m)) {
                results.add(m);
            }
        }
        return results;
    }
}
