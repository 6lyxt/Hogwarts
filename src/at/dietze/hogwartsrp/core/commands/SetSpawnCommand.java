package at.dietze.hogwartsrp.core.commands;

import at.dietze.hogwartsrp.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player p = (Player)sender;

        if(p.hasPermission("hogwartsrp.admin")){
            if(cmd.getName().equalsIgnoreCase("setspawn")){
                Main.getPlugin().getConfig().set("spawn", p.getLocation());
                Main.getPlugin().saveConfig();
                Main.getPlugin().reloadConfig();
                p.sendMessage("§aSpawn wurde gesetzt.");
            }
        }
        return false;
    }
}
