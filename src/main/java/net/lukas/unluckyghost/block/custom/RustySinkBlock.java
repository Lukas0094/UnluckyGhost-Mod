package net.lukas.unluckyghost.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.apache.logging.log4j.core.jmx.Server;

public class RustySinkBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public RustySinkBlock(Properties properties) {
        super(properties);
    }

    public static final VoxelShape SHAPE_N =
            Block.box(0, 0, 3, 16, 4, 16);

    public static final VoxelShape SHAPE_E =
            Block.box(0, 0, 0, 13, 4, 16);

    public static final VoxelShape SHAPE_S =
            Block.box(0, 0, 0, 16, 4, 13);

    public static final VoxelShape SHAPE_W =
            Block.box(3, 0, 0, 16, 4, 16);

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        switch (p_60555_.getValue(FACING)) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            case SOUTH:
                return SHAPE_S;
            default:
                return SHAPE_S;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
    int tickCount = 0;
@Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
    if (tickCount > 100) {
        if (level.isClientSide) {
            level.playSound(null, blockPos, SoundEvents.GENERIC_EXPLODE, SoundSource.MASTER, 4f, 1f);
            level.addParticle(ParticleTypes.SMOKE, blockPos.getX() + 0.4f, blockPos.getY() + 1.4f, blockPos.getZ() + 0.4f, 0, -0.1f, 0);
        } else {

            level.playSound(null, blockPos, SoundEvents.GENERIC_EXPLODE, SoundSource.MASTER, 4f, 1f);
            level.addParticle(ParticleTypes.SMOKE, blockPos.getX() + 0.4f, blockPos.getY() + 1.4f, blockPos.getZ() + 0.4f, 0, -0.1f, 0);
        }
        tickCount = 0;
    }
        return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
++ tickCount;
    }
}
