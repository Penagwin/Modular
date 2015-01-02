package penagwin.Modular.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import penagwin.Modular.Blocks.Machines.MachineBase;
import penagwin.Modular.Modular;
import penagwin.Modular.Renderer.BlockRenderer;
import penagwin.Modular.Renderer.ConnectedTextureIcon;

/**
 * Created by Penagwin on 12/28/2014.
 */
public class MachBase extends MachineBase {


    public MachBase(Material material) {
        super(material);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.connectedName = "MACHC";
    }



}
