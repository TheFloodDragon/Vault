package net.milkbowl.vault.permission;

import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * Abstract class for Vault's Permission API.
 *
 * @author Foulest
 * @project Vault
 */
@SuppressWarnings({"DeprecatedIsStillUsed", "unused", "SameReturnValue"})
public abstract class Permission {

    protected Plugin plugin = null;

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
     * Check if a player has a specific permission in a given world.
     *
     * @param world      The world name.
     * @param player     The player name.
     * @param permission The permission node.
     * @return true if the player has the permission, false otherwise.
     * @deprecated Use {@link #playerHas(Player, String) playerHas} instead.
     */
    @Deprecated
    public boolean has(String world, String player, String permission) {
        return world == null ? this.playerHas((String) null, player, permission) : this.playerHas(world, player, permission);
    }

    /**
     * Check if a player has a specific permission in a given world.
     *
     * @param world      The world.
     * @param player     The player name.
     * @param permission The permission node.
     * @return true if the player has the permission, false otherwise.
     * @deprecated Use {@link #playerHas(Player, String) playerHas} instead.
     */
    @Deprecated
    public boolean has(World world, String player, String permission) {
        return world == null ? this.playerHas((String) null, player, permission) : this.playerHas(world.getName(), player, permission);
    }

    /**
     * Check if a CommandSender has a specific permission.
     *
     * @param sender     The CommandSender.
     * @param permission The permission node.
     * @return true if the CommandSender has the permission, false otherwise.
     */
    public boolean has(@NotNull CommandSender sender, String permission) {
        return sender.hasPermission(permission);
    }

    /**
     * Check if a Player has a specific permission.
     *
     * @param player     The Player.
     * @param permission The permission node.
     * @return true if the Player has the permission, false otherwise.
     */
    public boolean has(@NotNull Player player, String permission) {
        return player.hasPermission(permission);
    }

    /**
     * Check if a player has a specific permission in a given world.
     *
     * @param world      The world name.
     * @param player     The player name.
     * @param permission The permission node.
     * @return true if the player has the permission, false otherwise.
     * @deprecated Use {@link #playerHas(Player, String) playerHas} instead.
     */
    @Deprecated
    public abstract boolean playerHas(String world, String player, String permission);

    /**
     * Check if a player has a specific permission in a given world.
     *
     * @param world      The world.
     * @param player     The player name.
     * @param permission The permission node.
     * @return true if the player has the permission, false otherwise.
     * @deprecated Use {@link #playerHas(Player, String) playerHas} instead.
     */
    @Deprecated
    public boolean playerHas(World world, String player, String permission) {
        return world == null ? this.playerHas((String) null, player, permission) : this.playerHas(world.getName(), player, permission);
    }

    /**
     * Check if an offline player has a specific permission in a given world.
     *
     * @param world      The world name.
     * @param player     The OfflinePlayer.
     * @param permission The permission node.
     * @return true if the player has the permission, false otherwise.
     */
    public boolean playerHas(String world, OfflinePlayer player, String permission) {
        return world == null ? this.has((String) null, player.getName(), permission) : this.has(world, player.getName(), permission);
    }

    /**
     * Check if a player has a specific permission in a given world.
     *
     * @param player     The player name.
     * @param permission The permission node.
     * @return true if the player has the permission, false otherwise.
     */
    public boolean playerHas(Player player, String permission) {
        return this.has(player, permission);
    }

    /**
     * Add a permission to a player in a specified world.
     *
     * @param world      The world name.
     * @param player     The player name.
     * @param permission The permission node.
     * @return true if the permission was successfully added, false otherwise.
     * @deprecated Use {@link #playerAdd(Player, String) playerAdd} instead.
     */
    @Deprecated
    public abstract boolean playerAdd(String world, String player, String permission);

    /**
     * Add a permission to a player in a specified world.
     *
     * @param world      The world.
     * @param player     The player name.
     * @param permission The permission node.
     * @return true if the permission was successfully added, false otherwise.
     * @deprecated Use {@link #playerAdd(Player, String) playerAdd} instead.
     */
    @Deprecated
    public boolean playerAdd(World world, String player, String permission) {
        return world == null ? this.playerAdd((String) null, player, permission) : this.playerAdd(world.getName(), player, permission);
    }

    /**
     * Add a permission to an offline player in a specified world.
     *
     * @param world      The world name.
     * @param player     The OfflinePlayer.
     * @param permission The permission node.
     * @return true if the permission was successfully added, false otherwise.
     */
    public boolean playerAdd(String world, OfflinePlayer player, String permission) {
        return world == null ? this.playerAdd((String) null, player.getName(), permission) : this.playerAdd(world, player.getName(), permission);
    }

    /**
     * Add a permission to a player.
     *
     * @param player     The Player.
     * @param permission The permission node.
     * @return true if the permission was successfully added, false otherwise.
     */
    public boolean playerAdd(Player player, String permission) {
        return this.playerAdd(player.getWorld().getName(), player, permission);
    }

    /**
     * Add a transient permission to an offline player.
     * Transient permissions are not stored and are typically cleared when a player logs out.
     *
     * @param player     The OfflinePlayer.
     * @param permission The transient permission node.
     * @return true if the transient permission was successfully added, false otherwise.
     * @throws UnsupportedOperationException If the permission system does not support offline player transient permissions.
     */
    public boolean playerAddTransient(@NotNull OfflinePlayer player, String permission) throws UnsupportedOperationException {
        if (player.isOnline()) {
            return this.playerAddTransient((Player) player, permission);
        } else {
            throw new UnsupportedOperationException(this.getName() + " does not support offline player transient permissions.");
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
        Iterator<PermissionAttachmentInfo> iterator = player.getEffectivePermissions().iterator();
        PermissionAttachmentInfo paInfo;

        do {
            if (!iterator.hasNext()) {
                PermissionAttachment attach = player.addAttachment(this.plugin);
                attach.setPermission(permission, true);
                return true;
            }
            paInfo = iterator.next();
        } while (paInfo.getAttachment() == null || !paInfo.getAttachment().getPlugin().equals(this.plugin));

        paInfo.getAttachment().setPermission(permission, true);
        return true;
    }

    /**
     * Add a transient permission to an offline player in a specified world.
     * Transient permissions are not stored and are typically cleared when a player logs out.
     *
     * @param worldName  The name of the world.
     * @param player     The OfflinePlayer.
     * @param permission The transient permission node.
     * @return true if the transient permission was successfully added, false otherwise.
     * @throws UnsupportedOperationException If the permission system does not support offline player transient permissions.
     */
    public boolean playerAddTransient(String worldName, OfflinePlayer player, String permission) {
        return this.playerAddTransient(player, permission);
    }

    /**
     * Add a transient permission to a player in a specified world.
     * Transient permissions are not stored and are typically cleared when a player logs out.
     *
     * @param worldName  The name of the world.
     * @param player     The Player.
     * @param permission The transient permission node.
     * @return true if the transient permission was successfully added, false otherwise.
     */
    public boolean playerAddTransient(String worldName, Player player, String permission) {
        return this.playerAddTransient(player, permission);
    }

    /**
     * Remove a transient permission from an offline player.
     * Transient permissions are not stored and are typically cleared when a player logs out.
     *
     * @param worldName  The name of the world.
     * @param player     The OfflinePlayer.
     * @param permission The transient permission node.
     * @return true if the transient permission was successfully removed, false otherwise.
     */
    public boolean playerRemoveTransient(String worldName, OfflinePlayer player, String permission) {
        return this.playerRemoveTransient(player, permission);
    }

    /**
     * Remove a transient permission from a player.
     * Transient permissions are not stored and are typically cleared when a player logs out.
     *
     * @param worldName  The name of the world.
     * @param player     The Player.
     * @param permission The transient permission node.
     * @return true if the transient permission was successfully removed, false otherwise.
     */
    public boolean playerRemoveTransient(String worldName, Player player, String permission) {
        return this.playerRemoveTransient((OfflinePlayer) player, permission);
    }

    /**
     * Remove a permission from a player in a specified world.
     *
     * @param player     The Player.
     * @param permission The permission node.
     * @return true if the permission was successfully added, false otherwise.
     * @deprecated Use {@link #playerRemove(Player, String) playerRemove} instead.
     */
    @Deprecated
    public abstract boolean playerRemove(String world, String player, String permission);

    /**
     * Remove a permission from an offline player in a specified world.
     *
     * @param player     The Player.
     * @param permission The permission node.
     * @return true if the permission was successfully added, false otherwise.
     */
    public boolean playerRemove(String world, OfflinePlayer player, String permission) {
        return world == null ? this.playerRemove((String) null, player.getName(), permission) : this.playerRemove(world, player.getName(), permission);
    }

    /**
     * Remove a permission from a player in a specified world.
     *
     * @param player     The Player.
     * @param permission The permission node.
     * @return true if the permission was successfully added, false otherwise.
     * @deprecated Use {@link #playerRemove(Player, String) playerRemove} instead.
     */
    @Deprecated
    public boolean playerRemove(World world, String player, String permission) {
        return world == null ? this.playerRemove((String) null, player, permission) : this.playerRemove(world.getName(), player, permission);
    }

    /**
     * Remove a permission from a player.
     *
     * @param player     The Player.
     * @param permission The permission node.
     * @return true if the permission was successfully added, false otherwise.
     */
    public boolean playerRemove(Player player, String permission) {
        return this.playerRemove(player.getWorld().getName(), player, permission);
    }

    /**
     * Remove a transient permission from an offline player.
     * Transient permissions are not stored and are typically cleared when a player logs out.
     *
     * @param player     The OfflinePlayer.
     * @param permission The transient permission node.
     * @return true if the transient permission was successfully removed, false otherwise.
     */
    public boolean playerRemoveTransient(@NotNull OfflinePlayer player, String permission) {
        return player.isOnline() && this.playerRemoveTransient((Player) player, permission);
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
        } while (paInfo.getAttachment() == null || !paInfo.getAttachment().getPlugin().equals(this.plugin));

        paInfo.getAttachment().unsetPermission(permission);
        return true;
    }

    /**
     * Check if a group has a specific permission in a given world.
     *
     * @param world      The world name.
     * @param group      The group name.
     * @param permission The permission node.
     * @return true if the player has the permission, false otherwise.
     */
    public abstract boolean groupHas(String world, String group, String permission);

    /**
     * Check if a group has a specific permission in a given world.
     *
     * @param world      The world.
     * @param group      The group name.
     * @param permission The permission node.
     * @return true if the player has the permission, false otherwise.
     */
    public boolean groupHas(World world, String group, String permission) {
        return world == null ? this.groupHas((String) null, group, permission) : this.groupHas(world.getName(), group, permission);
    }

    /**
     * Add a permission to a group in a specified world.
     *
     * @param world      The world name.
     * @param group      The group name.
     * @param permission The permission node.
     * @return true if the permission was successfully added, false otherwise.
     */
    public abstract boolean groupAdd(String world, String group, String permission);

    /**
     * Add a permission to a group in a specified world.
     *
     * @param world      The world.
     * @param group      The group name.
     * @param permission The permission node.
     * @return true if the permission was successfully added, false otherwise.
     */
    public boolean groupAdd(World world, String group, String permission) {
        return world == null ? this.groupAdd((String) null, group, permission) : this.groupAdd(world.getName(), group, permission);
    }

    /**
     * Remove a permission from a group in a specified world.
     *
     * @param world      The world name.
     * @param group      The group name.
     * @param permission The permission node.
     * @return true if the permission was successfully removed, false otherwise.
     */
    public abstract boolean groupRemove(String world, String group, String permission);

    /**
     * Remove a permission from a group in a specified world.
     *
     * @param world      The world.
     * @param group      The group name.
     * @param permission The permission node.
     * @return true if the permission was successfully removed, false otherwise.
     */
    public boolean groupRemove(World world, String group, String permission) {
        return world == null ? this.groupRemove((String) null, group, permission) : this.groupRemove(world.getName(), group, permission);
    }

    /**
     * Check if a player is in a group in a specified world.
     *
     * @param world  The world name.
     * @param player The player name.
     * @param group  The group name.
     * @return true if the player is in the group, false otherwise.
     * @deprecated Use {@link #playerInGroup(Player, String) playerInGroup} instead.
     */
    @Deprecated
    public abstract boolean playerInGroup(String world, String player, String group);

    /**
     * Check if a player is in a group in a specified world.
     *
     * @param world  The world.
     * @param player The player name.
     * @param group  The group name.
     * @return true if the player is in the group, false otherwise.
     * @deprecated Use {@link #playerInGroup(Player, String) playerInGroup} instead.
     */
    @Deprecated
    public boolean playerInGroup(World world, String player, String group) {
        return world == null ? this.playerInGroup((String) null, player, group) : this.playerInGroup(world.getName(), player, group);
    }

    /**
     * Check if an offline player is in a group in a specified world.
     *
     * @param world  The world name.
     * @param player The OfflinePlayer.
     * @param group  The group name.
     * @return true if the player is in the group, false otherwise.
     */
    public boolean playerInGroup(String world, OfflinePlayer player, String group) {
        return world == null ? this.playerInGroup((String) null, player.getName(), group) : this.playerInGroup(world, player.getName(), group);
    }

    /**
     * Check if a player is in a group in a specified world.
     *
     * @param player The Player.
     * @param group  The group name.
     * @return true if the player is in the group, false otherwise.
     */
    public boolean playerInGroup(Player player, String group) {
        return this.playerInGroup(player.getWorld().getName(), player, group);
    }

    /**
     * Add a player to a group in a specified world.
     *
     * @param world  The world name.
     * @param player The player name.
     * @param group  The group name.
     * @return true if the player was successfully added to the group, false otherwise.
     * @deprecated Use {@link #playerAddGroup(Player, String) playerAddGroup} instead.
     */
    @Deprecated
    public abstract boolean playerAddGroup(String world, String player, String group);

    /**
     * Add a player to a group in a specified world.
     *
     * @param world  The world.
     * @param player The player name.
     * @param group  The group name.
     * @return true if the player was successfully added to the group, false otherwise.
     * @deprecated Use {@link #playerAddGroup(Player, String) playerAddGroup} instead.
     */
    @Deprecated
    public boolean playerAddGroup(World world, String player, String group) {
        return world == null ? this.playerAddGroup((String) null, player, group) : this.playerAddGroup(world.getName(), player, group);
    }

    /**
     * Add a player to a group in a specified world.
     *
     * @param world  The world name.
     * @param player The OfflinePlayer.
     * @param group  The group name.
     * @return true if the player was successfully added to the group, false otherwise.
     */
    public boolean playerAddGroup(String world, OfflinePlayer player, String group) {
        return world == null ? this.playerAddGroup((String) null, player.getName(), group) : this.playerAddGroup(world, player.getName(), group);
    }

    /**
     * Add a player to a group in a specified world.
     *
     * @param player The Player.
     * @param group  The group name.
     * @return true if the player was successfully added to the group, false otherwise.
     */
    public boolean playerAddGroup(Player player, String group) {
        return this.playerAddGroup(player.getWorld().getName(), player, group);
    }

    /**
     * Remove a player from a group in a specified world.
     *
     * @param world  The world name.
     * @param player The player name.
     * @param group  The group name.
     * @return true if the player was successfully removed from the group, false otherwise.
     * @deprecated Use {@link #playerRemoveGroup(Player, String) playerRemoveGroup} instead.
     */
    @Deprecated
    public abstract boolean playerRemoveGroup(String world, String player, String group);

    /**
     * Remove a player from a group in a specified world.
     *
     * @param world  The world.
     * @param player The player name.
     * @param group  The group name.
     * @return true if the player was successfully removed from the group, false otherwise.
     * @deprecated Use {@link #playerRemoveGroup(Player, String) playerRemoveGroup} instead.
     */
    @Deprecated
    public boolean playerRemoveGroup(World world, String player, String group) {
        return world == null ? this.playerRemoveGroup((String) null, player, group) : this.playerRemoveGroup(world.getName(), player, group);
    }

    /**
     * Remove a player from a group in a specified world.
     *
     * @param world  The world name.
     * @param player The OfflinePlayer.
     * @param group  The group name.
     * @return true if the player was successfully removed from the group, false otherwise.
     */
    public boolean playerRemoveGroup(String world, OfflinePlayer player, String group) {
        return world == null ? this.playerRemoveGroup((String) null, player.getName(), group) : this.playerRemoveGroup(world, player.getName(), group);
    }

    /**
     * Remove a player from a group in a specified world.
     *
     * @param player The Player.
     * @param group  The group name.
     * @return true if the player was successfully removed from the group, false otherwise.
     */
    public boolean playerRemoveGroup(Player player, String group) {
        return this.playerRemoveGroup(player.getWorld().getName(), player, group);
    }

    /**
     * Get a list of all groups a player is in while specifying a world.
     *
     * @param world  The world name.
     * @param player The player name.
     * @return An array of all loaded groups.
     * @deprecated Use {@link #getPlayerGroups(Player) getPlayerGroups} instead.
     */
    @Deprecated
    public abstract String[] getPlayerGroups(String world, String player);

    /**
     * Get a list of all groups a player is in while specifying a world.
     *
     * @param world  The world.
     * @param player The player name.
     * @return An array of all loaded groups.
     * @deprecated Use {@link #getPlayerGroups(Player) getPlayerGroups} instead.
     */
    @Deprecated
    public String[] getPlayerGroups(World world, String player) {
        return world == null ? this.getPlayerGroups((String) null, player) : this.getPlayerGroups(world.getName(), player);
    }

    /**
     * Get a list of all groups an offline player is in while specifying a world.
     *
     * @param world  The world name.
     * @param player The OfflinePlayer.
     * @return An array of all loaded groups.
     */
    public String[] getPlayerGroups(String world, @NotNull OfflinePlayer player) {
        return this.getPlayerGroups(world, player.getName());
    }

    /**
     * Get a list of all groups a player is in.
     *
     * @param player The Player.
     * @return An array of all loaded groups.
     */
    public String[] getPlayerGroups(Player player) {
        return this.getPlayerGroups(player.getWorld().getName(), player);
    }

    /**
     * Get the primary group of a player in a specified world.
     *
     * @param world  The world name.
     * @param player The player name.
     * @return The primary group.
     * @deprecated Use {@link #getPrimaryGroup(Player) getPrimaryGroup} instead.
     */
    @Deprecated
    public abstract String getPrimaryGroup(String world, String player);

    /**
     * Get the primary group of a player in a specified world.
     *
     * @param world  The world.
     * @param player The player name.
     * @return The primary group.
     * @deprecated Use {@link #getPrimaryGroup(Player) getPrimaryGroup} instead.
     */
    @Deprecated
    public String getPrimaryGroup(World world, String player) {
        return world == null ? this.getPrimaryGroup((String) null, player) : this.getPrimaryGroup(world.getName(), player);
    }

    /**
     * Get the primary group of an offline player in a specified world.
     *
     * @param world  The world name.
     * @param player The OfflinePlayer.
     * @return The primary group.
     */
    public String getPrimaryGroup(String world, @NotNull OfflinePlayer player) {
        return this.getPrimaryGroup(world, player.getName());
    }

    /**
     * Get the primary group of a player.
     *
     * @param player The Player.
     * @return The primary group.
     */
    public String getPrimaryGroup(Player player) {
        return this.getPrimaryGroup(player.getWorld().getName(), player);
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
