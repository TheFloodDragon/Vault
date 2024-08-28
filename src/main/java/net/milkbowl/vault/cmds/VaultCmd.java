/*
 * Vault - a permissions, chat, & economy API to give plugins easy hooks into.
 * Copyright (C) 2024 Foulest (https://github.com/Foulest)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */
package net.milkbowl.vault.cmds;

import net.milkbowl.vault.Vault;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import net.milkbowl.vault.util.ConstantUtil;
import net.milkbowl.vault.util.MessageUtil;
import net.milkbowl.vault.util.command.Command;
import net.milkbowl.vault.util.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * Main command for Vault.
 *
 * @author Foulest
 */
public class VaultCmd {

    /**
     * Handles the command logic.
     *
     * @param args The command arguments.
     */
    @SuppressWarnings("MethodMayBeStatic")
    @Command(name = "vault", description = "Main command for Vault.",
            permission = "vault.main", usage = "/vault")
    public void onCommand(@NotNull CommandArgs args) {
        CommandSender sender = args.getSender();

        // No additional arguments; display help menu.
        if (args.length() == 0) {
            handleHelp(sender, args);
            return;
        }

        // Handles sub-commands.
        String subCommand = args.getArgs(0);
        switch (subCommand.toLowerCase(Locale.ROOT)) {
            case "info":
                if (!sender.hasPermission("vault.info")) {
                    MessageUtil.messagePlayer(sender, ConstantUtil.NO_PERMISSION);
                    return;
                }

                if (args.length() != 1) {
                    MessageUtil.messagePlayer(sender, "&cUsage: /vault info");
                    return;
                }

                // Uses generic methods to get the strings for registered services.
                String registeredEcons = getRegisteredServicesString(Economy.class);
                String registeredPerms = getRegisteredServicesString(Permission.class);
                String registeredChats = getRegisteredServicesString(Chat.class);

                // Uses generic methods to get the primary services.
                Economy economy = getPrimaryService(Economy.class);
                Permission permission = getPrimaryService(Permission.class);
                Chat chat = getPrimaryService(Chat.class);

                // Displays Vault information.
                MessageUtil.messagePlayer(sender, "");
                MessageUtil.messagePlayer(sender, "&eVault Information");
                MessageUtil.messagePlayer(sender, "&7Version: &f" + Vault.getInstance().getDescription().getVersion());
                MessageUtil.messagePlayer(sender, String.format("&7Economy: &f%s &7[%s]", economy == null ? "None" : economy.getName(), registeredEcons));
                MessageUtil.messagePlayer(sender, String.format("&7Permission: &f%s &7[%s]", permission == null ? "None" : permission.getName(), registeredPerms));
                MessageUtil.messagePlayer(sender, String.format("&7Chat: &f%s &7[%s]", chat == null ? "None" : chat.getName(), registeredChats));
                MessageUtil.messagePlayer(sender, "");
                break;

            case "convert":
                if (!sender.hasPermission("vault.convert")) {
                    MessageUtil.messagePlayer(sender, ConstantUtil.NO_PERMISSION);
                    return;
                }

                if (args.length() != 3) {
                    MessageUtil.messagePlayer(sender, "&cUsage: /vault convert [econ1] [econ2]");
                    return;
                }

                Collection<RegisteredServiceProvider<Economy>> econs = Bukkit.getServer().getServicesManager().getRegistrations(Economy.class);

                // Checks if there are at least two economies loaded.
                if (econs.size() < 2) {
                    MessageUtil.messagePlayer(sender, "&cYou must have at least two economies loaded to convert.");
                    return;
                }

                Map<String, Economy> economyMap = new HashMap<>();
                econs.forEach(econ -> economyMap.put(econ.getProvider().getName().replace(" ", "").toLowerCase(Locale.ROOT), econ.getProvider()));

                Economy econ1 = economyMap.get(args.getArgs(0).toLowerCase(Locale.ROOT));
                Economy econ2 = economyMap.get(args.getArgs(1).toLowerCase(Locale.ROOT));

                // Checks if the specified economies are valid.
                if (econ1 == null || econ2 == null) {
                    String missingEcon = econ1 == null ? args.getArgs(0) : args.getArgs(1);
                    MessageUtil.messagePlayer(sender, "&cCould not find " + missingEcon + " loaded on the server; check your spelling.");
                    MessageUtil.messagePlayer(sender, "&cValid economies are: &e" + String.join(", ", economyMap.keySet()));
                    return;
                }

                MessageUtil.messagePlayer(sender, "&eThis may take some time to convert; expect server lag.");

                // Converts all player balances from the first economy to the second economy.
                for (OfflinePlayer op : Bukkit.getServer().getOfflinePlayers()) {
                    UUID uuid = op.getUniqueId();

                    if (!econ1.hasAccount(uuid)) {
                        continue;
                    }

                    econ2.createPlayerAccount(uuid);
                    double balanceDiff = econ1.getBalance(uuid) - econ2.getBalance(uuid);

                    if (balanceDiff > 0) {
                        econ2.depositPlayer(uuid, balanceDiff);
                    } else if (balanceDiff < 0) {
                        econ2.withdrawPlayer(uuid, -balanceDiff);
                    }
                }

                MessageUtil.messagePlayer(sender, "&aConversion complete. Please verify the data before using it.");
                break;

            default:
                handleHelp(sender, args);
                break;
        }
    }

