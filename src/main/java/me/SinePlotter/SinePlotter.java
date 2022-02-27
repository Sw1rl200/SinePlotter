package me.SinePlotter;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod(modid = SinePlotter.MODID, name = SinePlotter.NAME, version = SinePlotter.VERSION)
public class SinePlotter
{
    public static final String MODID = "sineplotter";
    public static final String NAME = "SINE plotter";
    public static final String VERSION = "1.0";

    double x = 0;
    double y = 0;

    static final ResourceLocation rl = new ResourceLocation(SinePlotter.MODID,"textures/gui/test.png");


    Minecraft mc = Minecraft.getMinecraft();



    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new SinePlotter());
    }

    @SubscribeEvent
    public void OnTick(TickEvent event){

    }
    @SubscribeEvent
    public void renderGameOverlay(RenderGameOverlayEvent e){

        mc.getTextureManager().bindTexture(rl);
        GuiScreen.drawModalRectWithCustomSizedTexture(0, 0, 1, 1, 30, 30, 30, 30);

        if(x < 200) {
            x = x + 1;
        }
        mc.fontRenderer.drawString("o", (int)x , (int)Math.sin(x) + 50, -1);
    }



}
