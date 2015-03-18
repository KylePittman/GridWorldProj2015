package Critters;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

import java.util.ArrayList;

/**
 * Created by Kyle on 3/17/2015.
 */
public class ChameleonKid extends ChameleonCritter {
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        if(getGrid().isValid(getLocation().getAdjacentLocation(getDirection())) && getGrid().get(getLocation().getAdjacentLocation(getDirection())) != null) actors.add(getGrid().get(getLocation().getAdjacentLocation(getDirection())));
        if(getGrid().isValid(getLocation().getAdjacentLocation(getDirection() + Location.HALF_CIRCLE)) &&getGrid().get(getLocation().getAdjacentLocation(getDirection() + Location.HALF_CIRCLE)) != null) actors.add(getGrid().get(getLocation().getAdjacentLocation(getDirection() + Location.HALF_CIRCLE)));
        return actors;
    }
}
