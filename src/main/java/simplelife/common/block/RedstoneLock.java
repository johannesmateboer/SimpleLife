package simplelife.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import simplelife.common.SimpleLife;
import simplelife.common.block.entities.RedstoneLockEntity;
import simplelife.common.item.RedstoneLockKey;

@SuppressWarnings("deprecation")
public class RedstoneLock extends BlockWithEntity {

    private final String keyId = "key_id";

    public RedstoneLock(Settings settings) {
        super(settings);

        // On initial state, the redstone-lock doesn't provide power.
        setDefaultState(this.stateManager.getDefaultState()
                .with(Properties.POWER, 0)
        );
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.POWER, Properties.HORIZONTAL_FACING);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack activeStack = player.getStackInHand(hand);

        // If the player holds the right key, we enable or disable the power
        if (activeStack.getItem() instanceof RedstoneLockKey) {
            CompoundTag ct = activeStack.getOrCreateTag();

            if (ct.getLong(this.keyId) == pos.asLong()) {
                // Allowed
                this.toggleRedstoneOutput(world, pos, state);
                player.playSound(SoundEvents.BLOCK_LEVER_CLICK, 1.0f, 1.0f);
                return ActionResult.SUCCESS;
            } else {
                player.sendMessage(new LiteralText("Access denied"), true);
                return ActionResult.PASS;
            }
        }
        return ActionResult.PASS;
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (placer instanceof PlayerEntity) {
            ItemStack stack = new ItemStack(SimpleLife.REDSTONE_LOCK_KEY, 1);
            long keyBlockPos = pos.asLong();
            CompoundTag ct = new CompoundTag();
            ct.putLong(this.keyId, keyBlockPos);
            stack.setTag(ct);
            ((PlayerEntity) placer).giveItemStack(stack);
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing());
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public boolean emitsRedstonePower(BlockState state) {
        return false;
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    // Returns the signal for this block. So 'true' when the proper key is inserted
    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return state.get(Properties.POWER);
    }

    @Override
    public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        // Rotating, so we only output at the back
        if (direction.getOpposite() == state.get(Properties.HORIZONTAL_FACING)) {
            return state.get(Properties.POWER);
        }else{
            return 0;
        }
    }

    @Override
    public int getStrongRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return this.getWeakRedstonePower(state, world, pos, direction);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new RedstoneLockEntity();
    }

    private void toggleRedstoneOutput(World world, BlockPos pos, BlockState state) {
        int currentState = state.get(Properties.POWER);
        if (currentState == 0) {
            world.setBlockState(pos, state.with(Properties.POWER, 15));
        } else {
            world.setBlockState(pos, state.with(Properties.POWER, 0));
        }
    }
}