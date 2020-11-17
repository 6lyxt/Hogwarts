package at.dietze.hogwartsrp.core.commands;

import at.dietze.hogwartsrp.Main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    private final Location spawn =  (Location) Main.getPlugin().getConfig().get("spawn");

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String cl, String[] args) {
        Player p = (Player)sender;
        if(cmd.getName().equalsIgnoreCase("spawn")){
            assert spawn != null;
            p.teleport(spawn);
        }
        return false;
    }
}
