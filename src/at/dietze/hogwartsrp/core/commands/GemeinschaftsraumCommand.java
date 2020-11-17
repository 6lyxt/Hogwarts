package at.dietze.hogwartsrp.core.commands;

import at.dietze.hogwartsrp.Main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GemeinschaftsraumCommand implements CommandExecutor {

    private final Location griffindor =  (Location) Main.getPlugin().getConfig().get("griffindor");
    private final Location ravenclaw =  (Location) Main.getPlugin().getConfig().get("ravenclaw");
    private final Location hufflepuff =  (Location) Main.getPlugin().getConfig().get("hufflepuff");
    private final Location slytherin =  (Location) Main.getPlugin().getConfig().get("slytherin");

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player p = (Player)sender;
        if(cmd.getName().equalsIgnoreCase("gemeinschaftsraum")){
            if(p.getDisplayName().contains("Griffindor")) {
                assert griffindor != null;
                p.teleport(griffindor);
            } else if(p.getDisplayName().contains("Slytherin")) {
                assert slytherin != null;
                p.teleport(slytherin);
            } else if(p.getDisplayName().contains("Hufflepuff")) {
                assert hufflepuff != null;
                p.teleport(hufflepuff);
            } else if(p.getDisplayName().contains("Ravenclaw")) {
                assert ravenclaw != null;
                p.teleport(ravenclaw);
            }
        }
        return false;
    }
}
