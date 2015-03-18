//ChameleonCritter.java  

// Exercise #1:  Modify the processActors method in CameleonCritter 
//so that if the list of actors to process is empty, the color will darken

package Critters;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

//A ChameleonCritter</code> takes on the color of neighboring
//actors as it moves through the grid. 

public class ChameleonCritter extends Critter
{
	private static final double DARKENING_FACTOR = 0.05;
	public  ChameleonCritter()
	{
		setColor(Color.yellow);
	}
  
  //Randomly selects a neighbor and changes this critter's color to be the
 // same as that neighbor's. If there are no neighbors, the ChameleonCritter
 // darken
   public void processActors(ArrayList<Actor> actors)
  {
	  int n = actors.size();
	  if (n == 0)
	  {
		  darken();  //code found in the Flower class to darken
		  return;
	  }
	  int r = (int) (Math.random() * n);
	  Actor other = actors.get(r);
	  setColor(other.getColor());
  }

   
    //Darkens this critter's color by DARKENING_FACTOR.
    private void darken()
    {
	    Color c = getColor();
	    int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
	    int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
	    int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
	    setColor(new Color(red, green, blue));

    }
    
    //Turns towards the new location as it moves.
    public void makeMove(Location loc)
    {
        setDirection(getLocation().getDirectionToward(loc));
        super.makeMove(loc);
    }
}
