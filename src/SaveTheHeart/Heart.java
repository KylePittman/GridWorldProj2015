//Marcus Silcox
package SaveTheHeart;

import info.gridworld.actor.Actor;

import java.awt.*;

public class Heart extends Actor {
    private static final Color DEFAULT_COLOR = null;

    public Heart()
    {
        setColor(DEFAULT_COLOR);
    }

    public Heart(Color heartColor)
    {
        setColor(heartColor);
    }

    public void act()
    {}
}
