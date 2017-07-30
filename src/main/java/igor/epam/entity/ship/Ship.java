package igor.epam.entity.ship;

/**
 * Created by User on 27.07.2017.
 */
public class Ship {

    private ShipSize size;
    private LoadType type;
    private int loadValue;
    private int shipNumber;
    public Ship(ShipSize size ,int loadValue, int shipNumber){
        this.shipNumber = shipNumber;
        this.size = size;
        this.loadValue = loadValue;
    }

    public int getShipNumber() {
        return shipNumber;
    }

    public ShipSize getSize() {
        return size;
    }

    public int getLoadValue() {
        return loadValue;
    }

    public LoadType getType() {
        switch (size){
            case SMALL:
                type = LoadType.PEOPLE;
                break;
            case MEDIUM:
                type = LoadType.BOXES;
                break;
            case LARGE:
                type = LoadType.CONTAINERS;
                break;
        }
        return type;
    }
}
