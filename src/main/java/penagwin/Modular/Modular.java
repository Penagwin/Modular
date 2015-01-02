package penagwin.Modular;

/**
 * Created by Penagwin on 12/28/2014.
 */

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import penagwin.Modular.Blocks.Blocks;
import penagwin.Modular.Events.EventHandler;

@Mod(modid = Modular.MODID, version = Modular.VERSION)
public class Modular{
    public static final String MODID = "modular";
    public static final String VERSION = "1.0";

    @SidedProxy(clientSide = "penagwin.Modular.ClientProxy", serverSide = "penagwin.Modular.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        //Register all the blocks
        Blocks.register();

        //Initialize the proxy
        proxy.init();

        //Register the Event Handler
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }
}
