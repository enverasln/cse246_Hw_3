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
    	File inputFile = new File(".\\data\\"+args[0]);
	    Scanner scanner = new Scanner(inputFile);
		BufferedWriter writer = new BufferedWriter(new FileWriter(".\\data\\"+args[1]));

	    //Storing all cities in an ArrayList
	    ArrayList<City> allCities = new ArrayList<City>();

	    while(scanner.hasNextLine()) {
			int cityID = scanner.nextInt();
			int xCoordinate = scanner.nextInt();
			int yCoordinate = scanner.nextInt();
			City newCity = new City(cityID, xCoordinate, yCoordinate);
			allCities.add(newCity);

			System.out.println(newCity.toString());
		}

	    int [][] adjMatrix = new int[allCities.size()][allCities.size()];

    }
}
