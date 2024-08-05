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
package net.milkbowl.vault.permission;

import lombok.NoArgsConstructor;
import net.milkbowl.vault.util.ConstantUtil;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.UUID;

/**
 * Abstract class for Vault's Permission API.
 *
 * @author Foulest
 */
@NoArgsConstructor
@SuppressWarnings({"unused", "WeakerAccess"})
public abstract class Permission {

    protected Plugin plugin;

    /**
     * Get the name of the permission system.
     *
     * @return The name of the permission system.
     */
    public abstract String getName();

    /**
     * Check if the permission system is enabled.
     *
     * @return true if the permission system is enabled, false otherwise.
     */
    public abstract boolean isEnabled();

    /**
     * Check if the permission system has compatibility with SuperPerms.
     *
     * @return true if SuperPerms compatibility is enabled, false otherwise.
     */
    public abstract boolean hasSuperPermsCompat();

    /**
     * Check if a player has a specific permission.
     *
     * @param uuid       The UUID of the player.
     * @param permission The permission node.
     * @return true if the player has the permission, false otherwise.
     */
    public abstract boolean playerHas(UUID uuid, String permission);

    @Deprecated
    public boolean playerHas(@NotNull Player player, String permission) {
        return playerHas(player.getUniqueId(), permission);
    }

    @Deprecated
    public boolean playerHas(@NotNull OfflinePlayer player, String permission) {
        return playerHas(player.getUniqueId(), permission);
    }

