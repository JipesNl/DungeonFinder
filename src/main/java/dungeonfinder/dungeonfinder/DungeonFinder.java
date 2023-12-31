package dungeonfinder.dungeonfinder;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DungeonFinder implements ModInitializer{
    public static final Logger LOGGER = LoggerFactory.getLogger("dungeonfinder");

    @Override
    public void onInitialize() {
        LOGGER.info("Dungeon Finder initialized");
    }
}
