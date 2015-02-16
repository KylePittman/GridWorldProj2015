//Michaela Dinman
package SaveMyHeart;

import info.gridworld.actor.Actor;

import java.awt.*;

public class Heart extends Actor
{
    private static final Color DEFAULT_COLOR = Color.RED;

    public Heart()
    {
        setColor(DEFAULT_COLOR);
    }

    public Heart(Color heartColor)
    {
        setColor(heartColor);
    }

    public void act()
    {
        //literally nothing tho lol
    }
}
