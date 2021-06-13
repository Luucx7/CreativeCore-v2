package me.luucx7.creativecore.v2;

import me.luucx7.creativecore.v2.commands.FrameCommand;
import me.luucx7.creativecore.v2.commands.QuizCommand;
import me.luucx7.creativecore.v2.commands.RespostaCommand;
import me.luucx7.creativecore.v2.listeners.BlockGM3TP;
import org.bukkit.plugin.java.JavaPlugin;

public class CreativeCore extends JavaPlugin {

    private static CreativeCore _instance;

    @Override
    public void onEnable() {
        _instance = this;

        this.getCommand("frame").setExecutor(new FrameCommand());

        this.getCommand("quiz").setExecutor(new QuizCommand());
        this.getCommand("quiz").setTabCompleter(new QuizCommand());

        this.getCommand("resposta").setExecutor(new RespostaCommand());

        this.getServer().getPluginManager().registerEvents(new BlockGM3TP(), this);
    }

    public static CreativeCore getInstance() {
        return _instance;
    }
}
