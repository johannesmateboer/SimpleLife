package simplelife.common.block.lights;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class CeilingLamp extends Block {

    public static String identifier = "ceiling_lamp";

    public CeilingLamp(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState blockState, BlockView blockView, BlockPos blockPos, ShapeContext entityContext) {
        return VoxelShapes.cuboid(0.25F, (14F / 16F), 0.25F, 0.75F, 1F, 0.75F);
    }
}
