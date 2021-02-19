package simplelife.common.block.furniture;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import simplelife.common.util.BoxRotator;

public class BasicChair extends BasicDirectionalFurniture {

    public static String identifier = "basic_chair";

    public BasicChair(Settings settings) {
        super(settings);
    }
    @Override
    public VoxelShape getOutlineShape(BlockState blockState, BlockView blockView, BlockPos blockPos, ShapeContext entityContext) {
        VoxelShape v = VoxelShapes.cuboid((2F / 16F), 0, (2F / 16F), (14F / 16F), 1, (15F / 16F));
        Direction direction = blockState.get(Properties.HORIZONTAL_FACING);
        switch (direction) {
            case NORTH:
                return v;
            case SOUTH:
                return VoxelShapes.cuboid(BoxRotator.rotateHorizontal(v.getBoundingBox(), 180));
            case EAST:
                return VoxelShapes.cuboid(BoxRotator.rotateHorizontal(v.getBoundingBox(), 270));
            case WEST:
                return VoxelShapes.cuboid(BoxRotator.rotateHorizontal(v.getBoundingBox(), 90));
        }
        return v;
    }


}