    @Deprecated
    public boolean playerHas(@NotNull String playerName, String permission) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return playerHas(player, permission);
        } else {
            return playerHas(Bukkit.getOfflinePlayer(playerName), permission);
        }
    }

    @Deprecated
    public boolean playerHas(String world, @NotNull Player player, String permission) {
        return playerHas(player.getUniqueId(), permission);
    }

    @Deprecated
    public boolean playerHas(String world, @NotNull OfflinePlayer player, String permission) {
        return playerHas(player.getUniqueId(), permission);
    }

    @Deprecated
    public boolean playerHas(String world, @NotNull String playerName, String permission) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return playerHas(player, permission);
        } else {
            return playerHas(Bukkit.getOfflinePlayer(playerName), permission);
        }
    }

    /**
     * Add a permission to a player in a specified world.
     *
     * @param uuid       The UUID of the player.
     * @param permission The permission node.
     * @return true if the permission was successfully added, false otherwise.
     */
    public abstract boolean playerAdd(UUID uuid, String permission);

    @Deprecated
    public boolean playerAdd(@NotNull Player player, String permission) {
        return playerAdd(player.getUniqueId(), permission);
    }

    @Deprecated
    public boolean playerAdd(@NotNull OfflinePlayer player, String permission) {
        return playerAdd(player.getUniqueId(), permission);
    }

    @Deprecated
    public boolean playerAdd(@NotNull String playerName, String permission) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return playerAdd(player, permission);
        } else {
            return playerAdd(Bukkit.getOfflinePlayer(playerName), permission);
        }
    }

    @Deprecated
    public boolean playerAdd(String world, @NotNull Player player, String permission) {
        return playerAdd(player.getUniqueId(), permission);
    }

    @Deprecated
    public boolean playerAdd(String world, @NotNull OfflinePlayer player, String permission) {
        return playerAdd(player.getUniqueId(), permission);
    }

    @Deprecated
    public boolean playerAdd(String world, @NotNull String playerName, String permission) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return playerAdd(player, permission);
        } else {
            return playerAdd(Bukkit.getOfflinePlayer(playerName), permission);
        }
    }

    /**
     * Remove a permission from a player in a specified world.
     *
     * @param uuid       The Player.
     * @param permission The permission node.
     * @return true if the permission was successfully added, false otherwise.
     */
    public abstract boolean playerRemove(UUID uuid, String permission);

    @Deprecated
    public boolean playerRemove(@NotNull Player player, String permission) {
        return playerRemove(player.getUniqueId(), permission);
    }

    @Deprecated
    public boolean playerRemove(@NotNull OfflinePlayer player, String permission) {
        return playerRemove(player.getUniqueId(), permission);
    }

    @Deprecated
    public boolean playerRemove(@NotNull String playerName, String permission) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return playerRemove(player, permission);
        } else {
            return playerRemove(Bukkit.getOfflinePlayer(playerName), permission);
        }
    }

    @Deprecated
    public boolean playerRemove(String world, @NotNull Player player, String permission) {
        return playerRemove(player.getUniqueId(), permission);
    }

    @Deprecated
    public boolean playerRemove(String world, @NotNull OfflinePlayer player, String permission) {
        return playerRemove(player.getUniqueId(), permission);
    }

    @Deprecated
    public boolean playerRemove(String world, @NotNull String playerName, String permission) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return playerRemove(player, permission);
        } else {
            return playerRemove(Bukkit.getOfflinePlayer(playerName), permission);
        }
    }

    /**
     * Add a transient permission to an offline player.
     * Transient permissions are not stored and are typically cleared when a player logs out.
     *
     * @param uuid       The UUID of the player.
     * @param permission The transient permission node.
     * @return true if the transient permission was successfully added, false otherwise.
     * @throws UnsupportedOperationException If the permission system does not support offline player transient permissions.
     */
    public boolean playerAddTransient(@NotNull UUID uuid, String permission) {
        Player player = plugin.getServer().getPlayer(uuid);

        if (player == null) {
            throw new UnsupportedOperationException(getName() + ConstantUtil.NO_TRANSIENT_PERMISSIONS);
        }

        if (player.isOnline()) {
            return playerAddTransient(player, permission);
        } else {
            throw new UnsupportedOperationException(getName() + ConstantUtil.NO_TRANSIENT_PERMISSIONS);
        }
    }

    /**
     * Add a transient permission to a player.
     * Transient permissions are not stored and are typically cleared when a player logs out.
     *
     * @param player     The Player.
     * @param permission The transient permission node.
     * @return true if the transient permission was successfully added, false otherwise.
     */
    public boolean playerAddTransient(@NotNull Player player, String permission) {
        try {
            Iterator<PermissionAttachmentInfo> iterator = player.getEffectivePermissions().iterator();
            PermissionAttachmentInfo paInfo;

            while (iterator.hasNext()) {
                paInfo = iterator.next();

                if (paInfo.getAttachment() != null && paInfo.getAttachment().getPlugin().equals(plugin)) {
                    paInfo.getAttachment().setPermission(permission, true);
                    return true;
                }
            }

            PermissionAttachment attach = player.addAttachment(plugin);
            attach.setPermission(permission, true);
            return true;
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Remove a transient permission from a player.
     * Transient permissions are not stored and are typically cleared when a player logs out.
     *
     * @param uuid       The UUID of the player.
     * @param permission The transient permission node.
     * @return true if the transient permission was successfully removed, false otherwise.
     */
    public boolean playerRemoveTransient(@NotNull UUID uuid, String permission) {
        Player player = plugin.getServer().getPlayer(uuid);

        if (player == null) {
            throw new UnsupportedOperationException(getName() + ConstantUtil.NO_TRANSIENT_PERMISSIONS);
        }

        if (player.isOnline()) {
            return playerRemoveTransient(player, permission);
        } else {
            throw new UnsupportedOperationException(getName() + ConstantUtil.NO_TRANSIENT_PERMISSIONS);
        }
    }

    /**
     * Remove a transient permission from a player.
     * Transient permissions are not stored and are typically cleared when a player logs out.
     *
     * @param player     The Player.
     * @param permission The transient permission node.
     * @return true if the transient permission was successfully removed, false otherwise.
     */
    public boolean playerRemoveTransient(@NotNull Player player, String permission) {
        Iterator<PermissionAttachmentInfo> iterator = player.getEffectivePermissions().iterator();
        PermissionAttachmentInfo paInfo;

        do {
            if (!iterator.hasNext()) {
                return false;
            }
            paInfo = iterator.next();
        } while (paInfo.getAttachment() == null || !paInfo.getAttachment().getPlugin().equals(plugin));

        paInfo.getAttachment().unsetPermission(permission);
        return true;
    }

    /**
     * Check if a group has a specific permission in a given world.
     *
     * @param group      The group name.
     * @param permission The permission node.
     * @return true if the player has the permission, false otherwise.
     */
    public abstract boolean groupHas(String group, String permission);

    /**
     * Add a permission to a group in a specified world.
     *
     * @param group      The group name.
     * @param permission The permission node.
     * @return true if the permission was successfully added, false otherwise.
     */
    public abstract boolean groupAdd(String group, String permission);

    /**
     * Remove a permission from a group in a specified world.
     *
     * @param group      The group name.
     * @param permission The permission node.
     * @return true if the permission was successfully removed, false otherwise.
     */
    public abstract boolean groupRemove(String group, String permission);

    /**
     * Check if a player is in a group in a specified world.
     *
     * @param uuid   The UUID of the player.
     * @param group  The group name.
     * @return true if the player is in the group, false otherwise.
     */
    public abstract boolean playerInGroup(UUID uuid, String group);

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
     * Add a player to a group in a specified world.
     *
     * @param uuid  The UUID of the player.
     * @param group  The group name.
     * @return true if the player was successfully added to the group, false otherwise.
     */
    public abstract boolean playerAddGroup(UUID uuid, String group);

    @Deprecated
    public boolean playerAddGroup(@NotNull Player player, String group) {
        return playerAddGroup(player.getUniqueId(), group);
    }

    @Deprecated
    public boolean playerAddGroup(@NotNull OfflinePlayer player, String group) {
        return playerAddGroup(player.getUniqueId(), group);
    }

    @Deprecated
    public boolean playerAddGroup(@NotNull String playerName, String group) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return playerAddGroup(player, group);
        } else {
            return playerAddGroup(Bukkit.getOfflinePlayer(playerName), group);
        }
    }

    @Deprecated
    public boolean playerAddGroup(String world, @NotNull Player player, String group) {
        return playerAddGroup(player.getUniqueId(), group);
    }

    @Deprecated
    public boolean playerAddGroup(String world, @NotNull OfflinePlayer player, String group) {
        return playerAddGroup(player.getUniqueId(), group);
    }

    @Deprecated
    public boolean playerAddGroup(String world, @NotNull String playerName, String group) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return playerAddGroup(player, group);
        } else {
            return playerAddGroup(Bukkit.getOfflinePlayer(playerName), group);
        }
    }

    /**
     * Remove a player from a group in a specified world.
     *
     * @param uuid The UUID of the player.
     * @param group  The group name.
     * @return true if the player was successfully removed from the group, false otherwise.
     */
    public abstract boolean playerRemoveGroup(UUID uuid, String group);

    @Deprecated
    public boolean playerRemoveGroup(@NotNull Player player, String group) {
        return playerRemoveGroup(player.getUniqueId(), group);
    }

    @Deprecated
    public boolean playerRemoveGroup(@NotNull OfflinePlayer player, String group) {
        return playerRemoveGroup(player.getUniqueId(), group);
    }

    @Deprecated
    public boolean playerRemoveGroup(@NotNull String playerName, String group) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return playerRemoveGroup(player, group);
        } else {
            return playerRemoveGroup(Bukkit.getOfflinePlayer(playerName), group);
        }
    }

    @Deprecated
    public boolean playerRemoveGroup(String world, @NotNull Player player, String group) {
        return playerRemoveGroup(player.getUniqueId(), group);
    }

    @Deprecated
    public boolean playerRemoveGroup(String world, @NotNull OfflinePlayer player, String group) {
        return playerRemoveGroup(player.getUniqueId(), group);
    }

    @Deprecated
    public boolean playerRemoveGroup(String world, @NotNull String playerName, String group) {
        Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return playerRemoveGroup(player, group);
        } else {
            return playerRemoveGroup(Bukkit.getOfflinePlayer(playerName), group);
        }
    }

    /**
     * Get a list of all groups a player is in while specifying a world.
     *
     * @param uuid  The UUID of the player.
     * @return An array of all loaded groups.
     */
    public abstract String[] getPlayerGroups(UUID uuid);

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
     * Get the primary group of a player in a specified world.
     *
     * @param uuid The UUID of the player.
     * @return The primary group.
     */
    public abstract String getPrimaryGroup(UUID uuid);

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
     * Get a list of all loaded groups.
     *
     * @return An array of all loaded groups.
     */
    public abstract String[] getGroups();

    /**
     * Check if the permission system supports group permissions.
     *
     * @return true if the permission system supports group permissions, false otherwise.
     */
    public abstract boolean hasGroupSupport();
}
