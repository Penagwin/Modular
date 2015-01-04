package penagwin.Modular.Blocks.Machines;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import penagwin.Modular.Modular;
import penagwin.Modular.Renderer.BlockRenderer;
import penagwin.Modular.Renderer.ConnectedTextureIcon;

import java.util.ArrayList;


/**
 * Created by Penagwin on 12/30/2014.
 */
public class Pipe extends MachineBase {
    public boolean ye = false;
    public Pipe(){
        super(Material.clay);
        this.setCreativeTab(CreativeTabs.tabBlock);
        setBlockBounds(0.3F, 0.3F, 0.3F, 0.6F, 0.6F, 0.6F);
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block){
        System.out.println(" X: " + x + ", Y: " + y + ", Z: " + z);
        if(block.equals(this)) {
            System.out.println("Equals");

            Block bblock = world.getBlock(x - 2, y, z);
            if (bblock instanceof Pipe) {
                System.out.println(bblock.getUnlocalizedName());
                ((Pipe)(block)).ye = true;
            }
        }

    }


        @Override
    public void registerBlockIcons(IIconRegister register) {

        textures[0] = register.registerIcon(Modular.MODID + ":Pipe");
        textures[1] = register.registerIcon(Modular.MODID + ":PipeFront");

        if(connectedName != null)   blockIcon = new ConnectedTextureIcon((TextureMap) register, Modular.MODID + ":" + connectedName);
    }
    @Override
    public int getRenderType(){
        //return super.getRenderType();
        return BlockRenderer.rBlockID;
    }

    @Override
    public boolean isNormalCube(){
        return false;
    }
    @Override
    public boolean isOpaqueCube(){
        return false;
    }
    @Override
    public IIcon getIcon(int side, int meta){
        return (side == meta) ?  textures[1] : textures[0];
    }
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack item) {
        world.setBlockMetadataWithNotify(x, y, z, BlockPistonBase.determineOrientation(world, x, y, z, entity), 2);
    }
}
