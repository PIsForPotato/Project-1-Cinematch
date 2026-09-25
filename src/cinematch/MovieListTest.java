package cinematch;

import student.TestCase;

import java.util.ArrayList;

/**
 * Tests the MovieList class.
 *
 * @author Daana Doddabendigere
 * @version 2026.09.25
 */
public class MovieListTest
    extends student.TestCase
{
    private MovieList list;

    /**
     * Sets up the test.
     */
    public void setUp()
    {
        list = new MovieList();
    }


    /**
     * Tests the constructor.
     */
    public void testConstructor()
    {
        assertEquals(0, list.getMovies().size());
    }


    /**
     * Tests the ArrayList constructor.
     */
    public void testArrayListConstructor()
    {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Avatar", 'A'));

        MovieList newList = new MovieList(movies);

        assertEquals(1, newList.getMovies().size());
        assertEquals("Avatar", newList.getMovies().get(0).getTitle());
    }


    /**
     * Tests getMovies.
     */
    public void testGetMovies()
    {
        Movie avatar = new Movie("Avatar", 'A');

        list.addMovie(avatar);

        assertEquals(avatar, list.getMovies().get(0));
    }


    /**
     * Tests addMovie.
     */
    public void testAddMovie()
    {
        Movie movie = new Movie("Scream", 'H');

        list.addMovie(movie);

        assertEquals(1, list.getMovies().size());
        assertTrue(list.getMovies().contains(movie));
    }


    /**
     * Tests removeMovie.
     */
    public void testRemoveMovie()
    {
        Movie movie = new Movie("Scream", 'H');

        list.addMovie(movie);
        list.removeMovie(movie);

        assertEquals(0, list.getMovies().size());
    }


    /**
     * Tests titleSearch.
     */
    public void testTitleSearch()
    {
        list.addMovie(new Movie("Interstellar", 'S'));
        list.addMovie(new Movie("Avatar", 'A'));

        MovieList result = list.titleSearch("Interstellar");

        assertEquals(1, result.getMovies().size());
        assertEquals("Interstellar", result.getMovies().get(0).getTitle());
    }


    /**
     * Tests titleSearch when no movie is found.
     */
    public void testTitleSearchNoMatch()
    {
        list.addMovie(new Movie("Interstellar", 'S'));

        MovieList result = list.titleSearch("Nonexistent Movie");

        assertEquals(0, result.getMovies().size());
    }


    /**
     * Tests genreSearch.
     */
    public void testGenreSearch()
    {
        list.addMovie(new Movie("Shrek", 'C'));
        list.addMovie(new Movie("Avengers", 'A'));

        MovieList result = list.genreSearch('C');

        assertEquals(1, result.getMovies().size());
        assertEquals("Shrek", result.getMovies().get(0).getTitle());
    }


    /**
     * Tests directorSearch.
     */
    public void testDirectorSearch()
    {
        list.addMovie(new Movie("Interstellar", 'S'));
        list.addMovie(new Movie("Avatar", 'A', "JamesCameron"));
        list.addMovie(new Movie("Titanic", 'D', "JamesCameron"));

        MovieList result = list.directorSearch("JamesCameron");

        assertEquals(2, result.getMovies().size());
        assertEquals("Avatar", result.getMovies().get(0).getTitle());
        assertEquals("Titanic", result.getMovies().get(1).getTitle());
    }


    /**
     * Tests removeOtherList.
     */
    public void testRemoveOtherList()
    {
        Movie shrek = new Movie("Shrek", 'C');
        Movie avatar = new Movie("Avatar", 'A');

        list.addMovie(shrek);
        list.addMovie(avatar);

        ArrayList<Movie> otherList = new ArrayList<Movie>();
        otherList.add(shrek);

        MovieList result = list.removeOtherList(otherList);

        assertEquals(1, result.getMovies().size());
        assertEquals(avatar, result.getMovies().get(0));
    }
}