    /**
     * Handles the help command.
     *
     * @param sender The command sender
     * @param args   The command arguments
     */
    private static void handleHelp(@NotNull CommandSender sender, CommandArgs args) {
        if (!sender.hasPermission("vault.main")) {
            MessageUtil.messagePlayer(sender, ConstantUtil.NO_PERMISSION);
            return;
        }

        // A list of available commands with their usages.
        List<String> commands = Arrays.asList(
                "&f/vault info &7- Displays info about Vault.",
                "&f/vault convert &7- Converts from one economy to another."
        );

        int itemsPerPage = 4;
        int maxPages = (int) Math.ceil((double) commands.size() / itemsPerPage);
        int page = 1;

        if (args.length() > 1) {
            try {
                page = Integer.parseInt(args.getArgs(1));
            } catch (NumberFormatException ex) {
                MessageUtil.messagePlayer(sender, "&cInvalid page number. Choose between 1 and " + maxPages + ".");
                return;
            }
        }

        if (page > maxPages || page < 1) {
            MessageUtil.messagePlayer(sender, "&cInvalid page number. Choose between 1 and " + maxPages + ".");
            return;
        }

        int startIndex = (page - 1) * itemsPerPage;
        int endIndex = Math.min(commands.size(), startIndex + itemsPerPage);

        MessageUtil.messagePlayer(sender, "");
        MessageUtil.messagePlayer(sender, "&eVault Help &7(Page " + page + "/" + maxPages + ")");

        for (int i = startIndex; i < endIndex; i++) {
            MessageUtil.messagePlayer(sender, commands.get(i));
        }

        MessageUtil.messagePlayer(sender, "");
        MessageUtil.messagePlayer(sender, "&7Type &f/vault help <page> &7for more commands.");
        MessageUtil.messagePlayer(sender, "");
    }

    /**
     * Gets a string of all registered services for a given service class.
     *
     * @param serviceClass The service class to get registered services for
     * @param <T>          The service class type
     * @return A string of all registered services for the given service class
     */
    private static <T> @NotNull String getRegisteredServicesString(Class<T> serviceClass) {
        StringBuilder services = new StringBuilder();
        Collection<RegisteredServiceProvider<T>> registrations = Bukkit.getServer().getServicesManager().getRegistrations(serviceClass);

        for (RegisteredServiceProvider<T> registration : registrations) {
            if (services.length() > 0) {
                services.append(", ");
            }

            services.append(registration.getProvider().getClass().getSimpleName());
        }
        return services.toString();
    }

    /**
     * Gets the primary service for a given service class.
     *
     * @param serviceClass The service class to get the primary service for
     * @param <T>          The service class type
     * @return The primary service for the given service class
     */
    private static <T> @Nullable T getPrimaryService(Class<T> serviceClass) {
        RegisteredServiceProvider<T> rsp = Bukkit.getServer().getServicesManager().getRegistration(serviceClass);
        return rsp == null ? null : rsp.getProvider();
    }
}
