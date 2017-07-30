package igor.epam.entity.ship;

/**
 * Created by User on 27.07.2017.
 */
public class Port {
    private Dock LargeDock = new Dock(ShipSize.LARGE);
    private Dock MediumDock = new Dock(ShipSize.MEDIUM);
    private Dock SmallDock = new Dock(ShipSize.SMALL);

    public Dock getLargeDock() {
        return LargeDock;
    }

    public Dock getMediumDock() {
        return MediumDock;
    }

    public Dock getSmallDock() {
        return SmallDock;
    }
}
