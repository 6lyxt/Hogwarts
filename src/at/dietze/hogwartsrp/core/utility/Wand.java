package at.dietze.hogwartsrp.core.utility;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;


public class Wand implements Listener {

    WandCore sc = new WandCore();

    protected void avadaKedavra(Player p) {
        Bukkit.broadcastMessage("<" + p.getName() + "> §cAvada Kedavra!");
        Entity receiver = sc.getNearestEntityInSight(p, 20);
        sc.killEntity(receiver);
        for (int i = 0; i < 3; i++) {
            Objects.requireNonNull(receiver.getLocation().getWorld()).spawnParticle(Particle.COMPOSTER, p.getLocation(),31);
            Objects.requireNonNull(receiver.getLocation().getWorld()).playEffect(receiver.getLocation(), Effect.WITHER_SHOOT, 31);
        }
    }

    protected void crucio(Player p){
        Bukkit.broadcastMessage("<" + p.getName() + "> §cCrucio!");
        Player receiver = (Player) sc.getNearestEntityInSight(p, 20);
        receiver.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 5*100, 0));
        receiver.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 5*100, 3));
        receiver.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 5*100, 3));
        for (int i = 0; i < 3; i++) {
            Objects.requireNonNull(receiver.getLocation().getWorld()).playEffect(receiver.getLocation(), Effect.GHAST_SHRIEK, 31);
        }
    }

    protected void lumos(Player p){
        Bukkit.broadcastMessage("<" + p.getName() + "> §aLumos!");
        p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 10*100, 3));
    }

    protected void stupor(Player p) {
        Bukkit.broadcastMessage("<" + p.getName() + "> §cStupor!");
        Entity receiver = sc.getNearestEntityInSight(p, 20);
        sc.freezeEntity(receiver);
    }

    @EventHandler
    public void onMagic(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            if(e.getHand() == EquipmentSlot.HAND){
            if (sc.validItem(p.getInventory().getItemInMainHand())) {
                for (int i = 0; i < 5; i++) {
                    Objects.requireNonNull(p.getLocation().getWorld()).playEffect(p.getLocation(), Effect.ENDERDRAGON_SHOOT, 31);
                }

                if ("Avada Kedavra".equals(sc.getSpell(p))) {
                    avadaKedavra(p);
                } else if ("Crucio".equals(sc.getSpell(p))) {
                    crucio(p);
                } else if ("Lumos".equals(sc.getSpell(p))) {
                    lumos(p);
                } else if("Stupor".equalsIgnoreCase(sc.getSpell(p))) {
                    stupor(p);
                }
             }
           }
         }
       }
}
