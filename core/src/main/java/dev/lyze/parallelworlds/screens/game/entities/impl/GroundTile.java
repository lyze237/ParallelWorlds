package dev.lyze.parallelworlds.screens.game.entities.impl;

import dev.lyze.parallelworlds.screens.game.Level;
import dev.lyze.parallelworlds.screens.game.entities.TileEntity;

public class GroundTile extends TileEntity {
    public GroundTile(float x, float y, float width, float height, Level level) {
        super(x, y, width, height, level);

        setHitbox(true);
    }
}
