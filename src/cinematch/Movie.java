package cinematch;

/**
 * Represents a single movie with a title and genre. Genre is restricted to: C
 * (Comedy), A (Action), H (Horror), S (Sci-Fi), D (Drama).
 */
public class Movie
{

    private String title;
    private char genre;
    private String director;

    // ----------------------------------------------------------
    /**
     * Create a new Movie object.
     * 
     * @param title
     *            Movie title
     * @param genre
     *            Movie genre
     */
    public Movie(String title, char genre)
    {
        this.title = title;
        this.genre = genre;
        this.director = "Unknown";
    }


    // ----------------------------------------------------------
    /**
     * Create a new Movie object.
     * 
     * @param title
     *            Movie title
     * @param genre
     *            Movie genre
     * @param director
     *            Movie director
     */
    public Movie(String title, char genre, String director)
    {
        this.title = title;
        this.genre = genre;
        this.director = director;
    }


    // ----------------------------------------------------------
    /**
     * Returns movie title
     * 
     * @return movie title
     */
    public String getTitle()
    {
        return title;
    }


    // ----------------------------------------------------------
    /**
     * Returns movie genre
     * 
     * @return movie genre
     */
    public char getGenre()
    {
        return genre;
    }


    // ----------------------------------------------------------
    /**
     * Returns movie director
     * 
     * @return movie director
     */
    public String getDirector()
    {
        return director;
    }


    // ----------------------------------------------------------
    /**
     * Two movies are considered equal (i.e. exact duplicates) if both their
     * title (case-insensitive) and genre match.
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof Movie))
        {
            return false;
        }
        Movie other = (Movie)obj;
        return this.title != null && this.title.equalsIgnoreCase(other.title)
            && this.genre == other.genre;
    }

}
