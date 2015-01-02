package penagwin.Modular;

import cpw.mods.fml.client.registry.RenderingRegistry;
import penagwin.Modular.Renderer.BlockRenderer;

/**
 * Created by Penagwin on 12/29/2014.
 */
public class ClientProxy extends CommonProxy{

    @Override
    public void init(){
        RenderingRegistry.registerBlockHandler(new BlockRenderer());
    }
}
