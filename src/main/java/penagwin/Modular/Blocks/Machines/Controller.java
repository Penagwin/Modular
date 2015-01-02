package penagwin.Modular.Blocks.Machines;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

/**
 * Created by Penagwin on 12/30/2014.
 */
public class Controller extends MachineBase {
    public Controller() {
        super(Material.clay);
    }

    public void onNeighborBlockChange(World world, int x, int y, int z, Block block){
        if(world.isBlockIndirectlyGettingPowered(x, y, z)){

        }
    }
}
