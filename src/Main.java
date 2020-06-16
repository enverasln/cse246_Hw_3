/*
    This program aims to find the most accurate optimum value for Traveling Salesman Problem.
    Authors: Enver Aslan & Tuna Cinsoy
    14.06.2020
 */
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
		//BufferedWriter writer = new BufferedWriter(new FileWriter(".\\data\\"+args[1]));

	    //Storing all cities in an ArrayList
	    ArrayList<City> allCities = Utility.readFromFile(args[0]);

	    Algorithm algorithm = new Algorithm(allCities);


	    //algorithm.printPath(algorithm.getNearestNeighbourPath());
	    algorithm.twoOptionPath();

		Utility.writeFile(algorithm.toStringTwoOpt(), args[1]);


    }
}
