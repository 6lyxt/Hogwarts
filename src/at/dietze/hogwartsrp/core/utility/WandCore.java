package at.dietze.hogwartsrp.core.utility;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class WandCore {

    protected void killEntity(Entity e){
        if(e instanceof Spider){
            ((Spider) e).setHealth(0);
            ((Spider) e).damage(0.01);
        } else if(e instanceof Zombie){
            ((Zombie) e).setHealth(0);
            ((Zombie) e).damage(0.01);
        } else if(e instanceof Skeleton){
            ((Skeleton) e).setHealth(0);
            ((Skeleton) e).damage(0.01);
        } else if(e instanceof Pig){
            ((Pig) e).setHealth(0);
            ((Pig) e).damage(0.01);
        } else if(e instanceof Cow){
            ((Cow) e).setHealth(0);
            ((Cow) e).damage(0.01);
        } else if(e instanceof Player) {
            ((Player) e).damage(0.01);
            ((Player) e).setHealth(0);
        } else if(e instanceof Creeper) {
            ((Creeper) e).setHealth(0);
            ((Creeper) e).damage(0.01);
        }
    }

    protected void freezeEntity(Entity e){
        if(e instanceof Spider){
            ((Spider) e).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10*100, 31));
        } else if(e instanceof Zombie){
            ((Zombie) e).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10*100, 31));
        } else if(e instanceof Skeleton){
            ((Skeleton) e).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10*100, 31));
        } else if(e instanceof Pig){
            ((Pig) e).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10*100, 31));
        } else if(e instanceof Cow){
            ((Cow) e).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10*100, 31));
        } else if(e instanceof Player) {
            ((Player) e).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10*100, 31));
            ((Player) e).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 10*100, 31));
        } else if(e instanceof Creeper) {
            ((Creeper) e).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10*100, 31));
        }
    }

    protected Entity getNearestEntityInSight(Player player, int range) {
        ArrayList<Entity> entities = (ArrayList<Entity>) player.getNearbyEntities(range, range, range);
        ArrayList<Block> sightBlock = (ArrayList<Block>) player.getLineOfSight(null, range);
        ArrayList<Location> sight = new ArrayList<>();
        for (Block block : sightBlock) sight.add(block.getLocation());
        for (Location location : sight) {
            for (Entity entity : entities) {
                if (Math.abs(entity.getLocation().getX() - location.getX()) < 1.3) {
                    if (Math.abs(entity.getLocation().getY() - location.getY()) < 1.5) {
                        if (Math.abs(entity.getLocation().getZ() - location.getZ()) < 1.3) {
                            return entity;
                        }
                    }
                }
            }
        }
        return null;
    }

    protected boolean validItem(ItemStack itemStack) {
        return itemStack.getType() == Material.STICK;
    }

    protected String getSpell(Player p){
        switch (p.getInventory().getItemInOffHand().getType()){
            default:
                return "none";
            case AIR:
                return "Lumos";
            case EMERALD:
                return "Avada Kedavra";
            case REDSTONE:
                return "Crucio";
            case LAPIS_LAZULI:
                return "Stupor";
            case GHAST_TEAR:
                return "Sectrum Senpra";
        }
    }

}
