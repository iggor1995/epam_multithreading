package igor.epam.generator;

import igor.epam.entity.ship.ShipSize;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by User on 27.07.2017.
 */
public class RandomGenerator {

    public Object getRandom(Type type){
        switch (type){
            case LOAD:
                return getRandomLoad();
            case SIZE:
                return getRandomSize();
            case UNLOADINGSPEED:
                return getRandomSpeed();

        }
        return null;
    }
    private int getRandomSpeed(){
        Random random = new Random();
        int rnd = random.nextInt(20) + 1;
        return rnd;
    }
    private int getRandomLoad(){
        Random random = new Random();
        int rnd = random.nextInt(10) + 1;
        return rnd;
    }
    private ShipSize getRandomSize(){
        List<ShipSize> values = Arrays.asList(ShipSize.values());
        int SHIP_SIZE = values.size();
        Random RANDOM = new Random();
        return values.get(RANDOM.nextInt(SHIP_SIZE));

    }
}
