package penagwin.Modular.Renderer;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import penagwin.Modular.Blocks.MachBase;
import penagwin.Modular.Blocks.Machines.Pipe;

import static penagwin.Modular.Utils.Utils.XOR;

/**
 * Created by Penagwin on 12/29/2014.
 */
public class BlockRenderer extends RenderHelper implements ISimpleBlockRenderingHandler {
    public static int rBlockID;

    public BlockRenderer() {
        rBlockID = RenderingRegistry.getNextAvailableRenderId();
    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {

    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

        drawCenter(world, x, y, z, block);
        return true;
    }

    public void drawCenter(IBlockAccess world, int x, int y, int z, Block block){
        Tessellator tessellator = Tessellator.instance;

        tessellator.setColorOpaque_F(1, 1, 1);
        tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y + 1, z));

        float f3 = .3f; //South  EAST
        float f5 = .6f; //West
        float f6 = .6f; //Distance North and

        float f4 = .4f; //Height
        float f7 = .7f; //Distance down

        drawRectangle(world, x, y, z, block, tessellator, f3, f5,  f6, f4, f7);
        Pipe pipe = (Pipe)block;
            if(pipe.ye){
               drawRectangle(world, x, y, z, block, tessellator, f3, 1.5f, f6, f4, f7);

            }

    }

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }

    @Override
    public int getRenderId() {
        return rBlockID;
    }
}
