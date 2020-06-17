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

    public long getDistance(City city) {
        long deltaX = this.xCoordinate - city.getXCoordinate();
        long deltaY = this.yCoordinate - city.getYCoordinate();
        long distance = (int)Math.round(Math.sqrt(deltaX * deltaX + deltaY * deltaY));
        return distance;
    }

    @Override
    public String toString() {
        return String.format("City-%d (%d, %d)", cityId, xCoordinate, yCoordinate);
    }
}
