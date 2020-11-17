package at.dietze.hogwartsrp.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddHouse implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player p = (Player)sender;

        if(p.hasPermission("hogwartsrp.admin")) {
            if(cmd.getName().equalsIgnoreCase("addhouse")) {
                Player listener = Bukkit.getServer().getPlayer(args[0]);
                if(listener != null)
                    listener.setDisplayName(args[1] + "| " + listener.getName());
                } else {
                    p.sendMessage("Dieser Spieler ist dem Server nicht bekannt.");
                }
            }
        return false;
    }
}
