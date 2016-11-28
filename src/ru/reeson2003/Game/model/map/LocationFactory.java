package ru.reeson2003.Game.model.map;

/**
 * Created by Тоня on 30.09.2016.
 */
public class LocationFactory {
    String name = "";
    String info = "";
    int width;
    int length;
    Position[][] positions;
    Location location;

    public LocationFactory(String name, String info, int width, int length) {
        if (name != null)
            this.name = name;
        if (info != null)
            this.info = info;
        if (width <=0 && length <=0)
            throw new IllegalArgumentException("Size of Location must be more than 0, but received : width = " + width
                                                + ", length = " + length);
        else {
            this.width = width;
            this.length = length;
        }
        positions = new Position[length][width];
        location = new Location();
        generatePositionsAndLinks();
        location.setName(this.name);
        location.setInfo(this.info);
        location.setWidth(this.width);
        location.setLength(this.length);
        location.setPositions(this.positions);
    }
    private void generatePositionsAndLinks() {
        for (int i = 0; i< length; i++)
            for (int j=0; j<width; j++) {
                positions[i][j] = new Position(j, i, name);
                positions[i][j].setLocation(this.location);
            }
        for (int i = 0; i< length; i++)
            for (int j = 0; j < width; j++) {
                if((j+1) < width) {
                    positions[i][j].setEast(positions[i][j+1]);
                    positions[i][j+1].setWest(positions[i][j]);
                }
                if((i+1) < length) {
                    positions[i][j].setSouth(positions[i+1][j]);
                    positions[i+1][j].setNorth(positions[i][j]);
                }
            }
    }
    public static Location getLocation(String name, String info, int width, int length) {
        return new LocationFactory(name, info, width, length).getLocation();
    }

    public Location getLocation() {
        return location;
    }
}
