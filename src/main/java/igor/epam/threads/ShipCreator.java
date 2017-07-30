package igor.epam.threads;

import igor.epam.entity.ship.*;
import igor.epam.generator.RandomGenerator;
import igor.epam.generator.Type;
import java.util.concurrent.Semaphore;

/**
 * Created by User on 27.07.2017.
 */
public class ShipCreator extends Thread {
    private static final String NEW_SHIP_CREATED = "new ship number %s has been CREATED -- %s. Load valude is %s \n";
    private static final String PIER_INUSE = "%s pier %s is in use. PIER speed is %s \n";
    private static final String UNLOAD_STARTED = "ship number - %s STATUS -> UNLOADING\n";
    private static final String FINISHED = "ship number %s STATUS -> GONE!. Dock %s: Pier %s is free to use\n\n";
    final Semaphore semaphore = new Semaphore(2);
    private int number = 0;
    private RandomGenerator generator = new RandomGenerator();
    private ShipSize shipSize;
    private Port port = new Port();
    private int boxes;
    private int containers;
    private int people;

    public ShipCreator(Port port){
        this.port = port;
    }

    @Override
    public void run() {
        shipSize = (ShipSize) generator.getRandom(Type.SIZE);
        number++;
        unloadShip(new Ship((ShipSize) generator.getRandom(Type.SIZE), ((Integer) generator.getRandom(Type.LOAD)), number));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void unloadShip(Ship ship){
        System.out.printf(NEW_SHIP_CREATED, ship.getShipNumber(), ship.getType(), ship.getLoadValue());
        switch (ship.getSize()){
            case SMALL:
                unloadingSmall(port.getSmallDock(), ship.getShipNumber());
                people += ship.getLoadValue();
                break;
            case MEDIUM:
                unloadingMedium(port.getMediumDock(), ship.getShipNumber());
                boxes += ship.getLoadValue();
                break;
            case LARGE:
                unloadingLarge(port.getLargeDock(), ship.getShipNumber());
                containers += ship.getLoadValue();
                break;
        }
    }
    private void unloadingSmall(Dock dock, int number){
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        unload(dock, number);
        semaphore.release();
    }
    private void unloadingMedium(Dock dock, int number){
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        unload(dock, number);
        semaphore.release();

    }
    private void unloadingLarge(Dock dock, int number){
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        unload(dock, number);
        semaphore.release();
    }
    private void unload(Dock dock, int number){
        for(Pier pier : dock.getPierList()) {
            if(!pier.isInUse()) {
                pier.setInUse(true);
                System.out.printf(UNLOAD_STARTED, number);
                System.out.printf(PIER_INUSE, dock.toString(),  pier.getPierNum(), pier.getUnloadingSpeed());
                try {
                    Thread.sleep(pier.getUnloadingSpeed() * 300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pier.setInUse(false);
                System.out.printf(FINISHED, number, dock.toString(), pier.getPierNum());
                break;
            }
        }
    }

    public int getBoxes() {
        return boxes;
    }

    public int getContainers() {
        return containers;
    }

    public int getPeople() {
        return people;
    }
}
