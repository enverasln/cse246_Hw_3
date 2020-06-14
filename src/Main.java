/*
    This program aims to find the most accurate optimum value for Traveling Salesman Problem.
    Authors: Enver Aslan & Tuna Cinsoy
    14.06.2020
 */
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
	    // Handling I/O Operations
    	File inputFile = new File("D:\\Database\\Coding Database\\IntelliJ-Workspace\\cse246_Hw_3\\src\\example-input-1.txt");
	    Scanner scanner = new Scanner(inputFile);
		BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Database\\Coding Database\\IntelliJ-Workspace\\cse246_Hw_3\\src\\output.txt"));

	    //Storing all cities in an ArrayList
	    ArrayList<City> allCities = new ArrayList<City>();

	    while(scanner.hasNextLine()) {
			int cityID = scanner.nextInt();
			int xCoordinate = scanner.nextInt();
			int yCoordinate = scanner.nextInt();
			allCities.add(new City(cityID, xCoordinate, yCoordinate));
		}


    }
}
