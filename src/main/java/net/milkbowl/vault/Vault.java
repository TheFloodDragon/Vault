package net.milkbowl.vault;

import lombok.Getter;
import net.milkbowl.vault.cmds.VaultCmd;
import net.milkbowl.vault.permission.Permission;
import net.milkbowl.vault.permission.SuperPerms;
import net.milkbowl.vault.util.MessageUtil;
import net.milkbowl.vault.util.command.CommandFramework;
import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;

/**
 * Main class for Vault.
 *
 * @author Foulest
 * @project Vault
 */
@Getter
@SuppressWarnings("unused")
public class Vault extends JavaPlugin {

    public static Vault instance;
    public CommandFramework framework;

    @Override
    public void onEnable() {
        // Sets the instance.
        instance = this;

        // Initializes the Command Framework.
        MessageUtil.log(Level.INFO, "Initializing Command Framework...");
        framework = new CommandFramework(this);

        // Loads SuperPerms as a backup in case no other permissions plugin is loaded.
        MessageUtil.log(Level.INFO, "Loading Backup Permission System...");
        ServicesManager servicesManager = Bukkit.getServer().getServicesManager();
        servicesManager.register(Permission.class, new SuperPerms(this), this, ServicePriority.Lowest);

        // Loads the Vault commands.
        MessageUtil.log(Level.INFO, "Loading Commands...");
        loadCommands(new VaultCmd());

        MessageUtil.log(Level.INFO, "Loaded successfully.");
    }

    @Override
    public void onDisable() {
        // Removes all service registrations.
        getServer().getServicesManager().unregisterAll(this);
        Bukkit.getScheduler().cancelTasks(this);
    }

    /**
     * Loads the plugin's commands.
     *
     * @param commands Command to load.
     */
    private void loadCommands(Object @NotNull ... commands) {
        for (Object command : commands) {
            framework.registerCommands(command);
        }
    }
}
