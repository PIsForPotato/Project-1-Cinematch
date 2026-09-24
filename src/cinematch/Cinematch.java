package cinematch;

import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 * The main Cinematch menu. Has the main menu and calls sub-menu processes
 * 
 * @author Alex Zhao
 * @version Sep 22, 2026
 */
public class Cinematch
{
    // ~ Fields ................................................................

    private boolean active = true;
    /**
     * List of movies watched by user, starts empty
     */
    public MovieList watchedMovies = new MovieList();
    /**
     * List of movies known by the program
     */
    public MovieList databaseMovies = new MovieList();
    private Scanner scanner = new Scanner(System.in);

    // ~ Constructors ..........................................................
    /**
     * Create a new Cinematch object.
     * 
     * @param databaseMovies
     *            the existing database of movies
     */
    public Cinematch(MovieList databaseMovies)
    {
        this.databaseMovies = databaseMovies;
    }

    // ~Public Methods ........................................................


    // ----------------------------------------------------------
    /**
     * Prompts the user for an integer for: 1 = addWatchedMovieProcess() 2 =
     * searchMovieProcess() 3 = listWatchedMovies() 4 = quit().
     */
    public void mainMenuPrompt()
    {
        if (active)
        {
            int choice = -1;

            while (choice == -1)
            {
                System.out.println(
                    "----------------------------------------------------------\n"
                        + "What do you want to do?\n"
                        + "1 - Add Watched Movie\n"
                        + "2 - List Watched Movies\n" + "3 - Search Movies\n"
                        + "4 - Quit");
                System.out.print("Enter choice: ");

                try
                {
                    choice = Integer.parseInt(scanner.nextLine());
                }
                catch (NumberFormatException e)
                {
                    System.out.println(
                        "Not an integer, please input a valid integer.");
                    choice = -1;
                }

            }

            switch (choice)
            {
                case 1:
                    addWatchedMovieProcess();
                    break;
                case 2:
                    listWatchedMovies();
                    mainMenuPrompt();
                    break;
                case 3:
                    searchMovieProcess();
                    break;
                case 4:
                    quit();
                    break;
                default:
                    System.out.println("Please input a valid integer.");
                    mainMenuPrompt();
                    break;
            }

        }

    }


    // ----------------------------------------------------------
    /**
     * Prints out watched list.
     */
    public void listWatchedMovies()
    {
        System.out.print("----------------------------------------------------------\n");
        if (watchedMovies.isEmpty())
        {
            System.out.println("No watched movies yet! Try adding some!");
        }
        else
        {
            watchedMovies.printList();
        }
    }


    // ----------------------------------------------------------
    /**
     * Stops program execution
     */
    public void quit()
    {
        System.out.println(
            "----------------------------------------------------------\n"
                + "Thanks for using Cinematch!");
        active = false;
    }

    // ~Private Methods ........................................................


    // ----------------------------------------------------------
    /**
     * Using a CinematchSubmenu, runs all the functions necessary for the Add
     * Watched Movie menu
     */
    private void addWatchedMovieProcess()
    {
        boolean looping = true;
        CinematchSubmenu addWatchedMovieMenu =
            new CinematchSubmenu(databaseMovies, watchedMovies, scanner);

        while (looping)
        {
            Movie newMovie = null;
            addWatchedMovieMenu.genrePrompt();
            addWatchedMovieMenu.titlePrompt();
            newMovie = addWatchedMovieMenu.createMovie();

            if (newMovie == null)
            {
                System.out.println("Movie was invalid. Could not be added.");
            }
            else
            {
                System.out.println("Movie was successfully added.");
                watchedMovies.addMovie(newMovie);
            }

            looping = addWatchedMovieMenu.addMoviesReturnPrompt();

        }

        mainMenuPrompt();
    }


    // ----------------------------------------------------------
    /**
     * Using a CinematchSubmenu, runs all the functions necessary for the Search
     * Movie menu
     */
    private void searchMovieProcess()
    {
        boolean looping = true;
        int searchType = 0;
        CinematchSubmenu searchMovieMenu =
            new CinematchSubmenu(databaseMovies, watchedMovies, scanner);

        while (looping)
        {
            MovieList newMovieList = null;
            searchType = searchMovieMenu.searchPrompt();

            if (searchType == 1)
            {
                searchMovieMenu.genrePrompt();
            }
            else if (searchType == 2)
            {
                searchMovieMenu.titlePrompt();
            }

            newMovieList = searchMovieMenu.searchMovies();

            if (newMovieList == null)
            {
                System.out
                    .println("Movie list was invalid. Could not be processed.");
            }
            else
            {
                System.out.println(
                    "----------------------------------------------------------\n"
                        + "The following unwatched movies meet your criteria: ");
                if (newMovieList.isEmpty())
                {
                    System.out.println("No movies met your search criteria.");
                }
                else
                {
                    newMovieList.printList();
                }
            }

            looping = searchMovieMenu.searchMoviesReturnPrompt();
        }

        mainMenuPrompt();
    }


    // ----------------------------------------------------------
    /**
     * Runs the main loop
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        MovieList database = MovieDatabase.buildDatabase();
        Cinematch cinematch = new Cinematch(database);
        cinematch.mainMenuPrompt();
    }

}
