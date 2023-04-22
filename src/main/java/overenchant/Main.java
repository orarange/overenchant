package overenchant;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.List;


import java.util.HashMap;
import java.util.Map;

public class Main extends JavaPlugin implements Listener {

    private Map<Player, Long> cooldowns = new HashMap<>();
    private static final int COOLDOWN_SECONDS = 1;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if (item != null && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            List<String> lore = meta.getLore();
            if (lore != null && lore.contains("target lore")) {            
                
            long lastUseTime = cooldowns.getOrDefault(player, 0L);
            if (lastUseTime + (COOLDOWN_SECONDS * 1000) > System.currentTimeMillis()) {
                // still on cooldown
                return;
            }
            cooldowns.put(player, System.currentTimeMillis());

            Vector direction = player.getLocation().getDirection();
            direction.multiply(1);
            player.setVelocity(direction);
        }
    }

}
}