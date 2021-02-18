package simplelife.common.block.entities;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import simplelife.common.SimpleLife;

public class RedstoneLockEntity extends BlockEntity {

    public RedstoneLockEntity(BlockEntityType<?> type) {
        super(type);
    }

    public RedstoneLockEntity() {
        super(SimpleLife.REDSTONE_LOCK_ENTITY);
    }

}
