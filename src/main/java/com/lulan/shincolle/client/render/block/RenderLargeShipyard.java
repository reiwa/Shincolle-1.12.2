package com.lulan.shincolle.client.render.block;

import com.lulan.shincolle.client.model.ModelLargeShipyard;
import com.lulan.shincolle.client.model.ModelVortex;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.tileentity.BasicTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class RenderLargeShipyard
        extends TileEntitySpecialRenderer<BasicTileEntity> {
    private static final ResourceLocation TEXTURE_BASE = new ResourceLocation("shincolle:textures/blocks/blocklargeshipyard.png");
    private static final ResourceLocation VORTEX_OFF = new ResourceLocation("shincolle:textures/blocks/modelvortex.png");
    private static final ResourceLocation VORTEX_ON = new ResourceLocation("shincolle:textures/blocks/modelvortexon.png");
    private final ModelLargeShipyard model_base = new ModelLargeShipyard();
    private final ModelVortex model_vortex = new ModelVortex();

    private float prevYaw = 0.0f;
    private float prevPitch = 0.0f;
    private boolean firstRender = true;

    public void render(BasicTileEntity tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        int meta = tile.getRenderMetadata();
        if (meta <= 0) {
            return;
        }
        EntityPlayerSP player = Minecraft.getMinecraft().player;
        BlockPos pos = tile.getPos();
        double distX = pos.getX() + 0.5 - player.posX;
        double distY = pos.getY() - 0.75 - player.posY;
        double distZ = pos.getZ() + 0.5 - player.posZ;

        float horizontalDistance = MathHelper.sqrt(distX * distX + distZ * distZ);

        float yawRad = (float)Math.atan2(distX, distZ);
        float currentYawDeg = yawRad * 57.2957f;

        float pitchRad = (float)Math.atan2(horizontalDistance, distY);
        pitchRad = (float)(pitchRad + 1.5707963267948966);
        float currentPitchDeg = pitchRad * 57.2957f;

        if (this.firstRender) {
            this.prevYaw = currentYawDeg;
            this.prevPitch = currentPitchDeg;
            this.firstRender = false;
        }
        float interpFactor = 0.15f;
        float smoothedYaw = this.prevYaw + MathHelper.wrapDegrees(currentYawDeg - this.prevYaw) * interpFactor;
        float smoothedPitch = this.prevPitch + MathHelper.wrapDegrees(currentPitchDeg - this.prevPitch) * interpFactor;
        float angle = ((-player.ticksExisted) - partialTicks) % 360.0f;
        if (meta > 1) {
            angle *= 5.0f;
        }
        Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE_BASE);
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x + 0.5f, (float)y - 0.2f, (float)z + 0.5f);
        GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.scale(1.0f, 1.2f, 1.0f);
        this.model_base.render(0.0625f);
        GlStateManager.popMatrix();
        Minecraft.getMinecraft().renderEngine.bindTexture(meta > 1 ? VORTEX_ON : VORTEX_OFF);
        GlStateManager.pushMatrix();
        GlStateManager.depthMask(ConfigHandler.vortexDepth);
        GlStateManager.translate((float)x + 0.5f, (float)y + 0.5f, (float)z + 0.5f);
        GlStateManager.rotate(smoothedYaw, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(smoothedPitch, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(angle, 0.0f, 0.0f, 1.0f);
        this.model_vortex.render(0.03125f);
        GlStateManager.depthMask(true);
        GlStateManager.popMatrix();
        this.prevYaw = smoothedYaw;
        this.prevPitch = smoothedPitch;
    }
}

