package com.example.reboot_plugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Check;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
      // プラグインが有効になるとこの文字がコンソールに表示される
      getLogger().info("プラグインを有効にしました。");
    }
}


