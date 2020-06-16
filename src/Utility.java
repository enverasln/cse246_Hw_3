import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Utility {


    public static ArrayList<City> readFromFile(String path) throws FileNotFoundException {
        ArrayList<City> allCities = new ArrayList<City>();
        File inputFile = new File(path);
        Scanner scanner = new Scanner(inputFile);
        while(scanner.hasNextInt()) {
            int cityID = scanner.nextInt();
            int xCoordinate = scanner.nextInt();
            int yCoordinate = scanner.nextInt();
            City newCity = new City(cityID, xCoordinate, yCoordinate);
            allCities.add(newCity);

        }
        scanner.close();
        return allCities;
    }

    public static void writeFile(String str, String path) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(str);

        writer.close();
    }
}
