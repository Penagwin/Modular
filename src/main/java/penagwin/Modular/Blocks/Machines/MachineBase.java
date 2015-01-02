package penagwin.Modular.Blocks.Machines;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import penagwin.Modular.Modular;
import penagwin.Modular.Renderer.ConnectedTextureIcon;

import java.util.ArrayList;

/**
 * Created by Penagwin on 12/30/2014.
 */
public class MachineBase extends Block {

    //List of sprites for the Block
    public ArrayList<String> images = new ArrayList();

    //Name of the connected texture name should this block have one.
    public String connectedName;

    public IIcon[] textures = new IIcon[3];

    public MachineBase(Material material) {
        super(material);
    }

    @Override
    public void registerBlockIcons(IIconRegister register) {
        for(String s : images){
            textures[images.indexOf(s)] = register.registerIcon(Modular.MODID + ":" + s);
        }
        if(connectedName != null)   blockIcon = new ConnectedTextureIcon((TextureMap) register, Modular.MODID + ":" + connectedName);
    }

    @Override
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {

        //when not in world, just return the "full" icon (border for the 4 sides)
        return ((ConnectedTextureIcon) blockIcon).getFullIcon();
    }

    @Override
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
        //when in world, let the ConnectedTextureIcon fetch the right icon
        if(connectedName != null)   return ((ConnectedTextureIcon) blockIcon).getIcon(world, x, y, z, side);

        return this.getIcon(side, world.getBlockMetadata(x, y, z));

    }









}
