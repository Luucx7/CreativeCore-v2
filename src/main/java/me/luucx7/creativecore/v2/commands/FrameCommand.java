package me.luucx7.creativecore.v2.commands;

import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FrameCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cApenas jogadores podem executar este comando!");
            return true;
        }
        if (!(sender.hasPermission("ccore.frame"))) {
            sender.sendMessage("§cSem permissão!");
            return true;
        }
        Player player = (Player) sender;

        ItemStack frame = new ItemStack(Material.ITEM_FRAME);
        net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(frame);
        NBTTagCompound itemTAGs = nmsItem.hasTag() ? nmsItem.getTag() : new NBTTagCompound();

        NBTTagCompound entityTAG = new NBTTagCompound();
        entityTAG.setByte("Invisible", (byte) 1);

        assert itemTAGs != null;
        itemTAGs.set("EntityTag", entityTAG);
        nmsItem.setTag(itemTAGs);
        ItemStack item = CraftItemStack.asBukkitCopy(nmsItem);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cFrame Invisível");
        item.setItemMeta(meta);

        player.getInventory().addItem(item);
        sender.sendMessage("§aFrame invisível recebido!");
        return true;
    }
}
