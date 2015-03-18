//Kyle Pittman 3/18/2015.
package Critters;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.awt.*;

public class Zoo {
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Location(5, 8), new ChameleonCritter());
        world.add(new Location(1, 4), new Rock(Color.RED));
        world.add(new Location(7, 2), new Rock(Color.YELLOW));
        world.add(new Location(4, 4), new ChameleonKid());
        world.add(new Location(5, 9), new ChameleonKid());
        world.add(new Location(0, 9), new BlusterCritter(3));
        world.add(new Location(9, 0), new BlusterCritter(10));
        world.add(new Location(6, 5), new Bug());
        world.add(new Location(5, 3), new Bug());
        world.add(new Location(4, 5), new QuickCrab());
        world.add(new Location(6, 1), new QuickCrab());
        world.add(new Location(7, 4), new QuickCrab());
        world.add(new Location(4, 6), new RockHound());
        world.add(new Location(0, 8), new RockHound());
        world.show();
    }
}
