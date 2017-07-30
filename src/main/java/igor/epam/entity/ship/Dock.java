package igor.epam.entity.ship;

import igor.epam.generator.RandomGenerator;
import igor.epam.generator.Type;

import javax.xml.bind.Marshaller;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 27.07.2017.
 */
public class Dock {
    private ShipSize size;
    private List<Pier> pierList = new ArrayList() ;
    private RandomGenerator randomGenerator = new RandomGenerator();
    public Dock(ShipSize size){
        this.size = size;
        pierList.add(new Pier(1, (Integer) randomGenerator.getRandom(Type.UNLOADINGSPEED)));
        pierList.add(new Pier(2, (Integer) randomGenerator.getRandom(Type.UNLOADINGSPEED)));
    }

    public List<Pier> getPierList() {
        return pierList;
    }
    @Override
    public String toString() {
        return  size + " Dock. ";
    }
}
