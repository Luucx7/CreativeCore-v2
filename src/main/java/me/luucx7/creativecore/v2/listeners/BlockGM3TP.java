package me.luucx7.creativecore.v2.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class BlockGM3TP implements Listener {

    @EventHandler
    public void tp(PlayerTeleportEvent ev) {
        if (ev.getPlayer().hasPermission("ccore.gm3tp.bypass")) return;

        if (ev.getCause() == PlayerTeleportEvent.TeleportCause.SPECTATE) {
            ev.setCancelled(true);
        }
    }
}
