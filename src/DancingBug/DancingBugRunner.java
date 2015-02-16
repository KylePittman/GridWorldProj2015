//Kyle Pittman 1/11/2015.
package DancingBug;

import boxBug.BoxBug;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.*;


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

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class DancingBugRunner
{
    public static void main(String[] args)
    {
        int[] turns = {2,4,6,2,5,5,7,3,4,5,8,2,2,5,1,2,3,2,2,4,5,5,4,6,5,3,7,8,2,3,2,4,4,5,4,3,2,2,3,43,6,7,5,4,3,3,2};
        ActorWorld world = new ActorWorld();
        DancingBug alice = new DancingBug(4, turns);
        alice.setColor(Color.RED);
        world.add(new Location(7, 8), alice);
        world.show();
    }
}
