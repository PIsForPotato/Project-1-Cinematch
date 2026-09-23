package cinematch;

import java.util.Scanner;

public class CinematchSubmenu
{
    // ~ Fields ................................................................

    private String titleInput = null;
    private char genreInput = 'Z';
    private int searchType = 0;
    private MovieList databaseMovies = new MovieList();
    private MovieList watchedMovies = new MovieList();
    private Scanner scanner;

    // ~ Constructors ..........................................................
    /**
     * Create a new CinematchSubmenu object.
     * 
     * @param watchedMovies
     *            List of movies watched by user, starts empty
     * @param scanner
     *            Scanner for reading user input
     */
    public CinematchSubmenu(
        MovieList databaseMovies,
        MovieList watchedMovies,
        Scanner scanner)
    {
        if (watchedMovies != null)
        {
            this.databaseMovies = databaseMovies;
        }
        else
        {
            this.databaseMovies = new MovieList();
        }

        if (watchedMovies != null)
        {
            this.watchedMovies = watchedMovies;
        }
        else
        {
            this.watchedMovies = new MovieList();
        }

        if (scanner != null)
        {
            this.scanner = scanner;
        }
        else
        {
            scanner = new Scanner(System.in);
        }
    }

    // ~Public Methods ........................................................


    // ----------------------------------------------------------
    /**
     * Prompts the user for a String title
     * 
     * @return Returns the title input by the user
     */
    public String titlePrompt()
    {
        String title = "";

        while (title.equals(""))
        {
            System.out.println("Enter title:");
            title = scanner.nextLine();
            if (title == "")
            {
                System.out.println("Please enter a title.");
            }
        }

        title = title.toUpperCase();
        title = title.replaceAll("\\s", "");

        titleInput = title;
        return title;
    }


    // ----------------------------------------------------------
    /**
     * Prompts the user for a character Genre
     * 
     * @return Returns the genre input by the user
     */
    public char genrePrompt()
    {
        char genre;
        char[] acceptableGenres = { 'C', 'A', 'H', 'S', 'D' };
        boolean validGenre = false;

        while (!validGenre)
        {
            System.out.println(
                "Available Genres:\n" + "C - Comedy\n" + "A - Action\n"
                    + "H - Horror\nS" + "- Sci-fi\n" + "D - Drama\n"
                    + "Enter genre:");
            genre = scanner.nextLine().charAt(0);

            for (int i = 0; i < acceptableGenres.length; i++)
            {
                if (genre == (acceptableGenres[i]))
                {
                    validGenre = true;
                }
            }

            if (!validGenre)
            {
                System.out.println("Please input a valid genre.");
            }
        }

        genreInput = genre;
        return genre;
    }


    // ----------------------------------------------------------
    /**
     * Prompts the user to search for genre or movie
     * 
     * @return Returns the search input by the user
     */
    public int searchPrompt()
    {
        int search = 0;

        while (search == 0)
        {
            System.out.println(
                "What do you want to search for?\n" + "1 - By genre\n"
                    + "2 - By title");
            System.out.println("Enter choice:");

            try
            {
                search = Integer.parseInt(scanner.nextLine());
                if (search != 1 && search != 2)
                {
                    System.out.println("Please input a valid integer.");
                    search = 0;
                }
            }
            catch (NumberFormatException e)
            {
                System.out
                    .println("Not an integer, please input a valid integer.");
                search = 0;
            }
        }

        searchType = search;
        return search;
    }


    // ----------------------------------------------------------
    /**
     * Creates a movie using titleInput and genreInput and validates for
     * duplicates by comparing with watched movies.
     * 
     * @return created Movie object
     */
    public Movie createMovie()
    {
        Movie newMovie = null;
        boolean sameTitle = false;
        boolean sameGenre = false;

        if (titleInput != null && genreInput != 'Z')
        {
            newMovie = new Movie(titleInput, genreInput);
        }
        else
        {
            return null;
        }

        if (!watchedMovies.titleSearch().isEmpty())
        {
            sameTitle = true;
        }
        if (!watchedMovies.genreSearch().isEmpty())
        {
            sameGenre = true;
        }

        if (sameTitle && sameGenre)
        {
            System.out.println(
                "This entry is a duplicate of an existing movie in your watched movies. It will not be added.");
            return null;
        }

        return newMovie;
    }


    // ----------------------------------------------------------
    /**
     * Iterate through databaseMovies and create a list of movies with
     * equivalent titles or genres, determined by searchType.
     * 
     * @return list of movies which match the search
     */
    public MovieList searchMovies()
    {
        MovieList returnList = new MovieList();
        if (searchType == 1) {
            if (genreInput == 'Z') {
                System.out.println("Invalid genre");
                return null;
            }
            returnList = databaseMovies.genreSearch(genreInput)
        }
        else if (searchType == 2) {
            if (titleInput == null) {
                System.out.println("Invalid genre");
                return null;
            }
            returnList = databaseMovies.titleSearch(titleInput);
        }
        else {
            return null;
        }
        
        
        returnList = returnList.removeOtherList(watchedMovies);
    }


    // ----------------------------------------------------------
    /**
     * Determines if the user wants to return to the main menu after adding
     * movies.
     * 
     * @return true if the user wants to continue looping; false otherwise
     */
    public boolean addMoviesReturnPrompt()
    {
        int choice = 0;

        while (choice == 0)
        {
            System.out.println(
                "What do you want to do?\n" + "1 - Add Watched Movie\n"
                    + "2 - Return to Main Menu");
            System.out.println("Enter choice:");

            try
            {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice != 1 && choice != 2)
                {
                    System.out.println("Please input a valid integer.");
                    choice = 0;
                }
            }
            catch (NumberFormatException e)
            {
                System.out
                    .println("Not an integer, please input a valid integer.");
                choice = 0;
            }
        }

        if (choice == 1)
        {
            return true;
        }
        else if (choice == 2)
        {
            return false;
        }
    }


    /**
     * Determines if the user wants to return to the main menu after adding
     * movies.
     * 
     * @return true if the user wants to continue looping; false otherwise
     */
    public boolean searchMoviesReturnPrompt()
    {
        int choice = 0;

        while (choice == 0)
        {
            System.out.println(
                "What do you want to do?\n" + "1 - Search Movies\n"
                    + "2 - Return to Main Menu");
            System.out.println("Enter choice:");

            try
            {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice != 1 && choice != 2)
                {
                    System.out.println("Please input a valid integer.");
                    choice = 0;
                }
            }
            catch (NumberFormatException e)
            {
                System.out
                    .println("Not an integer, please input a valid integer.");
                choice = 0;
            }
        }

        if (choice == 1)
        {
            return true;
        }
        else if (choice == 2)
        {
            return false;
        }
    }

}
