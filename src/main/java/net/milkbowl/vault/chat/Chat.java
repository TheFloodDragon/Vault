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
package net.milkbowl.vault.chat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * Abstract class for Vault's Chat API.
 *
 * @author Foulest
 */
@Getter
@AllArgsConstructor
@SuppressWarnings({"unused"})
public abstract class Chat {

    private final Permission permission;

    /**
     * Gets the name of the chat implementation.
     *
     * @return Name of the chat implementation.
     */
    public abstract String getName();

    /**
     * Checks if the chat implementation is enabled.
     *
     * @return Whether the chat implementation is enabled.
     */
    public abstract boolean isEnabled();

    /**
     * Retrieves the prefix of a player.
     *
     * @param uuid The UUID of the player whose prefix is being queried.
     * @return The player's prefix.
     */
    public abstract String getPlayerPrefix(UUID uuid);

    @Deprecated
    public String getPlayerPrefix(@NotNull Player player) {
        return getPlayerPrefix(player.getUniqueId());
    }

    @Deprecated
    public String getPlayerPrefix(@NotNull OfflinePlayer player) {
        return getPlayerPrefix(player.getUniqueId());
    }

    @Deprecated
    public String getPlayerPrefix(@NotNull String playerName) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return getPlayerPrefix(player);
        } else {
            return getPlayerPrefix(Bukkit.getOfflinePlayer(playerName));
        }
    }

    /**
     * Retrieves the prefix of an offline player in a specific world.
     *
     * @param world  The world in which to look up the prefix.
     * @param uuid   The UUID of the offline player whose prefix is being queried.
     * @return The offline player's prefix in the specified world.
     */
    public abstract String getPlayerPrefix(String world, UUID uuid);

    @Deprecated
    public String getPlayerPrefix(String world, @NotNull Player player) {
        return getPlayerPrefix(world, player.getUniqueId());
    }

    @Deprecated
    public String getPlayerPrefix(String world, @NotNull OfflinePlayer player) {
        return getPlayerPrefix(world, player.getUniqueId());
    }

    @Deprecated
    public String getPlayerPrefix(String world, @NotNull String playerName) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return getPlayerPrefix(world, player);
        } else {
            return getPlayerPrefix(world, Bukkit.getOfflinePlayer(playerName));
        }
    }

    /**
     * Sets the prefix of a player.
     *
     * @param uuid   The UUID of the player whose prefix is being set.
     * @param prefix The prefix to set.
     */
    public abstract void setPlayerPrefix(UUID uuid, String prefix);

    @Deprecated
    public void setPlayerPrefix(@NotNull Player player, String prefix) {
        setPlayerPrefix(player.getUniqueId(), prefix);
    }

    @Deprecated
    public void setPlayerPrefix(@NotNull OfflinePlayer player, String prefix) {
        setPlayerPrefix(player.getUniqueId(), prefix);
    }

    @Deprecated
    public void setPlayerPrefix(@NotNull String playerName, String prefix) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            setPlayerPrefix(player, prefix);
        } else {
            setPlayerPrefix(Bukkit.getOfflinePlayer(playerName), prefix);
        }
    }

    /**
     * Sets the prefix of a player in a specific world.
     *
     * @param world  The world in which to set the prefix.
     * @param uuid   The UUID of the player whose prefix is being set.
     * @param prefix The prefix to set.
     */
    public abstract void setPlayerPrefix(String world, UUID uuid, String prefix);

    @Deprecated
    public void setPlayerPrefix(String world, @NotNull Player player, String prefix) {
        setPlayerPrefix(world, player.getUniqueId(), prefix);
    }

    @Deprecated
    public void setPlayerPrefix(String world, @NotNull OfflinePlayer player, String prefix) {
        setPlayerPrefix(world, player.getUniqueId(), prefix);
    }

    @Deprecated
    public void setPlayerPrefix(String world, @NotNull String playerName, String prefix) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            setPlayerPrefix(world, player, prefix);
        } else {
            setPlayerPrefix(world, Bukkit.getOfflinePlayer(playerName), prefix);
        }
    }

    /**
     * Retrieves the suffix of a player.
     *
     * @param uuid The UUID of the player whose suffix is being queried.
     * @return The player's suffix in the specified world.
     */
    public abstract String getPlayerSuffix(UUID uuid);

    @Deprecated
    public String getPlayerSuffix(@NotNull Player player) {
        return getPlayerSuffix(player.getUniqueId());
    }

    @Deprecated
    public String getPlayerSuffix(@NotNull OfflinePlayer player) {
        return getPlayerSuffix(player.getUniqueId());
    }

    @Deprecated
    public String getPlayerSuffix(@NotNull String playerName) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return getPlayerSuffix(player);
        } else {
            return getPlayerSuffix(Bukkit.getOfflinePlayer(playerName));
        }
    }

    /**
     * Retrieves the suffix of a player in a specific world.
     *
     * @param world  The world in which to look up the suffix.
     * @param uuid   The UUID of the player whose suffix is being queried.
     * @return The player's suffix in the specified world.
     */
    public abstract String getPlayerSuffix(String world, UUID uuid);

    @Deprecated
    public String getPlayerSuffix(String world, @NotNull Player player) {
        return getPlayerSuffix(world, player.getUniqueId());
    }

    @Deprecated
    public String getPlayerSuffix(String world, @NotNull OfflinePlayer player) {
        return getPlayerSuffix(world, player.getUniqueId());
    }

    @Deprecated
    public String getPlayerSuffix(String world, @NotNull String playerName) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return getPlayerSuffix(world, player);
        } else {
            return getPlayerSuffix(world, Bukkit.getOfflinePlayer(playerName));
        }
    }

    /**
     * Sets the suffix of a player.
     *
     * @param uuid   The UUID of the player whose suffix is being set.
     * @param suffix The suffix to set.
     */
    public abstract void setPlayerSuffix(UUID uuid, String suffix);

    @Deprecated
    public void setPlayerSuffix(@NotNull Player player, String suffix) {
        setPlayerSuffix(player.getUniqueId(), suffix);
    }

    @Deprecated
    public void setPlayerSuffix(@NotNull OfflinePlayer player, String suffix) {
        setPlayerSuffix(player.getUniqueId(), suffix);
    }

    @Deprecated
    public void setPlayerSuffix(@NotNull String playerName, String suffix) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            setPlayerSuffix(player, suffix);
        } else {
            setPlayerSuffix(Bukkit.getOfflinePlayer(playerName), suffix);
        }
    }

    /**
     * Sets the suffix of a player in a specific world.
     *
     * @param world  The world in which to set the suffix.
     * @param uuid   The UUID of the player whose suffix is being set.
     * @param suffix The suffix to set.
     */
    public abstract void setPlayerSuffix(String world, UUID uuid, String suffix);

    @Deprecated
    public void setPlayerSuffix(String world, @NotNull Player player, String suffix) {
        setPlayerSuffix(world, player.getUniqueId(), suffix);
    }

    @Deprecated
    public void setPlayerSuffix(String world, @NotNull OfflinePlayer player, String suffix) {
        setPlayerSuffix(world, player.getUniqueId(), suffix);
    }

    @Deprecated
    public void setPlayerSuffix(String world, @NotNull String playerName, String suffix) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            setPlayerSuffix(world, player, suffix);
        } else {
            setPlayerSuffix(world, Bukkit.getOfflinePlayer(playerName), suffix);
        }
    }

    /**
     * Retrieves the prefix of a group.
     *
     * @param group The group whose prefix is being queried.
     * @return The group's prefix in the specified world.
     */
    public abstract String getGroupPrefix(String group);

    /**
     * Retrieves the prefix of a group in a specific world.
     *
     * @param world The world in which to look up the prefix.
     * @param group The group whose prefix is being queried.
     * @return The group's prefix in the specified world.
     */
    public abstract String getGroupPrefix(String world, String group);

    /**
     * Sets the prefix of a group.
     *
     * @param group The group whose prefix is being set.
     * @param prefix The prefix to set.
     */
    public abstract void setGroupPrefix(String group, String prefix);

    /**
     * Sets the prefix of a group in a specific world.
     *
     * @param world  The world in which to set the prefix.
     * @param group  The group whose prefix is being set.
     * @param prefix The prefix to set.
     */
    public abstract void setGroupPrefix(String world, String group, String prefix);

    /**
     * Retrieves the suffix of a group.
     *
     * @param group The group whose suffix is being queried.
     * @return The group's suffix in the specified world.
     */
    public abstract String getGroupSuffix(String group);

    /**
     * Retrieves the suffix of a group in a specific world.
     *
     * @param world The world in which to look up the suffix.
     * @param group The group whose suffix is being queried.
     * @return The group's suffix in the specified world.
     */
    public abstract String getGroupSuffix(String world, String group);

    /**
     * Sets the suffix of a group.
     *
     * @param group  The group whose suffix is being set.
     * @param suffix The suffix to set.
     */
    public abstract void setGroupSuffix(String group, String suffix);

    /**
     * Sets the suffix of a group in a specific world.
     *
     * @param world  The world in which to set the suffix.
     * @param group  The group whose suffix is being set.
     * @param suffix The suffix to set.
     */
    public abstract void setGroupSuffix(String world, String group, String suffix);

    // Player Info Integers

    /**
     * Retrieves the player info integer value of a player.
     *
     * @param uuid         The UUID of the player whose player info integer value is being queried.
     * @param node         The node whose player info integer value is being queried.
     * @param defaultValue The default value to return if the player info integer value is not found.
     * @return The player info integer value of the specified player in the specified world.
     */
    public abstract int getPlayerInfoInteger(UUID uuid, String node, int defaultValue);

    @Deprecated
    public int getPlayerInfoInteger(@NotNull Player player, String node, int defaultValue) {
        return getPlayerInfoInteger(player.getUniqueId(), node, defaultValue);
    }

    @Deprecated
    public int getPlayerInfoInteger(@NotNull OfflinePlayer player, String node, int defaultValue) {
        return getPlayerInfoInteger(player.getUniqueId(), node, defaultValue);
    }

    @Deprecated
    public int getPlayerInfoInteger(@NotNull String playerName, String node, int defaultValue) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return getPlayerInfoInteger(player, node, defaultValue);
        } else {
            return getPlayerInfoInteger(Bukkit.getOfflinePlayer(playerName), node, defaultValue);
        }
    }

    /**
     * Retrieves the player info integer value of a player in a specific world.
     *
     * @param world        The world in which to look up the player info integer value.
     * @param uuid         The UUID of the player whose player info integer value is being queried.
     * @param node         The node whose player info integer value is being queried.
     * @param defaultValue The default value to return if the player info integer value is not found.
     * @return The player info integer value of the specified player in the specified world.
     */
    public abstract int getPlayerInfoInteger(String world, UUID uuid, String node, int defaultValue);

    @Deprecated
    public int getPlayerInfoInteger(String world, @NotNull Player player, String node, int defaultValue) {
        return getPlayerInfoInteger(world, player.getUniqueId(), node, defaultValue);
    }

    @Deprecated
    public int getPlayerInfoInteger(String world, @NotNull OfflinePlayer player, String node, int defaultValue) {
        return getPlayerInfoInteger(world, player.getUniqueId(), node, defaultValue);
    }

    @Deprecated
    public int getPlayerInfoInteger(String world, @NotNull String playerName, String node, int defaultValue) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return getPlayerInfoInteger(world, player, node, defaultValue);
        } else {
            return getPlayerInfoInteger(world, Bukkit.getOfflinePlayer(playerName), node, defaultValue);
        }
    }

    /**
     * Sets the player info integer value of a player.
     *
     * @param uuid  The UUID of the player whose player info integer value is being set.
     * @param node  The node whose player info integer value is being set.
     * @param value The value to set.
     */
    public abstract void setPlayerInfoInteger(UUID uuid, String node, int value);

    @Deprecated
    public void setPlayerInfoInteger(@NotNull Player player, String node, int value) {
        setPlayerInfoInteger(player.getUniqueId(), node, value);
    }

    @Deprecated
    public void setPlayerInfoInteger(@NotNull OfflinePlayer player, String node, int value) {
        setPlayerInfoInteger(player.getUniqueId(), node, value);
    }

    @Deprecated
    public void setPlayerInfoInteger(@NotNull String playerName, String node, int value) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            setPlayerInfoInteger(player, node, value);
        } else {
            setPlayerInfoInteger(Bukkit.getOfflinePlayer(playerName), node, value);
        }
    }

    /**
     * Sets the player info integer value of a player in a specific world.
     *
     * @param world The world in which to set the player info integer value.
     * @param uuid  The UUID of the player whose player info integer value is being set.
     * @param node  The node whose player info integer value is being set.
     * @param value The value to set.
     */
    public abstract void setPlayerInfoInteger(String world, UUID uuid, String node, int value);

    @Deprecated
    public void setPlayerInfoInteger(String world, @NotNull Player player, String node, int value) {
        setPlayerInfoInteger(world, player.getUniqueId(), node, value);
    }

    @Deprecated
    public void setPlayerInfoInteger(String world, @NotNull OfflinePlayer player, String node, int value) {
        setPlayerInfoInteger(world, player.getUniqueId(), node, value);
    }

    @Deprecated
    public void setPlayerInfoInteger(String world, @NotNull String playerName, String node, int value) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            setPlayerInfoInteger(world, player, node, value);
        } else {
            setPlayerInfoInteger(world, Bukkit.getOfflinePlayer(playerName), node, value);
        }
    }

    /**
     * Retrieves the group info integer value of a group.
     *
     * @param group        The group whose group info integer value is being queried.
     * @param node         The node whose group info integer value is being queried.
     * @param defaultValue The default value to return if the group info integer value is not found.
     * @return The group info integer value of the specified group in the specified world.
     */
    public abstract int getGroupInfoInteger(String group, String node, int defaultValue);

    /**
     * Retrieves the group info integer value of a group in a specific world.
     *
     * @param world        The world in which to look up the group info integer value.
     * @param group        The group whose group info integer value is being queried.
     * @param node         The node whose group info integer value is being queried.
     * @param defaultValue The default value to return if the group info integer value is not found.
     * @return The group info integer value of the specified group in the specified world.
     */
    public abstract int getGroupInfoInteger(String world, String group, String node, int defaultValue);

    /**
     * Sets the group info integer value of a group.
     *
     * @param group The group whose group info integer value is being set.
     * @param node  The node whose group info integer value is being set.
     * @param value The value to set.
     */
    public abstract void setGroupInfoInteger(String group, String node, int value);

    /**
     * Sets the group info integer value of a group in a specific world.
     *
     * @param world The world in which to set the group info integer value.
     * @param group The group whose group info integer value is being set.
     * @param node  The node whose group info integer value is being set.
     * @param value The value to set.
     */
    public abstract void setGroupInfoInteger(String world, String group, String node, int value);

    /**
     * Retrieves the player info double value of a player.
     *
     * @param uuid         The UUID of the player whose player info double value is being queried.
     * @param node         The node whose player info double value is being queried.
     * @param defaultValue The default value to return if the player info double value is not found.
     * @return The player info double value of the specified player in the specified world.
     */
    public abstract double getPlayerInfoDouble(UUID uuid, String node, double defaultValue);

    @Deprecated
    public double getPlayerInfoDouble(@NotNull Player player, String node, double defaultValue) {
        return getPlayerInfoDouble(player.getUniqueId(), node, defaultValue);
    }

    @Deprecated
    public double getPlayerInfoDouble(@NotNull OfflinePlayer player, String node, double defaultValue) {
        return getPlayerInfoDouble(player.getUniqueId(), node, defaultValue);
    }

    @Deprecated
    public double getPlayerInfoDouble(@NotNull String playerName, String node, double defaultValue) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return getPlayerInfoDouble(player, node, defaultValue);
        } else {
            return getPlayerInfoDouble(Bukkit.getOfflinePlayer(playerName), node, defaultValue);
        }
    }

    /**
     * Retrieves the player info double value of a player in a specific world.
     *
     * @param world        The world in which to look up the player info double value.
     * @param uuid         The UUID of the player whose player info double value is being queried.
     * @param node         The node whose player info double value is being queried.
     * @param defaultValue The default value to return if the player info double value is not found.
     * @return The player info double value of the specified player in the specified world.
     */
    public abstract double getPlayerInfoDouble(String world, UUID uuid, String node, double defaultValue);

    @Deprecated
    public double getPlayerInfoDouble(String world, @NotNull Player player, String node, double defaultValue) {
        return getPlayerInfoDouble(world, player.getUniqueId(), node, defaultValue);
    }

    @Deprecated
    public double getPlayerInfoDouble(String world, @NotNull OfflinePlayer player, String node, double defaultValue) {
        return getPlayerInfoDouble(world, player.getUniqueId(), node, defaultValue);
    }

    @Deprecated
    public double getPlayerInfoDouble(String world, @NotNull String playerName, String node, double defaultValue) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return getPlayerInfoDouble(world, player, node, defaultValue);
        } else {
            return getPlayerInfoDouble(world, Bukkit.getOfflinePlayer(playerName), node, defaultValue);
        }
    }

    /**
     * Sets the player info double value of a player.
     *
     * @param uuid The UUID of the player whose player info double value is being set.
     * @param node The node whose player info double value is being set.
     * @param value The value to set.
     */
    public abstract void setPlayerInfoDouble(UUID uuid, String node, double value);

    @Deprecated
    public void setPlayerInfoDouble(@NotNull Player player, String node, double value) {
        setPlayerInfoDouble(player.getUniqueId(), node, value);
    }

    @Deprecated
    public void setPlayerInfoDouble(@NotNull OfflinePlayer player, String node, double value) {
        setPlayerInfoDouble(player.getUniqueId(), node, value);
    }

    @Deprecated
    public void setPlayerInfoDouble(@NotNull String playerName, String node, double value) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            setPlayerInfoDouble(player, node, value);
        } else {
            setPlayerInfoDouble(Bukkit.getOfflinePlayer(playerName), node, value);
        }
    }

    /**
     * Sets the player info double value of a player in a specific world.
     *
     * @param world The world in which to set the player info double value.
     * @param uuid The UUID of the player whose player info double value is being set.
     * @param node The node whose player info double value is being set.
     * @param value The value to set.
     */
    public abstract void setPlayerInfoDouble(String world, UUID uuid, String node, double value);

    @Deprecated
    public void setPlayerInfoDouble(String world, @NotNull Player player, String node, double value) {
        setPlayerInfoDouble(world, player.getUniqueId(), node, value);
    }

    @Deprecated
    public void setPlayerInfoDouble(String world, @NotNull OfflinePlayer player, String node, double value) {
        setPlayerInfoDouble(world, player.getUniqueId(), node, value);
    }

    @Deprecated
    public void setPlayerInfoDouble(String world, @NotNull String playerName, String node, double value) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            setPlayerInfoDouble(world, player, node, value);
        } else {
            setPlayerInfoDouble(world, Bukkit.getOfflinePlayer(playerName), node, value);
        }
    }

    /**
     * Retrieves the group info double value of a group.
     *
     * @param group        The group whose group info double value is being queried.
     * @param node         The node whose group info double value is being queried.
     * @param defaultValue The default value to return if the group info double value is not found.
     * @return The group info double value of the specified group in the specified world.
     */
    public abstract double getGroupInfoDouble(String group, String node, double defaultValue);

    /**
     * Retrieves the group info double value of a group in a specific world.
     *
     * @param world        The world in which to look up the group info double value.
     * @param group        The group whose group info double value is being queried.
     * @param node         The node whose group info double value is being queried.
     * @param defaultValue The default value to return if the group info double value is not found.
     * @return The group info double value of the specified group in the specified world.
     */
    public abstract double getGroupInfoDouble(String world, String group, String node, double defaultValue);

    /**
     * Sets the group info double value of a group.
     *
     * @param group The group whose group info double value is being set.
     * @param node  The node whose group info double value is being set.
     * @param value The value to set.
     */
    public abstract void setGroupInfoDouble(String group, String node, double value);

    /**
     * Sets the group info double value of a group in a specific world.
     *
     * @param world The world in which to set the group info double value.
     * @param group The group whose group info double value is being set.
     * @param node  The node whose group info double value is being set.
     * @param value The value to set.
     */
    public abstract void setGroupInfoDouble(String world, String group, String node, double value);

    /**
     * Retrieves the player info boolean value of a player.
     *
     * @param uuid         The UUID of the player whose player info boolean value is being queried.
     * @param node         The node whose player info boolean value is being queried.
     * @param defaultValue The default value to return if the player info boolean value is not found.
     * @return The player info boolean value of the specified player in the specified world.
     */
    public abstract boolean getPlayerInfoBoolean(UUID uuid, String node, boolean defaultValue);

    @Deprecated
    public boolean getPlayerInfoBoolean(@NotNull Player player, String node, boolean defaultValue) {
        return getPlayerInfoBoolean(player.getUniqueId(), node, defaultValue);
    }

    @Deprecated
    public boolean getPlayerInfoBoolean(@NotNull OfflinePlayer player, String node, boolean defaultValue) {
        return getPlayerInfoBoolean(player.getUniqueId(), node, defaultValue);
    }

    @Deprecated
    public boolean getPlayerInfoBoolean(@NotNull String playerName, String node, boolean defaultValue) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return getPlayerInfoBoolean(player, node, defaultValue);
        } else {
            return getPlayerInfoBoolean(Bukkit.getOfflinePlayer(playerName), node, defaultValue);
        }
    }

    /**
     * Retrieves the player info boolean value of a player in a specific world.
     *
     * @param world        The world in which to look up the player info boolean value.
     * @param uuid         The UUID of the player whose player info boolean value is being queried.
     * @param node         The node whose player info boolean value is being queried.
     * @param defaultValue The default value to return if the player info boolean value is not found.
     * @return The player info boolean value of the specified player in the specified world.
     */
    public abstract boolean getPlayerInfoBoolean(String world, UUID uuid, String node, boolean defaultValue);

    @Deprecated
    public boolean getPlayerInfoBoolean(String world, @NotNull Player player, String node, boolean defaultValue) {
        return getPlayerInfoBoolean(world, player.getUniqueId(), node, defaultValue);
    }

    @Deprecated
    public boolean getPlayerInfoBoolean(String world, @NotNull OfflinePlayer player, String node, boolean defaultValue) {
        return getPlayerInfoBoolean(world, player.getUniqueId(), node, defaultValue);
    }

    @Deprecated
    public boolean getPlayerInfoBoolean(String world, @NotNull String playerName, String node, boolean defaultValue) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return getPlayerInfoBoolean(world, player, node, defaultValue);
        } else {
            return getPlayerInfoBoolean(world, Bukkit.getOfflinePlayer(playerName), node, defaultValue);
        }
    }

    /**
     * Sets the player info boolean value of a player.
     *
     * @param uuid  The UUID of the player whose player info boolean value is being set.
     * @param node  The node whose player info boolean value is being set.
     * @param value The value to set.
     */
    public abstract void setPlayerInfoBoolean(UUID uuid, String node, boolean value);

    @Deprecated
    public void setPlayerInfoBoolean(@NotNull Player player, String node, boolean value) {
        setPlayerInfoBoolean(player.getUniqueId(), node, value);
    }

    @Deprecated
    public void setPlayerInfoBoolean(@NotNull OfflinePlayer player, String node, boolean value) {
        setPlayerInfoBoolean(player.getUniqueId(), node, value);
    }

    @Deprecated
    public void setPlayerInfoBoolean(@NotNull String playerName, String node, boolean value) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            setPlayerInfoBoolean(player, node, value);
        } else {
            setPlayerInfoBoolean(Bukkit.getOfflinePlayer(playerName), node, value);
        }
    }

    /**
     * Sets the player info boolean value of a player in a specific world.
     *
     * @param world The world in which to set the player info boolean value.
     * @param uuid  The UUID of the player whose player info boolean value is being set.
     * @param node  The node whose player info boolean value is being set.
     * @param value The value to set.
     */
    public abstract void setPlayerInfoBoolean(String world, UUID uuid, String node, boolean value);

    @Deprecated
    public void setPlayerInfoBoolean(String world, @NotNull Player player, String node, boolean value) {
        setPlayerInfoBoolean(world, player.getUniqueId(), node, value);
    }

    @Deprecated
    public void setPlayerInfoBoolean(String world, @NotNull OfflinePlayer player, String node, boolean value) {
        setPlayerInfoBoolean(world, player.getUniqueId(), node, value);
    }

    @Deprecated
    public void setPlayerInfoBoolean(String world, @NotNull String playerName, String node, boolean value) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            setPlayerInfoBoolean(world, player, node, value);
        } else {
            setPlayerInfoBoolean(world, Bukkit.getOfflinePlayer(playerName), node, value);
        }
    }

    /**
     * Retrieves the group info boolean value of a group.
     *
     * @param group        The group whose group info boolean value is being queried.
     * @param node         The node whose group info boolean value is being queried.
     * @param defaultValue The default value to return if the group info boolean value is not found.
     * @return The group info boolean value of the specified group in the specified world.
     */
    public abstract boolean getGroupInfoBoolean(String group, String node, boolean defaultValue);

    /**
     * Retrieves the group info boolean value of a group in a specific world.
     *
     * @param world        The world in which to look up the group info boolean value.
     * @param group        The group whose group info boolean value is being queried.
     * @param node         The node whose group info boolean value is being queried.
     * @param defaultValue The default value to return if the group info boolean value is not found.
     * @return The group info boolean value of the specified group in the specified world.
     */
    public abstract boolean getGroupInfoBoolean(String world, String group, String node, boolean defaultValue);

    /**
     * Sets the group info boolean value of a group.
     *
     * @param group The group whose group info boolean value is being set.
     * @param node  The node whose group info boolean value is being set.
     * @param value The value to set.
     */
    public abstract void setGroupInfoBoolean(String group, String node, boolean value);

    /**
     * Sets the group info boolean value of a group in a specific world.
     *
     * @param world The world in which to set the group info boolean value.
     * @param group The group whose group info boolean value is being set.
     * @param node  The node whose group info boolean value is being set.
     * @param value The value to set.
     */
    public abstract void setGroupInfoBoolean(String world, String group, String node, boolean value);

    /**
     * Retrieves the player info string value of a player.
     *
     * @param uuid         The UUID of the player whose player info string value is being queried.
     * @param node         The node whose player info string value is being queried.
     * @param defaultValue The default value to return if the player info string value is not found.
     * @return The player info string value of the specified player in the specified world.
     */
    public abstract String getPlayerInfoString(UUID uuid, String node, String defaultValue);

    @Deprecated
    public String getPlayerInfoString(@NotNull Player player, String node, String defaultValue) {
        return getPlayerInfoString(player.getUniqueId(), node, defaultValue);
    }

    @Deprecated
    public String getPlayerInfoString(@NotNull OfflinePlayer player, String node, String defaultValue) {
        return getPlayerInfoString(player.getUniqueId(), node, defaultValue);
    }

    @Deprecated
    public String getPlayerInfoString(@NotNull String playerName, String node, String defaultValue) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return getPlayerInfoString(player, node, defaultValue);
        } else {
            return getPlayerInfoString(Bukkit.getOfflinePlayer(playerName), node, defaultValue);
        }
    }

    /**
     * Retrieves the player info string value of a player in a specific world.
     *
     * @param world        The world in which to look up the player info string value.
     * @param uuid         The UUID of the player whose player info string value is being queried.
     * @param node         The node whose player info string value is being queried.
     * @param defaultValue The default value to return if the player info string value is not found.
     * @return The player info string value of the specified player in the specified world.
     */
    public abstract String getPlayerInfoString(String world, UUID uuid, String node, String defaultValue);

    @Deprecated
    public String getPlayerInfoString(String world, @NotNull Player player, String node, String defaultValue) {
        return getPlayerInfoString(world, player.getUniqueId(), node, defaultValue);
    }

    @Deprecated
    public String getPlayerInfoString(String world, @NotNull OfflinePlayer player, String node, String defaultValue) {
        return getPlayerInfoString(world, player.getUniqueId(), node, defaultValue);
    }

    @Deprecated
    public String getPlayerInfoString(String world, @NotNull String playerName, String node, String defaultValue) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return getPlayerInfoString(world, player, node, defaultValue);
        } else {
            return getPlayerInfoString(world, Bukkit.getOfflinePlayer(playerName), node, defaultValue);
        }
    }

    /**
     * Sets the player info string value of a player.
     *
     * @param uuid  The UUID of the player whose player info string value is being set.
     * @param node  The node whose player info string value is being set.
     * @param value The value to set.
     */
    public abstract void setPlayerInfoString(UUID uuid, String node, String value);

    @Deprecated
    public void setPlayerInfoString(@NotNull Player player, String node, String value) {
        setPlayerInfoString(player.getUniqueId(), node, value);
    }

    @Deprecated
    public void setPlayerInfoString(@NotNull OfflinePlayer player, String node, String value) {
        setPlayerInfoString(player.getUniqueId(), node, value);
    }

    @Deprecated
    public void setPlayerInfoString(@NotNull String playerName, String node, String value) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            setPlayerInfoString(player, node, value);
        } else {
            setPlayerInfoString(Bukkit.getOfflinePlayer(playerName), node, value);
        }
    }

    /**
     * Sets the player info string value of a player in a specific world.
     *
     * @param world The world in which to set the player info string value.
     * @param uuid  The UUID of the player whose player info string value is being set.
     * @param node  The node whose player info string value is being set.
     * @param value The value to set.
     */
    public abstract void setPlayerInfoString(String world, UUID uuid, String node, String value);

    @Deprecated
    public void setPlayerInfoString(String world, @NotNull Player player, String node, String value) {
        setPlayerInfoString(world, player.getUniqueId(), node, value);
    }

    @Deprecated
    public void setPlayerInfoString(String world, @NotNull OfflinePlayer player, String node, String value) {
        setPlayerInfoString(world, player.getUniqueId(), node, value);
    }

    @Deprecated
    public void setPlayerInfoString(String world, @NotNull String playerName, String node, String value) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            setPlayerInfoString(world, player, node, value);
        } else {
            setPlayerInfoString(world, Bukkit.getOfflinePlayer(playerName), node, value);
        }
    }

    /**
     * Retrieves the group info string value of a group.
     *
     * @param group        The group whose group info string value is being queried.
     * @param node         The node whose group info string value is being queried.
     * @param defaultValue The default value to return if the group info string value is not found.
     * @return The group info string value of the specified group in the specified world.
     */
    public abstract String getGroupInfoString(String group, String node, String defaultValue);

    /**
     * Retrieves the group info string value of a group in a specific world.
     *
     * @param world        The world in which to look up the group info string value.
     * @param group        The group whose group info string value is being queried.
     * @param node         The node whose group info string value is being queried.
     * @param defaultValue The default value to return if the group info string value is not found.
     * @return The group info string value of the specified group in the specified world.
     */
    public abstract String getGroupInfoString(String world, String group, String node, String defaultValue);

    /**
     * Sets the group info string value of a group.
     *
     * @param group The group whose group info string value is being set.
     * @param node  The node whose group info string value is being set.
     * @param value The value to set.
     */
    public abstract void setGroupInfoString(String group, String node, String value);

    /**
     * Sets the group info string value of a group in a specific world.
     *
     * @param world The world in which to set the group info string value.
     * @param group The group whose group info string value is being set.
     * @param node  The node whose group info string value is being set.
     * @param value The value to set.
     */
    public abstract void setGroupInfoString(String world, String group, String node, String value);

    /**
     * Checks if a player is in a specified group.
     *
     * @param uuid   The UUID of the player to check.
     * @param group  The group to check.
     * @return Whether the player is in the specified group in the specified world.
     */
    public boolean playerInGroup(UUID uuid, String group) {
        return permission.playerInGroup(uuid, group);
    }

    @Deprecated
    public boolean playerInGroup(@NotNull Player player, String group) {
        return playerInGroup(player.getUniqueId(), group);
    }

    @Deprecated
    public boolean playerInGroup(@NotNull OfflinePlayer player, String group) {
        return playerInGroup(player.getUniqueId(), group);
    }

    @Deprecated
    public boolean playerInGroup(@NotNull String playerName, String group) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return playerInGroup(player, group);
        } else {
            return playerInGroup(Bukkit.getOfflinePlayer(playerName), group);
        }
    }

    @Deprecated
    public boolean playerInGroup(String world, @NotNull Player player, String group) {
        return playerInGroup(player.getUniqueId(), group);
    }

    @Deprecated
    public boolean playerInGroup(String world, @NotNull OfflinePlayer player, String group) {
        return playerInGroup(player.getUniqueId(), group);
    }

    @Deprecated
    public boolean playerInGroup(String world, @NotNull String playerName, String group) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return playerInGroup(player, group);
        } else {
            return playerInGroup(Bukkit.getOfflinePlayer(playerName), group);
        }
    }

    /**
     * Gets all groups that a player is in.
     *
     * @param uuid   The UUID of the player to check.
     * @return An array of all groups that the player is in while in the specified world.
     */
    public String[] getPlayerGroups(UUID uuid) {
        return permission.getPlayerGroups(uuid);
    }

    @Deprecated
    public String[] getPlayerGroups(@NotNull Player player) {
        return getPlayerGroups(player.getUniqueId());
    }

    @Deprecated
    public String[] getPlayerGroups(@NotNull OfflinePlayer player) {
        return getPlayerGroups(player.getUniqueId());
    }

    @Deprecated
    public String[] getPlayerGroups(@NotNull String playerName) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return getPlayerGroups(player);
        } else {
            return getPlayerGroups(Bukkit.getOfflinePlayer(playerName));
        }
    }

    @Deprecated
    public String[] getPlayerGroups(String world, @NotNull Player player) {
        return getPlayerGroups(player.getUniqueId());
    }

    @Deprecated
    public String[] getPlayerGroups(String world, @NotNull OfflinePlayer player) {
        return getPlayerGroups(player.getUniqueId());
    }

    @Deprecated
    public String[] getPlayerGroups(String world, @NotNull String playerName) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return getPlayerGroups(player);
        } else {
            return getPlayerGroups(Bukkit.getOfflinePlayer(playerName));
        }
    }

    /**
     * Gets the primary group of a player in a specified world.
     *
     * @param uuid   The UUID of the player to check.
     * @return The primary group of the player in the specified world.
     */
    public String getPrimaryGroup(UUID uuid) {
        return permission.getPrimaryGroup(uuid);
    }

    @Deprecated
    public String getPrimaryGroup(@NotNull Player player) {
        return getPrimaryGroup(player.getUniqueId());
    }

    @Deprecated
    public String getPrimaryGroup(@NotNull OfflinePlayer player) {
        return getPrimaryGroup(player.getUniqueId());
    }

    @Deprecated
    public String getPrimaryGroup(@NotNull String playerName) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return getPrimaryGroup(player);
        } else {
            return getPrimaryGroup(Bukkit.getOfflinePlayer(playerName));
        }
    }

    @Deprecated
    public String getPrimaryGroup(String world, @NotNull Player player) {
        return getPrimaryGroup(player.getUniqueId());
    }

    @Deprecated
    public String getPrimaryGroup(String world, @NotNull OfflinePlayer player) {
        return getPrimaryGroup(player.getUniqueId());
    }

    @Deprecated
    public String getPrimaryGroup(String world, @NotNull String playerName) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return getPrimaryGroup(player);
        } else {
            return getPrimaryGroup(Bukkit.getOfflinePlayer(playerName));
        }
    }

    /**
     * Gets all registered groups.
     *
     * @return An array of all registered groups.
     */
    public String[] getGroups() {
        return permission.getGroups();
    }
}
