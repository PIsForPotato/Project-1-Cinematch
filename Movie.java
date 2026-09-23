/**
 * Represents a single movie with a title and genre.
 * Genre is restricted to: C (Comedy), A (Action), H (Horror), S (Sci-Fi), D (Drama).
 */
public class Movie {

    private String title;
    private char genre;

    public Movie(String title, char genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public char getGenre() {
        return genre;
    }

    /**
     * Two movies are considered equal (i.e. exact duplicates) if both their
     * title (case-insensitive) and genre match.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) obj;
        return this.title != null
                && this.title.equalsIgnoreCase(other.title)
                && this.genre == other.genre;
    }

    @Override
    public int hashCode() {
        int titleHash = (title == null) ? 0 : title.toUpperCase().hashCode();
        return 31 * titleHash + Character.hashCode(genre);
    }

    @Override
    public String toString() {
        return title + " (" + genre + ")";
    }
}
