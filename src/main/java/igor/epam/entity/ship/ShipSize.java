package igor.epam.entity.ship;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by User on 27.07.2017.
 */
public enum ShipSize {
    SMALL,
    MEDIUM,
    LARGE;

    static List<ShipSize> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SHIP_SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static ShipSize randomSize()  {
        return VALUES.get(RANDOM.nextInt(SHIP_SIZE));
    }

    }
