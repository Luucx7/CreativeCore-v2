package me.luucx7.creativecore.v2;

import me.luucx7.creativecore.v2.commands.FrameCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class CreativeCore extends JavaPlugin {

    private static CreativeCore _instance;

    @Override
    public void onEnable() {
        _instance = this;

        this.getCommand("frame").setExecutor(new FrameCommand());
    }

    public static CreativeCore getInstance() {
        return _instance;
    }
}
