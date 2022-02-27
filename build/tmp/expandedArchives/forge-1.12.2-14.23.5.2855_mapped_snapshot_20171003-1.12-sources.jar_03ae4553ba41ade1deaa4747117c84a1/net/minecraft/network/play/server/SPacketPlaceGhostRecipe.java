package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SPacketPlaceGhostRecipe implements Packet<INetHandlerPlayClient>
{
    private int field_194314_a;
    private IRecipe field_194315_b;

    public SPacketPlaceGhostRecipe()
    {
    }

    public SPacketPlaceGhostRecipe(int p_i47615_1_, IRecipe p_i47615_2_)
    {
        this.field_194314_a = p_i47615_1_;
        this.field_194315_b = p_i47615_2_;
    }

    @SideOnly(Side.CLIENT)
    public IRecipe func_194311_a()
    {
        return this.field_194315_b;
    }

    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.field_194314_a = buf.readByte();
        this.field_194315_b = CraftingManager.getRecipeById(buf.readVarInt());
    }

    @SideOnly(Side.CLIENT)
    public int func_194313_b()
    {
        return this.field_194314_a;
    }

    public void writePacketData(PacketBuffer buf) throws IOException
    {
        buf.writeByte(this.field_194314_a);
        buf.writeVarInt(CraftingManager.getIDForRecipe(this.field_194315_b));
    }

    public void processPacket(INetHandlerPlayClient handler)
    {
        handler.func_194307_a(this);
    }
}