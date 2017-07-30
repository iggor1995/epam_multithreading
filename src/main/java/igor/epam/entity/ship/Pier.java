package igor.epam.entity.ship;

import java.util.Random;

/**
 * Created by User on 27.07.2017.
 */
public class Pier {
    private boolean inUse;
    private int unloadingSpeed;
    private int pierNum;
    private static final int BOUND = 10;
    public Pier(int pierNum, int unloadingSpeed) {
        this.pierNum = pierNum;
        this.unloadingSpeed = unloadingSpeed;
        setVelocity();
    }

    public int getPierNum() {
        return pierNum;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public int getUnloadingSpeed() {
        return unloadingSpeed;
    }

    public boolean isInUse() {
        return inUse;
    }
    private int setVelocity(){
        Random random = new Random();
        return random.nextInt(BOUND) + 1;
    }
}
