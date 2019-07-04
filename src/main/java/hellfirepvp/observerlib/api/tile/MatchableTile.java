package hellfirepvp.observerlib.api.tile;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * This class is part of the ObserverLib Mod
 * The complete source code for this mod can be found on github.
 * Class: MatchableTile
 * Created by HellFirePvP
 * Date: 30.04.2019 / 22:44
 */
public interface MatchableTile<T extends TileEntity> {

    /**
     * Write tileentity data to set onto the tileentity for rendering
     * via {@link TileEntity#read(CompoundNBT)}
     *
     * @param tile the created client tileentity
     * @param tick an ongoing client tick to cycle through things or related
     * @param tag the tag read onto the tileentity before rendering
     */
    @OnlyIn(Dist.CLIENT)
    public void writeDisplayData(@Nonnull T tile, long tick, @Nonnull CompoundNBT tag);

    /**
     * Tests if this matcher considers the passed tileentity valid for the world & blockpos combination
     *
     * @param reader the world to test in, may be null
     * @param absolutePosition the position the tileentity is at in the world
     * @param tile the tileentity to test
     *
     * @return true, if the tileentity is valid, false otherwise
     */
    public boolean matches(@Nullable IBlockReader reader, @Nonnull BlockPos absolutePosition, @Nonnull T tile);

}