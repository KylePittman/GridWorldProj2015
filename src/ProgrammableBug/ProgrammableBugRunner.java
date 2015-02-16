//Kyle Pittman 1/12/2015.
package ProgrammableBug;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;


/*
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class ProgrammableBugRunner
{
    public static void main(String[] args)
    {
        int[] turns = {6,6,2,6,6,6};
        int[] steps = {6,3,3,3,3,6};
        ActorWorld world = new ActorWorld();
        ProgrammableBug alice = new ProgrammableBug(steps, turns);
        alice.turn();
        alice.setColor(Color.RED);
        world.add(new Location(7, 8), alice);
        world.show();
    }
}
