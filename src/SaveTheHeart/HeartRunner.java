//Marcus Silcox
package SaveTheHeart;

import DontGoBreakingMyHeart.*;
import DontGoBreakingMyHeart.Heart;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

public class HeartRunner {

        public static void main(String[] args)
        {
            ActorWorld world = new ActorWorld();
            SaveTheHeart.Bacteria Lincoln = new SaveTheHeart.Bacteria();
            world.add(new Location(2, 1), Lincoln);
            SaveTheHeart.Heart Park = new SaveTheHeart.Heart();
            world.add(new Location(6,4), Park);
            world.show();
        }

}
