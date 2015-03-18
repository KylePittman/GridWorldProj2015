package Critters;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Kyle on 3/17/2015.
 */
public class BlusterCritter extends Critter {

    private static final double CHANGING_FACTOR = 0.05;
    public int socialAbility;

    public BlusterCritter(int c){
        socialAbility = c;
    }


    public ArrayList<Actor> getActors()
    {
        return getNeighbors(getLocation());
    }

    public void processActors(ArrayList<Actor> actors)
    {
        int n = actors.size();
        if (n < socialAbility)
        {
            darken();  //code found in the Flower class to darken
        }
        else
        {
            brighten();
        }
    }

    public ArrayList<Location> getValidLocations(Location loc){
        ArrayList<Location> corners = new ArrayList<Location>();
        for (int i = 0; i < 4; i++) {
            if(getGrid().isValid(getLocation().getAdjacentLocation(45 + i * 90)))corners.add(getLocation().getAdjacentLocation(45 + i * 90));
        }
        if(corners.size() < 1) return null;
        ArrayList<Location> validLocs = new ArrayList<Location>();
        validLocs = getGrid().getValidAdjacentLocations(corners.get(0));
        if(corners.size() > 1){
            for (int i = 1; i < corners.size(); i++) {
                ArrayList<Location> newVal = new ArrayList<Location>();
                int alSize = validLocs.size();
                newVal = getGrid().getValidAdjacentLocations(corners.get(i));
                for (int j = 0; j < newVal.size(); j++) {
                    boolean alreadyFound = false;
                    for (int k = 0; k < alSize && !alreadyFound; k++) {
                        if(validLocs.get(k).compareTo(newVal.get(j)) == 0) alreadyFound = true;
                    }
                    if(!alreadyFound) validLocs.add(newVal.get(j));
                }
            }

        }
        return validLocs;
    }
    public ArrayList<Actor> getNeighbors(Location loc)
    {
        ArrayList<Actor> neighbors = new ArrayList<Actor>();
        for (Location neighborLoc : getOccupiedAdjacentLocations(loc))
            neighbors.add(getGrid().get(neighborLoc));
        return neighbors;
    }

    public ArrayList<Location> getOccupiedAdjacentLocations(Location loc)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        for (Location neighborLoc : getValidLocations(loc))
        {
            if (getGrid().get(neighborLoc) != null)
                locs.add(neighborLoc);
        }
        return locs;
    }

    private void darken()
    {
        Color c = getColor();
        int red = (int) (c.getRed() * (1 - CHANGING_FACTOR));
        int green = (int) (c.getGreen() * (1 - CHANGING_FACTOR));
        int blue = (int) (c.getBlue() * (1 - CHANGING_FACTOR));
        System.out.println("Red: " + red + "\nGreen: " + green + "\nBlue: " + blue);
        setColor(new Color(red, green, blue));
    }

    private void brighten()
    {
        Color c = getColor();
        if((int) (c.getRed() * (1 + CHANGING_FACTOR)) > 255 || (int) (c.getGreen() * (1 + CHANGING_FACTOR)) > 255 || (int) (c.getBlue() * (1 + CHANGING_FACTOR)) > 255) return;

        int red = c.getRed();

        if(red + 1 < (int) (c.getBlue() * (1 + CHANGING_FACTOR)))
            red = (int) (c.getBlue() * (1 + CHANGING_FACTOR));
        else
            red = c.getBlue() + 1;

        int green = c.getGreen();

        if(green + 1 < (int) (c.getBlue() * (1 + CHANGING_FACTOR)))
            green = (int) (c.getBlue() * (1 + CHANGING_FACTOR));
        else
            green = c.getBlue() + 1;
        int blue = c.getBlue();

        if(blue + 1 < (int) (c.getBlue() * (1 + CHANGING_FACTOR)))
            blue = (int) (c.getBlue() * (1 + CHANGING_FACTOR));
        else
            blue = c.getBlue() + 1;

        System.out.println("Red: " + red + "\nGreen: " + green + "\nBlue: " + blue);
        setColor(new Color(red, green, blue));

    }
}
