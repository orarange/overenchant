import org.bukkit.plugin.java.JavaPlugin;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;


public class Check extends CheckForUpdates {

    private String currentVersion = getDescription().getVersion();
    private String latestVersion;

    @Override
    public void onEnable() {
        checkForUpdates();
    }

private void checkForUpdates() {
        try (InputStream inputStream = new URL("https://example.com/latest_version.txt").openStream(); Scanner scanner = new Scanner(inputStream)) {
            latestVersion = scanner.useDelimiter("\\A").next();
        } catch (IOException e) {
            getLogger().warning("Could not check for plugin updates: " + e.getMessage());
            return;
        }

        if (!currentVersion.equals(latestVersion)) {
            getLogger().warning("A new version of the plugin is available: " + latestVersion);
        }
    }

}
