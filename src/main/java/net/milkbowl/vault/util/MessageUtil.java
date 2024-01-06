package net.milkbowl.vault.util;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
@Setter
public final class MessageUtil {

    public static Logger logger = Bukkit.getLogger();

    public static void messagePlayer(@NonNull CommandSender sender, @NonNull String message) {
        sender.sendMessage(colorize(message));
    }

    public static void log(@NonNull Level level, @NonNull String message) {
        logger.log(level, "[Vault] " + message);
    }

    public static String colorize(@NonNull String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
