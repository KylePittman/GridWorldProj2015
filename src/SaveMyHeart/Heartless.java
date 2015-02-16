//Michaela Dinman
package SaveMyHeart;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

public class Heartless
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        Bacteria janice = new Bacteria();
        world.add(new Location(1, 1), janice);
        Heart bob = new Heart();
        world.add(new Location(5, 5), bob);
        world.show();
    }
}