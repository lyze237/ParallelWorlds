package dev.lyze.parallelworlds.screens.game.map.properties;

import dev.lyze.parallelworlds.screens.game.entities.Entity;
import dev.lyze.parallelworlds.screens.game.entities.impl.BigCoinTile;
import dev.lyze.parallelworlds.screens.game.entities.impl.EnemyBarrierTile;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GenericEntitySpawnerMapProperties extends MapProperties {
    private Types entity;
    private boolean invertedGravity;

    public enum Types {
        BigCoin(BigCoinTile.class), EnemyBarrier(EnemyBarrierTile.class);

        @Getter
        private final Class<? extends Entity> entityClass;

        Types(Class<? extends Entity> entityClass) {
            this.entityClass = entityClass;
        }
    }
}
