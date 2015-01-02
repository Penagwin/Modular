package penagwin.Modular.Blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import penagwin.Modular.Blocks.Machines.Pipe;
import penagwin.Modular.Modular;

/**
 * Created by Penagwin on 12/28/2014.
 */
public enum Blocks {
MACHBASE(new MachBase(Material.clay), "MachBase"),
PIPE(new Pipe(), "PIPE")
    ;



    private final Block block;
    private final String name;

    Blocks(Block block, String name){
        this.block  = block;
        this.name   = name;
        block.setBlockName(Modular.MODID + "." + name);
    }

    public static void register(){
        for(Blocks b : Blocks.values()){
            b.block.setBlockTextureName(Modular.MODID + ":" + b.name);
            GameRegistry.registerBlock(b.block, b.name);
        }
    }


}

