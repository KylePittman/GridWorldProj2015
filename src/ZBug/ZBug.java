//Kyle Pittman 1/10/2015.
package ZBug;

import info.gridworld.actor.Bug;

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

import info.gridworld.actor.Bug;

/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class ZBug extends Bug
{
    private int steps;
    private int sideLength;
    boolean[] part = new boolean[3];

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public ZBug(int length)
    {
        part[0] = true;
        part[1] = false;
        part[2] = false;
        steps = 0;
        sideLength = length;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if(canMove()) {
            if (part[0]) {
                if (steps < sideLength) {
                    move();
                    steps++;
                } else {
                    turn();
                    turn();
                    turn();
                    steps = 0;
                    part[0] = false;
                    part[1] = true;
                }
            }
            if (part[1]) {
                if (steps < sideLength) {
                    move();
                    steps++;
                } else {
                    turn();
                    turn();
                    turn();
                    turn();
                    turn();
                    steps = 0;
                    part[1] = false;
                    part[2] = true;
                }
            }
            if (part[2]){
                if (steps < sideLength) {
                    move();
                    steps++;
                } else {
                    part[2] = false;
                }
            }
        }
    }
}

