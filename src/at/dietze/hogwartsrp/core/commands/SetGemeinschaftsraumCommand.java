package at.dietze.hogwartsrp.core.commands;

import at.dietze.hogwartsrp.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetGemeinschaftsraumCommand implements CommandExecutor {

    void setSpawn(String name, Player p){
        Main.getPlugin().getConfig().set(name, p.getLocation());
        Main.getPlugin().saveConfig();
        Main.getPlugin().reloadConfig();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player p = (Player)sender;

        if(p.hasPermission("hogwartsrp.admin")) {
            if(cmd.getName().equalsIgnoreCase("setgemeinschaftsraum")) {
                switch(args[0]) {
                    default:
                        p.sendMessage("Wähle eines der vier Häuser!");
                        break;
                    case "griffindor":
                        setSpawn("griffindor", p);
                        p.sendMessage("Griffindor Gemeinschaftsraum wurde gesetzt.");
                        break;
                    case "slytherin":
                        setSpawn("slytherin", p);
                        p.sendMessage("Slytherin Gemeinschaftsraum wurde gesetzt.");
                        break;
                    case "hufflepuff":
                        setSpawn("hufflepuff", p);
                        p.sendMessage("Hufflepuff Gemeinschaftsraum wurde gesetzt");
                        break;
                    case "ravenclaw":
                        setSpawn("ravenclaw", p);
                        p.sendMessage("Ravenclaw Gemeinschaftsraum wurde gesetzt");
                        break;
                }
            }
        }
        return false;
    }
}
