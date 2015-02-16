//Michaela Dinman
package SaveMyHeart;


import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;

public class Bacteria extends Actor{
    public Bacteria()
    {
        setColor(Color.RED);
    }

    public Bacteria(Color bacteriaColor)
    {
        setColor(bacteriaColor);
    }

    public void act()
    {
        if (canMove())
            move();
        else
            turn();
    }

    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }

    public void move()
    {
        Location heart = findHeart();
        setDirection(getLocation().getDirectionToward(heart));
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
    }

    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        return (neighbor == null);
    }

    public Location findHeart(){
        ArrayList<Location> locations = new ArrayList<Location>();
        locations = this.getGrid().getOccupiedLocations();

        for(int i = 0; i < locations.size(); i++)
        {
            Location loc = locations.get(i);
            if (this.getGrid().get(loc) instanceof Heart && !this.getGrid().get(loc).getColor().equals(Color.BLACK))
                return loc;
        }
        return null;
    }
}