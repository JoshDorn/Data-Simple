//Simple Movie Database
import java.util.*;
import java.io.*;
public class Lab7
{
	public static void main(String [] args) throws IOException
	{
		MovieDB movies = new MovieDB(10);	// Create MovieDB object.
		loadData(movies);			// input movie data from file
		getCommands(movies);			// interact with user 
		saveData(movies);			// save movie data back to file
	}

	public static void loadData(MovieDB movies) throws IOException
	{
		// Note the syntax below for creating a Scanner to a file
		Scanner S = new Scanner(new FileInputStream("movieFile.txt"));
		
		int numOfMovies = Integer.parseInt(S.nextLine());
		for (int i = 0; i < numOfMovies; i++)
		{
			String movieName = S.nextLine();
			String movieDirector = S.nextLine();
			String movieStudio = S.nextLine();
			String movieGross = S.nextLine();
			double movieMoney = Double.parseDouble(movieGross);
		
			Movie stuff = new Movie (movieName, movieDirector, movieStudio, movieMoney);
			movies.addMovie(stuff);
		}
	}

	public static void getCommands(MovieDB movies)
	{
		Scanner inScan = new Scanner(System.in);
		System.out.println("Enter your choice:");
		System.out.println("1. List movies");
		System.out.println("2. Add new movie");
		System.out.println("3. Find movie");
		System.out.println("4. Quit");
		String choice = inScan.nextLine();
		while (true)
		{
			Movie temp;
			if (choice.equals("1"))
			{
				System.out.println(movies.toString());
			}
			else if (choice.equals("2"))
			{
				System.out.println("What is the title of the movie?");
					String title = inScan.nextLine();
				System.out.println("Who is the director?");
					String dir = inScan.nextLine();
				System.out.println("What was the studio?");
					String stud = inScan.nextLine();
				System.out.println("What was the movie gross?");
					String gross = inScan.nextLine();
					double money = Double.parseDouble(gross);
				Movie stuff = new Movie (title, dir, stud, money);
			
			movies.addMovie(stuff);
			}
			else if (choice.equals("3"))
			{
	
				System.out.println("What is the title of the movie you are looking for?");
				Scanner find = new Scanner(System.in);
				String title = (find.nextLine());
				Movie mov = movies.findMovie(title);
				if (mov != null){
						System.out.println(mov); 
					}
					else {
						System.out.println("The movie was not found!");				
					}
				}
			else
			{
				System.out.println("Good-bye");
				break;  // any other value -- quit
			}
			System.out.println("Enter your choice:");
			System.out.println("1. List movies");
			System.out.println("2. Add new movie");
			System.out.println("3. Find movie");
			System.out.println("4. Quit");
			choice = inScan.nextLine();
		}
	}

	public static void saveData(MovieDB movies) throws IOException
	{
		PrintWriter P = new PrintWriter("movieFile.txt");
		P.print(movies.toStringFile());
		P.close();
	}
}




