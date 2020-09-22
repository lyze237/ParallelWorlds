package dev.lyze.parallelworlds.screens.game.map.properties;

import dev.lyze.parallelworlds.screens.game.entities.players.PlayerColor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlayerSpawnerMapProperties extends MapProperties {
    private PlayerColor player;
}
