/**
 * BlusterRunner.java   
 * 
 */
package Critters;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.awt.*;


public class BlusterRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        
     
        world.add(new Location(0,7), new Critter());
        world.add(new Location(0,8), new Critter());
        world.add(new Location(1,7), new Critter());
        world.add(new Location(1,8), new Critter());
        world.add(new Location(1,9), new Critter());
        world.add(new Location(2,7), new Critter());
        world.add(new Location(2,8), new Critter());
        world.add(new Location(2,9), new Critter());
        
        world.add(new Location(9,1), new Critter());
        world.add(new Location(9,2), new Critter());
        world.add(new Location(9,3), new Critter());
        world.add(new Location(8,0), new Critter());
        world.add(new Location(8,1), new Critter());
        world.add(new Location(8,2), new Critter()); 
        world.add(new Location(7,0), new Critter());
        world.add(new Location(7,1), new Critter());
        world.add(new Location(7,2), new Critter());
        
        
         world.add(new Location(0,9), new BlusterCritter(3));
         world.add(new Location(9, 0), new BlusterCritter(10));
        world.show();
    }
}