package igor.epam.runner;

import igor.epam.entity.ship.Pier;
import igor.epam.entity.ship.Port;
import igor.epam.threads.ShipCreator;

/**
 * Created by User on 27.07.2017.
 */
public class Runner {
    private static final String POPLE_UNLOADED = "People unloaded -> ";
    private static final String BOXES_UNLOADED = "Boxes unloaded -> ";
    private static final String CONTAINERS_UNLOADED = "Containers unloaded -> ";
    private static Port port = new Port();
    private static ShipCreator creator = new ShipCreator(port);
    private static Thread createShip;

    public static void main(String[] args) {

        for(int i= 0; i < 10; i++){
            createShip = new Thread(creator);
            try {
                Thread.sleep(500);
                createShip.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while(Thread.activeCount() != 2){

        }
        System.out.println(POPLE_UNLOADED + creator.getPeople());
        System.out.println(BOXES_UNLOADED + creator.getBoxes());
        System.out.println(CONTAINERS_UNLOADED + creator.getContainers());
    }


}
