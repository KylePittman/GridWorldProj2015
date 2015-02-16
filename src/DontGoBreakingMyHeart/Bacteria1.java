package DontGoBreakingMyHeart;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Kyle on 2/16/2015.
 */
public class Bacteria1 extends Bacteria {
    public Bacteria1(){setColor(Color.GREEN);}

    public void move()
    {
        if (findHeart()!=null)this.setDirection(this.getLocation().getDirectionToward(findHeart()));
        if (tooClose(getLocation())) setDirection(getLocation().getDirectionToward(findBloodCell()) + 180);
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location location = getLocation();
        Location next = location.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
    }

    public boolean tooClose(Location location){
        if (findBloodCell()==null) return false;
        Location cell = findBloodCell();
        if(Math.abs(location.getCol() - cell.getCol()) < 3 && Math.abs(location.getRow() - cell.getRow()) < 3) return true;
        return false;
    }

    public Location findBloodCell(){
        ArrayList<Location> locations = this.getGrid().getOccupiedLocations();
        for(int i = 0; i < locations.size(); i++)
        {
            Location loc = locations.get(i);
            if (this.getGrid().get(loc) instanceof WhiteBloodCellCritter)

                return loc;
        }
        return null;
    }


}
