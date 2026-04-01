package com.lulan.shincolle.client.render.block;

import com.lulan.shincolle.client.model.ModelSmallShipyard;
import com.lulan.shincolle.tileentity.BasicTileEntity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class RenderSmallShipyard
extends TileEntitySpecialRenderer<BasicTileEntity> {
    private static final ResourceLocation textureOn = new ResourceLocation("shincolle:textures/blocks/blocksmallshipyardon.png");
    private static final ResourceLocation textureOff = new ResourceLocation("shincolle:textures/blocks/blocksmallshipyardoff.png");
    private final ModelSmallShipyard model = new ModelSmallShipyard();

    public void render(BasicTileEntity tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        int meta = tile.getRenderMetadata();
        ResourceLocation textures = meta <= -1 || meta > 7 ? textureOn : textureOff;
        float angle = 0.0f;
        switch (meta) {
            case 5: 
            case 13: {
                angle = 90.0f;
                break;
            }
            case 3: 
            case 11: {
                angle = 180.0f;
                break;
            }
            case 4: 
            case 12: {
                angle = -90.0f;
                break;
            }
            default:
        }
        this.bindTexture(textures);
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
        GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.rotate(angle, 0.0f, 1.0f, 0.0f);
        this.model.renderModel(0.0625f);
        GlStateManager.popMatrix();
    }
}
