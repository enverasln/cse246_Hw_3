import java.util.ArrayList;

public class Algorithm {
    private ArrayList<City> allCities;
    private ArrayList<City> nearestNeighbourPath;
    private ArrayList<City> twoOptPath;
    public Algorithm(ArrayList<City> allCities) {
        this.allCities = allCities;
        nearestNeighbourPath = new ArrayList<>();
        twoOptPath = new ArrayList<>();
        nnPath();
    }

    // This function will create a path according to nearest neighbour algorithm
    private void nnPath() {
        City currentCity = allCities.remove(0);
        City closestCity = allCities.get(0);

        long distance;

        nearestNeighbourPath.add(currentCity);

        while (allCities.size() != 0) {
            distance = Integer.MAX_VALUE;

            for(City city: allCities) {

                if(currentCity.getDistance(city) < distance) {
                    distance = currentCity.getDistance(city);
                    closestCity = city;
                }
            }

            currentCity = closestCity;
            allCities.remove(closestCity);
            nearestNeighbourPath.add(currentCity);
        }
        //nearestNeighbourPath.add(nearestNeighbourPath.get(0));
    }

    public ArrayList<City> getNearestNeighbourPath() {
        return nearestNeighbourPath;
    }

    public void twoOptionPath() {
        long bestLength = getPathLength(nearestNeighbourPath);
        ArrayList swappedPath;
        int swaps = 0;
        do {
            for(int i = 1; i < nearestNeighbourPath.size() - 2; i++) {
                for(int j = i+1; j < nearestNeighbourPath.size() - 1; j++) {

                    long distanceA = nearestNeighbourPath.get(i).getDistance(nearestNeighbourPath.get(i-1)) +
                            nearestNeighbourPath.get(j+1).getDistance(nearestNeighbourPath.get(j));

                    long distanceB = nearestNeighbourPath.get(i).getDistance(nearestNeighbourPath.get(j+1)) +
                            nearestNeighbourPath.get(i-1).getDistance(nearestNeighbourPath.get(j));

                    if (distanceA > distanceB) {
                        swappedPath = swap(i, j);
                        long swappedPathLength = getPathLength(swappedPath);

                        if (swappedPathLength < bestLength) {
                            swaps++;
                            nearestNeighbourPath = swappedPath;
                            bestLength = swappedPathLength;
                        }
                    }
                }
            }
        } while (swaps == 0);
    }

    public ArrayList<City> swap(int i, int j) {
        ArrayList<City> swapPath = new ArrayList<>();

        for (int k = 0; k <= i-1; k++) {
            swapPath.add(nearestNeighbourPath.get(k));
        }

        int d = 0;
        for (int k = i; k<=j; k++) {
            swapPath.add(nearestNeighbourPath.get(j-d));
            d++;
        }

        int size = nearestNeighbourPath.size();

        for (int k = j+1; k < size; k++) {
            swapPath.add(nearestNeighbourPath.get(k));
        }

        return swapPath;
    }

    public long getPathLength(ArrayList<City> cities) {
        int totalDistance = 0;
        for(int i = 1; i < cities.size(); i++) {
            totalDistance += cities.get(i-1).getDistance(cities.get(i));
        }
        return totalDistance;
    }

    public void printPath(ArrayList<City> cities) {
        for(City city: cities) {
            System.out.println(city.toString());
        }
    }

    public String toStringTwoOpt() {
        String str = String.format("%d\n", getPathLength(nearestNeighbourPath) +
                nearestNeighbourPath.get(nearestNeighbourPath.size() - 1).getDistance(nearestNeighbourPath.get(0)));

        for(City city: nearestNeighbourPath) {
            str+=String.format("%d\n", city.getCityId());
        }

        return str;
    }

}
