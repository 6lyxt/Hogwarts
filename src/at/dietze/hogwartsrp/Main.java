package at.dietze.hogwartsrp;

import at.dietze.hogwartsrp.core.commands.*;
import at.dietze.hogwartsrp.core.utility.Wand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {

    public static Plugin plugin;

    @Override
    public void onEnable(){
        plugin = this;
        System.out.println("[ HogwartsRP ] Plugin wird geladen.");
        loadEvents();
        loadCommands();
    }

    void loadCommands(){
       Objects.requireNonNull(this.getCommand("Spawn")).setExecutor(new SpawnCommand());
       Objects.requireNonNull(this.getCommand("Gemeinschaftsraum")).setExecutor(new GemeinschaftsraumCommand());
       Objects.requireNonNull(this.getCommand("SetGemeinschafsraum")).setExecutor(new SetGemeinschaftsraumCommand());
       Objects.requireNonNull(this.getCommand("SetSpawn")).setExecutor(new SetSpawnCommand());
       Objects.requireNonNull(this.getCommand("AddHouse")).setExecutor(new AddHouse());
       Objects.requireNonNull(this.getCommand("ResetName")).setExecutor(new ResetName());
       System.out.println("[ HogwartsRP ] Befehle wurden geladen.");
    }

    void loadEvents(){
        Bukkit.getPluginManager().registerEvents(new Wand(), this);
        System.out.println("[ HogwartsRP ] Events wurden geladen.");
    }

    public static Plugin getPlugin(){
        return plugin;
    }
}
