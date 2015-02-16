//Marcus Silcox
package SaveTheHeart;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.*;
import java.util.ArrayList;

public class Bacteria extends Actor
{

    public Bacteria()
    {
        setColor(Color.BLACK);
    }

    public Bacteria(Color bugColor)
    {
        setColor(bugColor);
    }


    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }

    public void directionSet(){
        Location heart = findHeart();
        Location loc = getLocation();
        int HeartX = heart.getCol();
        int HeartY = heart.getRow();

        int BacX = loc.getCol();
        int BacY = loc.getRow();


        if (BacX == HeartX && BacY < HeartY)
        {
            this.setDirection(180);
        }
        else if (BacX < HeartX && BacY == HeartY)
        {
            this.setDirection(90);
        }
        else if (BacX == HeartX && BacY > HeartY)
        {
            this.setDirection(0);
        }
        else if (BacX > HeartX && BacY == HeartY)
        {
            this.setDirection(270);
        }
        else if (BacX < HeartX && BacY < HeartY)
        {
            this.setDirection(135);
        }
        else if (BacX > HeartX && BacY < HeartY)
        {
            this.setDirection(225);
        }
        else if (BacX > HeartX && BacY > HeartY)
        {
            this.setDirection(315);
        }
        else if (BacX < HeartX && BacY > HeartY)
        {
            this.setDirection(45);
        }
    }

    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        this.directionSet();
        Location location = getLocation();
        Location next = location.getAdjacentLocation(getDirection());
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
        ArrayList<Location> Locations = new ArrayList<Location>();
        Locations = this.getGrid().getOccupiedLocations();

        for(int i = 0; i < Locations.size(); i++)
        {
            Location loc = Locations.get(i);
            if (this.getGrid().get(loc) instanceof Heart && !this.getGrid().get(loc).getColor().equals(Color.BLACK))
                return loc;
        }
        return null;
    }

    public void act()
    {
        if(findHeart() != null) {
            ArrayList<Location> occ = new ArrayList<Location>();

            occ = this.getGrid().getOccupiedAdjacentLocations(this.getLocation());

            for (Location loc : occ)
            {
                if(this.getGrid().get(loc) instanceof Heart)
                {
                    this.getGrid().get(loc).setColor(Color.BLACK);
                }
            }

            if (canMove())
                move();
            else
                turn();
        }
    }
}