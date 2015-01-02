package penagwin.Modular.Renderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

/**
 * Created by Penagwin on 12/29/2014.
 */
public class RenderHelper {
    //
    public static void drawRectangle(IBlockAccess world, int x, int y, int z, Block block, Tessellator tessellator, float f3, float f5, float f6, float f4, float f7){
        double pY = y + 1.0001;

        //top 1
        IIcon top = block.getIcon(world, x, y, z, 1);
        double minU = top.getMinU(), maxU = top.getMaxU();
        double minV = top.getMinV(), maxV = top.getMaxV();

        tessellator.addVertexWithUV(x + f3, pY - f4, z + f3, minU, maxV);
        tessellator.addVertexWithUV(x + f3, pY - f4, z + f6, maxU, minV);
        tessellator.addVertexWithUV(x + f5, pY - f4, z + f6, minU, minV);
        tessellator.addVertexWithUV(x + f5, pY - f4, z + f3, maxU, maxV);

        //bottom 0
        IIcon bottom = block.getIcon(world, x, y, z, 0);

        double minU1 = bottom.getMinU(), maxU1 = bottom.getMaxU();
        double minV1 = bottom.getMinV(), maxV1 = bottom.getMaxV();
        tessellator.addVertexWithUV(x + f3, pY - f7, z + f3, minU1, minV1);
        tessellator.addVertexWithUV(x + f5, pY - f7, z + f3, maxU1, maxV1);
        tessellator.addVertexWithUV(x + f5, pY - f7, z + f6, minU1, maxV1);
        tessellator.addVertexWithUV(x + f3, pY - f7, z + f6, maxU1, minV1);

        //West 4
        IIcon side1 = block.getIcon(world, x, y, z, 4);

        double minU2 = side1.getMinU(), maxU2 = side1.getMaxU();
        double minV2 = side1.getMinV(), maxV2 = side1.getMaxV();
        tessellator.addVertexWithUV(x + f3, pY - f4, z + f3, minU2, minV2);
        tessellator.addVertexWithUV(x + f3, pY - f7, z + f3, maxU2, maxV2);
        tessellator.addVertexWithUV(x + f3, pY - f7, z + f6, minU2, maxV2);
        tessellator.addVertexWithUV(x + f3, pY - f4, z + f6, maxU2, minV2);

        //East 5
        IIcon side2 = block.getIcon(world, x, y, z, 5);

        double minU3 = side2.getMinU(), maxU3 = side2.getMaxU();
        double minV3 = side2.getMinV(), maxV3 = side2.getMaxV();
        tessellator.addVertexWithUV(x + f5, pY - f4, z + f3, minU3, minV3);
        tessellator.addVertexWithUV(x + f5, pY - f4, z + f6, maxU3, maxV3);
        tessellator.addVertexWithUV(x + f5, pY - f7, z + f6, minU3, maxV3);
        tessellator.addVertexWithUV(x + f5, pY - f7, z + f3, maxU3, minV3);

        //South 3
        IIcon side3 = block.getIcon(world, x, y, z, 3);

        double minU4 = side3.getMinU(), maxU4 = side3.getMaxU();
        double minV4 = side3.getMinV(), maxV4 = side3.getMaxV();
        tessellator.addVertexWithUV(x + f3, pY - f4, z + f6, minU4, minV4);
        tessellator.addVertexWithUV(x + f3, pY - f7, z + f6, maxU4, maxV4);
        tessellator.addVertexWithUV(x + f5, pY - f7, z + f6, minU4, maxV4);
        tessellator.addVertexWithUV(x + f5, pY - f4, z + f6, maxU4, minV4);

        //North 2
        IIcon side4 = block.getIcon(world, x, y, z, 2);

        double minU5 = side4.getMinU(), maxU5 = side4.getMaxU();
        double minV5 = side4.getMinV(), maxV5 = side4.getMaxV();
        tessellator.addVertexWithUV(x + f3, pY - f4, z + f3, minU5, minV5);
        tessellator.addVertexWithUV(x + f5, pY - f4, z + f3, maxU5, maxV5);
        tessellator.addVertexWithUV(x + f5, pY - f7, z + f3, minU5, maxV5);
        tessellator.addVertexWithUV(x + f3, pY - f7, z + f3, maxU5, minV5);
    }

    public static void renderFaceYPos(RenderBlocks r, Block block, int x, int y, int z, IIcon icon, int uv){

        r.uvRotateTop = uv;
        r.renderFaceYPos(block, x, y, z, icon);

        if(uv == 1) r.uvRotateBottom = 2;
        if(uv == 2) r.uvRotateBottom = 1;
        if(uv == 3) r.uvRotateBottom = 3;
        if(uv == 0) r.uvRotateBottom = 0;

        r.renderFaceYNeg(block, x, y, z, icon);
    }

    public static void renderFaceXPos(RenderBlocks r, Block block, int x, int y, int z, IIcon icon, int uv){

        r.uvRotateNorth = uv;
        r.renderFaceXNeg(block, x, y, z, icon);

        if(uv == 1) r.uvRotateSouth = 2;
        if(uv == 2) r.uvRotateSouth = 1;
        if(uv == 3) r.uvRotateSouth = 3;
        if(uv == 0) r.uvRotateSouth = 0;

       // r.flipTexture = true;
        r.renderFaceXPos(block, x, y, z, icon);
    }
}
