package Critters;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.util.ArrayList;

/**
 * Created by Kyle on 3/17/2015.
 */
public class QuickCrab extends CrabCritter{

    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        int[] dirs =
                { Location.LEFT, Location.RIGHT };
        for (Location loc : getLocationsInDirections(dirs))
            if (getGrid().get(loc) == null)
            {
                locs.add(loc);
                System.out.println(loc.toString() + "     ///");
                System.out.println(locs.get(locs.size()-1).getAdjacentLocation(getLocation().getDirectionToward(loc)).toString());
                if (getGrid().isValid(locs.get(locs.size()-1).getAdjacentLocation(getLocation().getDirectionToward(loc))) && getGrid().get(locs.get(locs.size()-1).getAdjacentLocation(getLocation().getDirectionToward(loc))) == null)
                {
                    System.out.println("got here");
                    locs.add(locs.get(locs.size() - 1).getAdjacentLocation(getLocation().getDirectionToward(loc)));
                    locs.remove(locs.size()-2);
                }
            }
        for(Location loc: locs){
            System.out.println(loc.toString());
        }
        return locs;
    }
}
