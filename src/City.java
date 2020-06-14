public class City {
    private int cityId;
    private int xCoordinate;
    private int yCoordinate;

    public City(int cityId, int xCoordinate, int yCoordinate) {
        this.cityId = cityId;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getCityId() {
        return cityId;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public int getDistance(City city) {
        int deltaX = this.xCoordinate - city.getXCoordinate();
        int deltaY = this.yCoordinate - city.getYCoordinate();
        int distance = (int)Math.floor(Math.sqrt(deltaX * deltaX + deltaY * deltaY));
        return distance;
    }
}
