package cinematch;
import student.TestCase;


/**
* Tests the Movie class.
*
* @author Daana Doddabendigere
* @version 2026.09.25
*/
public class MovieTest extends student.TestCase
{
  private Movie movie;
  private Movie secondMovie;

  /**
   * Sets up the test.
   */
  public void setUp()
  {
      movie = new Movie("Titanic", 'D');
      secondMovie = new Movie("Titanic", 'D', "JamesCameron");
  }

  /**
   * Tests the constructor.
   */
  public void testConstructor()
  {
      assertEquals("Titanic", movie.getTitle());
      assertEquals('D', movie.getGenre());
  }

  /**
   * Tests getTitle.
   */
  public void testGetTitle()
  {
      assertEquals("Titanic", movie.getTitle());
  }

  /**
   * Tests getGenre.
   */
  public void testGetGenre()
  {
      assertEquals("Unknown", movie.getDirector());
      assertEquals("JamesCameron", secondMovie.getDirector());
  }
  
  /**
   * Tests getDirector.
   */
  public void testGetDirector()
  {
      assertEquals('D', movie.getGenre());
  }


  /**
   * Tests equals.
   */
  public void testEquals()
  {
      Movie sameMovie = new Movie("Titanic", 'D');
      Movie differentGenre = new Movie("Titanic", 'A');

      assertTrue(movie.equals(sameMovie));
      assertFalse(movie.equals(differentGenre));
  }
}
