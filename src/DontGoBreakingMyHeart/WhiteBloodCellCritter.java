package DontGoBreakingMyHeart;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Kyle on 2/16/2015.
 */
public class WhiteBloodCellCritter extends Critter{

    public WhiteBloodCellCritter(){
        setColor(Color.YELLOW);
    }
    public void act()
    {
        if (getGrid() == null)
            return;
        ArrayList<Actor> actors = getActors();
        processActors(actors);
        ArrayList<Location> moveLocs = getMoveLocations();
        Location loc = selectMoveLocation(moveLocs);
        makeMove(loc);
    }

    public ArrayList<Actor> getActors(){
        return null;
    }
    public void processActors(ArrayList<Actor> actors)
    {

    }

    public ArrayList<Location> getMoveLocations()
    {
        return getGrid().getEmptyAdjacentLocations(getLocation());
    }

    public Location selectMoveLocation(ArrayList<Location> locs)
    {
        for (int i = locs.size()-1; i >= 0; i--) {
            if (!inBounds(locs.get(i))) locs.remove(i);
        }
        int n = locs.size();
        if (n == 0)
            return getLocation();
        int r = (int) (Math.random() * n);
        return locs.get(r);
    }

    public boolean inBounds(Location location){
        Location heart = findHeart();
        if(findHeart()!=null && Math.abs(location.getCol() - heart.getCol()) < 3 && Math.abs(location.getRow() - heart.getRow()) < 3) return true;
        return false;
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
