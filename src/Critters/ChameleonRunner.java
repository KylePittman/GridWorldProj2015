 
package Critters;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

 
/**
 * This class runs a world that contains chameleon critters. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class ChameleonRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Location(5, 8), new ChameleonCritter());
        world.show();
    }
}