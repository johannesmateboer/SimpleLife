package simplelife.common.block.furniture;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import simplelife.common.util.BoxRotator;

public class BasicDirectionalFurniture extends HorizontalFacingBlock {

    public BasicDirectionalFurniture(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction dirFacing = ctx.getPlayerFacing();
        if (ctx.getPlayer().isSneaking()) {
            dirFacing = ctx.getPlayerFacing().getOpposite();
        }
        return this.getDefaultState().with(Properties.HORIZONTAL_FACING, dirFacing);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState blockState, BlockView blockView, BlockPos blockPos, ShapeContext entityContext) {
        VoxelShape v = VoxelShapes.cuboid(0, 0, 0, 1F, 1F, 1F);
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
