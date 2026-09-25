package cinematch;

import java.util.ArrayList;

/**
 * Represents and manages a collection of Movie objects using an ArrayList. An
 * ArrayList was chosen because the list needs to support simple append/remove
 * operations and full iteration for searches, without requiring fast random
 * access by key or automatic ordering.
 */
public class MovieList
{

    private ArrayList<Movie> movies;

    // ----------------------------------------------------------
    /**
     * Create a new MovieList object.
     */
    public MovieList()
    {
        movies = new ArrayList<>();
    }


    // ----------------------------------------------------------
    /**
     * Create a new MovieList object.
     * 
     * @param movies
     *            an ArrayList of Movie objects
     */
    public MovieList(ArrayList<Movie> movies)
    {
        // Guard against a null list being passed in so the program never
        // crashes.
        this.movies = (movies != null) ? movies : new ArrayList<>();
    }


    // ----------------------------------------------------------
    /**
     * Get the ArrayList of movies
     * 
     * @return movies ArrayList
     */
    public ArrayList<Movie> getMovies()
    {
        return movies;
    }


    // ----------------------------------------------------------
    /**
     * Prints every movie in the list. Prints nothing (and does not crash) if
     * the list is empty.
     */
    public void printList()
    {
        for (Movie m : movies)
        {
            System.out.println(
                m.getTitle() + " - " + m.getGenre() + " - " + m.getDirector());
        }
    }


    // ----------------------------------------------------------
    /**
     * Adds new movie to list
     * 
     * @param newMovie
     *            Movie object to add
     */
    public void addMovie(Movie newMovie)
    {
        if (newMovie != null)
        {
            movies.add(newMovie);
        }
    }


    // ----------------------------------------------------------
    /**
     * Removes movieToRemove if present. Does nothing if it is not found, so the
     * program never crashes on a missing entry.
     * 
     * @param movieToRemove
     *            Movie object to remove
     */
    public void removeMovie(Movie movieToRemove)
    {
        movies.remove(movieToRemove);
    }


    // ----------------------------------------------------------
    /**
     * Checks the emptiness of the MovieList
     * 
     * @return if movies is empty
     */
    public boolean isEmpty()
    {
        return movies.isEmpty();
    }


    // ----------------------------------------------------------
    /**
     * Returns all movies whose title matches (case-insensitive). Returns an
     * empty list if nothing is found.
     * 
     * @param title
     *            Movie title
     * @return MovieList with matching titles
     */
    public MovieList titleSearch(String title)
    {
        MovieList results = new MovieList();
        if (title == null)
        {
            return results;
        }
        for (Movie m : movies)
        {
            if (m.getTitle() != null && m.getTitle().equalsIgnoreCase(title))
            {
                results.addMovie(m);
            }
        }
        return results;
    }


    // ----------------------------------------------------------
    /**
     * Returns all movies matching the given genre. Returns an empty list if
     * nothing is found.
     * 
     * @param genre
     *            Movie genre
     * @return MovieList with matching genres
     */
    public MovieList genreSearch(char genre)
    {
        MovieList results = new MovieList();
        for (Movie m : movies)
        {
            if (m.getGenre() == genre)
            {
                results.addMovie(m);
            }
        }
        return results;
    }


    // ----------------------------------------------------------
    /**
     * Returns all movies matching the given director. Returns an empty list if
     * nothing is found.
     * 
     * @param director
     *            Movie director
     * @return MovieList with matching genres
     */
    public MovieList directorSearch(String director)
    {
        MovieList results = new MovieList();
        if (director == null)
        {
            return results;
        }
        for (Movie m : movies)
        {
            if (m.getDirector() != null
                && m.getDirector().equalsIgnoreCase(director))
            {
                results.addMovie(m);
            }
        }
        return results;
    }


    // ----------------------------------------------------------
    /**
     * Returns a new list containing this list's movies with any entries found
     * in otherList removed (used to filter out already-watched movies from
     * search results). Returns a copy of this list if otherList is empty or
     * null.
     * 
     * @param otherList
     *            List of movies to remove
     * @return MovieList with otherList removed
     */
    public MovieList removeOtherList(ArrayList<Movie> otherList)
    {
        ArrayList<Movie> results = new ArrayList<Movie>();
        MovieList resultsMovieList;

        if (otherList == null || otherList.isEmpty())
        {
            results.addAll(movies);

            resultsMovieList = new MovieList(results);
            return resultsMovieList;
        }
        for (Movie m : movies)
        {
            if (!otherList.contains(m))
            {
                results.add(m);
            }
        }

        resultsMovieList = new MovieList(results);
        return resultsMovieList;
    }
}
