package overenchant;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Give implements org.bukkit.command.CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("giveoverenchant")) {
            Player player = (Player) sender;
            ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Overenchant Sword");
            List<String> lore = new ArrayList<String>();
            lore.add(ChatColor.GRAY + "Unleash the power of the gods!");
            lore.add("target lore");
            meta.setLore(lore);
            item.setItemMeta(meta);
            player.getInventory().addItem(item);
            player.sendMessage(ChatColor.GREEN + "You have been given the Overenchant Sword.");
            return true;
        }
        return false;
    }
}
