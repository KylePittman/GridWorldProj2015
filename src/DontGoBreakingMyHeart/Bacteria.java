package DontGoBreakingMyHeart;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;

public class Bacteria extends Actor {

    public Bacteria()
    {
        setColor(Color.BLACK);
    }

    public Bacteria(Color bacteriaColor)
    {
        setColor(bacteriaColor);
    }

    public void act()
    {
        if(findHeart() != null) {
            ArrayList<Location> occ = this.getGrid().getOccupiedAdjacentLocations(this.getLocation());

            for (Location loc : occ)if(this.getGrid().get(loc) instanceof Heart)this.getGrid().get(loc).setColor(Color.BLACK);

            if (canMove())
                move();
        }
    }

    public void move()
    {
        if(findHeart()!=null)this.setDirection(this.getLocation().getDirectionToward(findHeart()));
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location location = getLocation();
        Location next = location.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
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
        ArrayList<Location> locations = this.getGrid().getOccupiedLocations();
        for(int i = 0; i < locations.size(); i++)
        {
            Location loc = locations.get(i);
            if (this.getGrid().get(loc) instanceof Heart && !this.getGrid().get(loc).getColor().equals(Color.BLACK))
                return loc;
        }
        return null;
    }
}