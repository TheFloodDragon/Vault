package net.milkbowl.vault.chat;

import lombok.AllArgsConstructor;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Abstract class for Vault's Chat API.
 *
 * @author Foulest
 * @project Vault
 */
@AllArgsConstructor
@SuppressWarnings({"DeprecatedIsStillUsed", "unused"})
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
     * Retrieves the prefix of a player in a specific world.
     *
     * @param world  The world in which to look up the prefix.
     * @param player The player whose prefix is being queried.
     * @return The player's prefix in the specified world.
     * @deprecated Use {@link #getPlayerPrefix(String, OfflinePlayer)} instead.
     */
    @Deprecated
    public abstract String getPlayerPrefix(String world, String player);

    /**
     * Retrieves the prefix of an offline player in a specific world.
     *
     * @param world  The world in which to look up the prefix.
     * @param player The offline player whose prefix is being queried.
     * @return The offline player's prefix in the specified world.
     */
    public String getPlayerPrefix(String world, @NotNull OfflinePlayer player) {
        return this.getPlayerPrefix(world, player.getName());
    }

    /**
     * Retrieves the prefix of a player in a specific world.
     *
     * @param world  The world in which to look up the prefix.
     * @param player The player whose prefix is being queried.
     * @return The player's prefix in the specified world.
     * @deprecated Use {@link #getPlayerPrefix(String, OfflinePlayer)} instead.
     */
    @Deprecated
    public String getPlayerPrefix(@NotNull World world, String player) {
        return this.getPlayerPrefix(world.getName(), player);
    }

    /**
     * Retrieves the prefix of a player.
     *
     * @param player The player whose prefix is being queried.
     * @return The player's prefix.
     */
    public String getPlayerPrefix(Player player) {
        return this.getPlayerPrefix(player.getWorld().getName(), player);
    }

    /**
     * Sets the prefix of a player in a specific world.
     *
     * @param world  The world in which to set the prefix.
     * @param player The player whose prefix is being set.
     * @param prefix The prefix to set.
     * @deprecated Use {@link #setPlayerPrefix(String, OfflinePlayer, String)} instead.
     */
    @Deprecated
    public abstract void setPlayerPrefix(String world, String player, String prefix);

    /**
     * Sets the prefix of an offline player in a specific world.
     *
     * @param world  The world in which to set the prefix.
     * @param player The offline player whose prefix is being set.
     * @param prefix The prefix to set.
     */
    public void setPlayerPrefix(String world, @NotNull OfflinePlayer player, String prefix) {
        this.setPlayerPrefix(world, player.getName(), prefix);
    }

    /**
     * Sets the prefix of a player in a specific world.
     *
     * @param world  The world in which to set the prefix.
     * @param player The player whose prefix is being set.
     * @param prefix The prefix to set.
     * @deprecated Use {@link #setPlayerPrefix(String, OfflinePlayer, String)} instead.
     */
    @Deprecated
    public void setPlayerPrefix(@NotNull World world, String player, String prefix) {
        this.setPlayerPrefix(world.getName(), player, prefix);
    }

    /**
     * Sets the prefix of a player.
     *
     * @param player The player whose prefix is being set.
     * @param prefix The prefix to set.
     */
    public void setPlayerPrefix(Player player, String prefix) {
        this.setPlayerPrefix(player.getWorld().getName(), player, prefix);
    }

    /**
     * Retrieves the suffix of a player in a specific world.
     *
     * @param world  The world in which to look up the suffix.
     * @param player The player whose suffix is being queried.
     * @return The player's suffix in the specified world.
     * @deprecated Use {@link #getPlayerSuffix(String, OfflinePlayer)} instead.
     */
    @Deprecated
    public abstract String getPlayerSuffix(String world, String player);

    /**
     * Retrieves the suffix of an offline player in a specific world.
     *
     * @param world  The world in which to look up the suffix.
     * @param player The offline player whose suffix is being queried.
     * @return The offline player's suffix in the specified world.
     */
    public String getPlayerSuffix(String world, @NotNull OfflinePlayer player) {
        return this.getPlayerSuffix(world, player.getName());
    }

    /**
     * Retrieves the suffix of a player in a specific world.
     *
     * @param world  The world in which to look up the suffix.
     * @param player The player whose suffix is being queried.
     * @return The player's suffix in the specified world.
     * @deprecated Use {@link #getPlayerSuffix(String, OfflinePlayer)} instead.
     */
    @Deprecated
    public String getPlayerSuffix(@NotNull World world, String player) {
        return this.getPlayerSuffix(world.getName(), player);
    }

    /**
     * Retrieves the suffix of a player.
     *
     * @param player The player whose suffix is being queried.
     * @return The player's suffix.
     */
    public String getPlayerSuffix(Player player) {
        return this.getPlayerSuffix(player.getWorld().getName(), player);
    }

    /**
     * Sets the suffix of a player in a specific world.
     *
     * @param world  The world in which to set the suffix.
     * @param player The player whose suffix is being set.
     * @param suffix The suffix to set.
     * @deprecated Use {@link #setPlayerSuffix(String, OfflinePlayer, String)} instead.
     */
    @Deprecated
    public abstract void setPlayerSuffix(String world, String player, String suffix);

    /**
     * Sets the suffix of an offline player in a specific world.
     *
     * @param world  The world in which to set the suffix.
     * @param player The offline player whose suffix is being set.
     * @param suffix The suffix to set.
     */
    public void setPlayerSuffix(String world, @NotNull OfflinePlayer player, String suffix) {
        this.setPlayerSuffix(world, player.getName(), suffix);
    }

    /**
     * Sets the suffix of a player in a specific world.
     *
     * @param world  The world in which to set the suffix.
     * @param player The player whose suffix is being set.
     * @param suffix The suffix to set.
     * @deprecated Use {@link #setPlayerSuffix(String, OfflinePlayer, String)} instead.
     */
    @Deprecated
    public void setPlayerSuffix(@NotNull World world, String player, String suffix) {
        this.setPlayerSuffix(world.getName(), player, suffix);
    }

    /**
     * Sets the suffix of a player.
     *
     * @param player The player whose suffix is being set.
     * @param suffix The suffix to set.
     */
    public void setPlayerSuffix(Player player, String suffix) {
        this.setPlayerSuffix(player.getWorld().getName(), player, suffix);
    }

    /**
     * Retrieves the prefix of a group in a specific world.
     *
     * @param world The world in which to look up the prefix.
     * @param group The group whose prefix is being queried.
     * @return The group's prefix in the specified world.
     */
    public abstract String getGroupPrefix(String world, String group);

    /**
     * Retrieves the prefix of a group in a specific world.
     *
     * @param world The world in which to look up the prefix.
     * @param group The group whose prefix is being queried.
     * @return The group's prefix in the specified world.
     */
    public String getGroupPrefix(@NotNull World world, String group) {
        return this.getGroupPrefix(world.getName(), group);
    }

    /**
     * Sets the prefix of a group in a specific world.
     *
     * @param world  The world in which to set the prefix.
     * @param group  The group whose prefix is being set.
     * @param prefix The prefix to set.
     */
    public abstract void setGroupPrefix(String world, String group, String prefix);

    /**
     * Sets the prefix of a group in a specific world.
     *
     * @param world  The world in which to set the prefix.
     * @param group  The group whose prefix is being set.
     * @param prefix The prefix to set.
     */
    public void setGroupPrefix(@NotNull World world, String group, String prefix) {
        this.setGroupPrefix(world.getName(), group, prefix);
    }

    /**
     * Retrieves the suffix of a group in a specific world.
     *
     * @param world The world in which to look up the suffix.
     * @param group The group whose suffix is being queried.
     * @return The group's suffix in the specified world.
     */
    public abstract String getGroupSuffix(String world, String group);

    /**
     * Retrieves the suffix of a group in a specific world.
     *
     * @param world The world in which to look up the suffix.
     * @param group The group whose suffix is being queried.
     * @return The group's suffix in the specified world.
     */
    public String getGroupSuffix(@NotNull World world, String group) {
        return this.getGroupSuffix(world.getName(), group);
    }

    /**
     * Sets the suffix of a group in a specific world.
     *
     * @param world  The world in which to set the suffix.
     * @param group  The group whose suffix is being set.
     * @param suffix The suffix to set.
     */
    public abstract void setGroupSuffix(String world, String group, String suffix);

    /**
     * Sets the suffix of a group in a specific world.
     *
     * @param world  The world in which to set the suffix.
     * @param group  The group whose suffix is being set.
     * @param suffix The suffix to set.
     */
    public void setGroupSuffix(@NotNull World world, String group, String suffix) {
        this.setGroupSuffix(world.getName(), group, suffix);
    }

    /**
     * Retrieves the player info integer value of a player in a specific world.
     *
     * @param world        The world in which to look up the player info integer value.
     * @param player       The player whose player info integer value is being queried.
     * @param node         The node whose player info integer value is being queried.
     * @param defaultValue The default value to return if the player info integer value is not found.
     * @return The player info integer value of the specified player in the specified world.
     */
    public int getPlayerInfoInteger(String world, @NotNull OfflinePlayer player, String node, int defaultValue) {
        return this.getPlayerInfoInteger(world, player.getName(), node, defaultValue);
    }

    /**
     * Retrieves the player info integer value of a player in a specific world.
     *
     * @param world        The world in which to look up the player info integer value.
     * @param player       The player whose player info integer value is being queried.
     * @param node         The node whose player info integer value is being queried.
     * @param defaultValue The default value to return if the player info integer value is not found.
     * @return The player info integer value of the specified player in the specified world.
     * @deprecated Use {@link #getPlayerInfoInteger(String, OfflinePlayer, String, int)} instead.
     */
    @Deprecated
    public abstract int getPlayerInfoInteger(String world, String player, String node, int defaultValue);

    /**
     * Retrieves the player info integer value of a player in a specific world.
     *
     * @param world        The world in which to look up the player info integer value.
     * @param player       The player whose player info integer value is being queried.
     * @param node         The node whose player info integer value is being queried.
     * @param defaultValue The default value to return if the player info integer value is not found.
     * @return The player info integer value of the specified player in the specified world.
     * @deprecated Use {@link #getPlayerInfoInteger(String, OfflinePlayer, String, int)} instead.
     */
    @Deprecated
    public int getPlayerInfoInteger(@NotNull World world, String player, String node, int defaultValue) {
        return this.getPlayerInfoInteger(world.getName(), player, node, defaultValue);
    }

    /**
     * Retrieves the player info integer value of a player.
     *
     * @param player       The player whose player info integer value is being queried.
     * @param node         The node whose player info integer value is being queried.
     * @param defaultValue The default value to return if the player info integer value is not found.
     * @return The player info integer value of the specified player.
     */
    public int getPlayerInfoInteger(Player player, String node, int defaultValue) {
        return this.getPlayerInfoInteger(player.getWorld().getName(), player, node, defaultValue);
    }

    /**
     * Sets the player info integer value of a player in a specific world.
     *
     * @param world  The world in which to set the player info integer value.
     * @param player The player whose player info integer value is being set.
     * @param node   The node whose player info integer value is being set.
     * @param value  The value to set.
     */
    public void setPlayerInfoInteger(String world, @NotNull OfflinePlayer player, String node, int value) {
        this.setPlayerInfoInteger(world, player.getName(), node, value);
    }

    /**
     * Sets the player info integer value of a player in a specific world.
     *
     * @param world  The world in which to set the player info integer value.
     * @param player The player whose player info integer value is being set.
     * @param node   The node whose player info integer value is being set.
     * @param value  The value to set.
     * @deprecated Use {@link #setPlayerInfoInteger(String, OfflinePlayer, String, int)} instead.
     */
    @Deprecated
    public abstract void setPlayerInfoInteger(String world, String player, String node, int value);

    /**
     * Sets the player info integer value of a player in a specific world.
     *
     * @param world  The world in which to set the player info integer value.
     * @param player The player whose player info integer value is being set.
     * @param node   The node whose player info integer value is being set.
     * @param value  The value to set.
     * @deprecated Use {@link #setPlayerInfoInteger(String, OfflinePlayer, String, int)} instead.
     */
    @Deprecated
    public void setPlayerInfoInteger(@NotNull World world, String player, String node, int value) {
        this.setPlayerInfoInteger(world.getName(), player, node, value);
    }

    /**
     * Sets the player info integer value of a player.
     *
     * @param player The player whose player info integer value is being set.
     * @param node   The node whose player info integer value is being set.
     * @param value  The value to set.
     */
    public void setPlayerInfoInteger(Player player, String node, int value) {
        this.setPlayerInfoInteger(player.getWorld().getName(), player, node, value);
    }

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
     * Retrieves the group info integer value of a group in a specific world.
     *
     * @param world        The world in which to look up the group info integer value.
     * @param group        The group whose group info integer value is being queried.
     * @param node         The node whose group info integer value is being queried.
     * @param defaultValue The default value to return if the group info integer value is not found.
     * @return The group info integer value of the specified group in the specified world.
     */
    public int getGroupInfoInteger(@NotNull World world, String group, String node, int defaultValue) {
        return this.getGroupInfoInteger(world.getName(), group, node, defaultValue);
    }

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
     * Sets the group info integer value of a group in a specific world.
     *
     * @param world The world in which to set the group info integer value.
     * @param group The group whose group info integer value is being set.
     * @param node  The node whose group info integer value is being set.
     * @param value The value to set.
     */
    public void setGroupInfoInteger(@NotNull World world, String group, String node, int value) {
        this.setGroupInfoInteger(world.getName(), group, node, value);
    }

    /**
     * Retrieves the player info double value of a player in a specific world.
     *
     * @param world        The world in which to look up the player info double value.
     * @param player       The player whose player info double value is being queried.
     * @param node         The node whose player info double value is being queried.
     * @param defaultValue The default value to return if the player info double value is not found.
     * @return The player info double value of the specified player in the specified world.
     */
    public double getPlayerInfoDouble(String world, @NotNull OfflinePlayer player, String node, double defaultValue) {
        return this.getPlayerInfoDouble(world, player.getName(), node, defaultValue);
    }

    /**
     * Retrieves the player info double value of a player in a specific world.
     *
     * @param world        The world in which to look up the player info double value.
     * @param player       The player whose player info double value is being queried.
     * @param node         The node whose player info double value is being queried.
     * @param defaultValue The default value to return if the player info double value is not found.
     * @return The player info double value of the specified player in the specified world.
     * @deprecated Use {@link #getPlayerInfoDouble(String, OfflinePlayer, String, double)} instead.
     */
    @Deprecated
    public abstract double getPlayerInfoDouble(String world, String player, String node, double defaultValue);

    /**
     * Retrieves the player info double value of a player in a specific world.
     *
     * @param world        The world in which to look up the player info double value.
     * @param player       The player whose player info double value is being queried.
     * @param node         The node whose player info double value is being queried.
     * @param defaultValue The default value to return if the player info double value is not found.
     * @return The player info double value of the specified player in the specified world.
     * @deprecated Use {@link #getPlayerInfoDouble(String, OfflinePlayer, String, double)} instead.
     */
    @Deprecated
    public double getPlayerInfoDouble(@NotNull World world, String player, String node, double defaultValue) {
        return this.getPlayerInfoDouble(world.getName(), player, node, defaultValue);
    }

    /**
     * Retrieves the player info double value of a player.
     *
     * @param player       The player whose player info double value is being queried.
     * @param node         The node whose player info double value is being queried.
     * @param defaultValue The default value to return if the player info double value is not found.
     * @return The player info double value of the specified player.
     */
    public double getPlayerInfoDouble(Player player, String node, double defaultValue) {
        return this.getPlayerInfoDouble(player.getWorld().getName(), player, node, defaultValue);
    }

    /**
     * Sets the player info double value of a player in a specific world.
     *
     * @param world  The world in which to set the player info double value.
     * @param player The player whose player info double value is being set.
     * @param node   The node whose player info double value is being set.
     * @param value  The value to set.
     */
    public void setPlayerInfoDouble(String world, @NotNull OfflinePlayer player, String node, double value) {
        this.setPlayerInfoDouble(world, player.getName(), node, value);
    }

    /**
     * Sets the player info double value of a player in a specific world.
     *
     * @param world  The world in which to set the player info double value.
     * @param player The player whose player info double value is being set.
     * @param node   The node whose player info double value is being set.
     * @param value  The value to set.
     * @deprecated Use {@link #setPlayerInfoDouble(String, OfflinePlayer, String, double)} instead.
     */
    @Deprecated
    public abstract void setPlayerInfoDouble(String world, String player, String node, double value);

    /**
     * Sets the player info double value of a player in a specific world.
     *
     * @param world  The world in which to set the player info double value.
     * @param player The player whose player info double value is being set.
     * @param node   The node whose player info double value is being set.
     * @param value  The value to set.
     * @deprecated Use {@link #setPlayerInfoDouble(String, OfflinePlayer, String, double)} instead.
     */
    @Deprecated
    public void setPlayerInfoDouble(@NotNull World world, String player, String node, double value) {
        this.setPlayerInfoDouble(world.getName(), player, node, value);
    }

    /**
     * Sets the player info double value of a player.
     *
     * @param player The player whose player info double value is being set.
     * @param node   The node whose player info double value is being set.
     * @param value  The value to set.
     */
    public void setPlayerInfoDouble(Player player, String node, double value) {
        this.setPlayerInfoDouble(player.getWorld().getName(), player, node, value);
    }

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
     * Retrieves the group info double value of a group in a specific world.
     *
     * @param world        The world in which to look up the group info double value.
     * @param group        The group whose group info double value is being queried.
     * @param node         The node whose group info double value is being queried.
     * @param defaultValue The default value to return if the group info double value is not found.
     * @return The group info double value of the specified group in the specified world.
     */
    public double getGroupInfoDouble(@NotNull World world, String group, String node, double defaultValue) {
        return this.getGroupInfoDouble(world.getName(), group, node, defaultValue);
    }

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
     * Sets the group info double value of a group in a specific world.
     *
     * @param world The world in which to set the group info double value.
     * @param group The group whose group info double value is being set.
     * @param node  The node whose group info double value is being set.
     * @param value The value to set.
     */
    public void setGroupInfoDouble(@NotNull World world, String group, String node, double value) {
        this.setGroupInfoDouble(world.getName(), group, node, value);
    }

    /**
     * Retrieves the player info boolean value of a player in a specific world.
     *
     * @param world        The world in which to look up the player info boolean value.
     * @param player       The player whose player info boolean value is being queried.
     * @param node         The node whose player info boolean value is being queried.
     * @param defaultValue The default value to return if the player info boolean value is not found.
     * @return The player info boolean value of the specified player in the specified world.
     */
    public boolean getPlayerInfoBoolean(String world, @NotNull OfflinePlayer player, String node, boolean defaultValue) {
        return this.getPlayerInfoBoolean(world, player.getName(), node, defaultValue);
    }

    /**
     * Retrieves the player info boolean value of a player in a specific world.
     *
     * @param world        The world in which to look up the player info boolean value.
     * @param player       The player whose player info boolean value is being queried.
     * @param node         The node whose player info boolean value is being queried.
     * @param defaultValue The default value to return if the player info boolean value is not found.
     * @return The player info boolean value of the specified player in the specified world.
     * @deprecated Use {@link #getPlayerInfoBoolean(String, OfflinePlayer, String, boolean)} instead.
     */
    @Deprecated
    public abstract boolean getPlayerInfoBoolean(String world, String player, String node, boolean defaultValue);

    /**
     * Retrieves the player info boolean value of a player in a specific world.
     *
     * @param world        The world in which to look up the player info boolean value.
     * @param player       The player whose player info boolean value is being queried.
     * @param node         The node whose player info boolean value is being queried.
     * @param defaultValue The default value to return if the player info boolean value is not found.
     * @return The player info boolean value of the specified player in the specified world.
     * @deprecated Use {@link #getPlayerInfoBoolean(String, OfflinePlayer, String, boolean)} instead.
     */
    @Deprecated
    public boolean getPlayerInfoBoolean(@NotNull World world, String player, String node, boolean defaultValue) {
        return this.getPlayerInfoBoolean(world.getName(), player, node, defaultValue);
    }

    /**
     * Retrieves the player info boolean value of a player.
     *
     * @param player       The player whose player info boolean value is being queried.
     * @param node         The node whose player info boolean value is being queried.
     * @param defaultValue The default value to return if the player info boolean value is not found.
     * @return The player info boolean value of the specified player.
     */
    public boolean getPlayerInfoBoolean(Player player, String node, boolean defaultValue) {
        return this.getPlayerInfoBoolean(player.getWorld().getName(), player, node, defaultValue);
    }

    /**
     * Sets the player info boolean value of a player in a specific world.
     *
     * @param world  The world in which to set the player info boolean value.
     * @param player The player whose player info boolean value is being set.
     * @param node   The node whose player info boolean value is being set.
     * @param value  The value to set.
     */
    public void setPlayerInfoBoolean(String world, @NotNull OfflinePlayer player, String node, boolean value) {
        this.setPlayerInfoBoolean(world, player.getName(), node, value);
    }

    /**
     * Sets the player info boolean value of a player in a specific world.
     *
     * @param world  The world in which to set the player info boolean value.
     * @param player The player whose player info boolean value is being set.
     * @param node   The node whose player info boolean value is being set.
     * @param value  The value to set.
     * @deprecated Use {@link #setPlayerInfoBoolean(String, OfflinePlayer, String, boolean)} instead.
     */
    @Deprecated
    public abstract void setPlayerInfoBoolean(String world, String player, String node, boolean value);

    /**
     * Sets the player info boolean value of a player in a specific world.
     *
     * @param world  The world in which to set the player info boolean value.
     * @param player The player whose player info boolean value is being set.
     * @param node   The node whose player info boolean value is being set.
     * @param value  The value to set.
     * @deprecated Use {@link #setPlayerInfoBoolean(String, OfflinePlayer, String, boolean)} instead.
     */
    @Deprecated
    public void setPlayerInfoBoolean(@NotNull World world, String player, String node, boolean value) {
        this.setPlayerInfoBoolean(world.getName(), player, node, value);
    }

    /**
     * Sets the player info boolean value of a player.
     *
     * @param player The player whose player info boolean value is being set.
     * @param node   The node whose player info boolean value is being set.
     * @param value  The value to set.
     */
    public void setPlayerInfoBoolean(Player player, String node, boolean value) {
        this.setPlayerInfoBoolean(player.getWorld().getName(), player, node, value);
    }

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
     * Retrieves the group info boolean value of a group in a specific world.
     *
     * @param world        The world in which to look up the group info boolean value.
     * @param group        The group whose group info boolean value is being queried.
     * @param node         The node whose group info boolean value is being queried.
     * @param defaultValue The default value to return if the group info boolean value is not found.
     * @return The group info boolean value of the specified group in the specified world.
     */
    public boolean getGroupInfoBoolean(@NotNull World world, String group, String node, boolean defaultValue) {
        return this.getGroupInfoBoolean(world.getName(), group, node, defaultValue);
    }

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
     * Sets the group info boolean value of a group in a specific world.
     *
     * @param world The world in which to set the group info boolean value.
     * @param group The group whose group info boolean value is being set.
     * @param node  The node whose group info boolean value is being set.
     * @param value The value to set.
     */
    public void setGroupInfoBoolean(@NotNull World world, String group, String node, boolean value) {
        this.setGroupInfoBoolean(world.getName(), group, node, value);
    }

    /**
     * Retrieves the player info string value of a player in a specific world.
     *
     * @param world        The world in which to look up the player info string value.
     * @param player       The player whose player info string value is being queried.
     * @param node         The node whose player info string value is being queried.
     * @param defaultValue The default value to return if the player info string value is not found.
     * @return The player info string value of the specified player in the specified world.
     */
    public String getPlayerInfoString(String world, @NotNull OfflinePlayer player, String node, String defaultValue) {
        return this.getPlayerInfoString(world, player.getName(), node, defaultValue);
    }

    /**
     * Retrieves the player info string value of a player in a specific world.
     *
     * @param world        The world in which to look up the player info string value.
     * @param player       The player whose player info string value is being queried.
     * @param node         The node whose player info string value is being queried.
     * @param defaultValue The default value to return if the player info string value is not found.
     * @return The player info string value of the specified player in the specified world.
     * @deprecated Use {@link #getPlayerInfoString(String, OfflinePlayer, String, String)} instead.
     */
    @Deprecated
    public abstract String getPlayerInfoString(String world, String player, String node, String defaultValue);

    /**
     * Retrieves the player info string value of a player in a specific world.
     *
     * @param world        The world in which to look up the player info string value.
     * @param player       The player whose player info string value is being queried.
     * @param node         The node whose player info string value is being queried.
     * @param defaultValue The default value to return if the player info string value is not found.
     * @return The player info string value of the specified player in the specified world.
     * @deprecated Use {@link #getPlayerInfoString(String, OfflinePlayer, String, String)} instead.
     */
    @Deprecated
    public String getPlayerInfoString(@NotNull World world, String player, String node, String defaultValue) {
        return this.getPlayerInfoString(world.getName(), player, node, defaultValue);
    }

    /**
     * Retrieves the player info string value of a player.
     *
     * @param player       The player whose player info string value is being queried.
     * @param node         The node whose player info string value is being queried.
     * @param defaultValue The default value to return if the player info string value is not found.
     * @return The player info string value of the specified player.
     */
    public String getPlayerInfoString(Player player, String node, String defaultValue) {
        return this.getPlayerInfoString(player.getWorld().getName(), player, node, defaultValue);
    }

    /**
     * Sets the player info string value of a player in a specific world.
     *
     * @param world  The world in which to set the player info string value.
     * @param player The player whose player info string value is being set.
     * @param node   The node whose player info string value is being set.
     * @param value  The value to set.
     */
    public void setPlayerInfoString(String world, @NotNull OfflinePlayer player, String node, String value) {
        this.setPlayerInfoString(world, player.getName(), node, value);
    }

    /**
     * Sets the player info string value of a player in a specific world.
     *
     * @param world  The world in which to set the player info string value.
     * @param player The player whose player info string value is being set.
     * @param node   The node whose player info string value is being set.
     * @param value  The value to set.
     * @deprecated Use {@link #setPlayerInfoString(String, OfflinePlayer, String, String)} instead.
     */
    @Deprecated
    public abstract void setPlayerInfoString(String world, String player, String node, String value);

    /**
     * Sets the player info string value of a player in a specific world.
     *
     * @param world  The world in which to set the player info string value.
     * @param player The player whose player info string value is being set.
     * @param node   The node whose player info string value is being set.
     * @param value  The value to set.
     * @deprecated Use {@link #setPlayerInfoString(String, OfflinePlayer, String, String)} instead.
     */
    @Deprecated
    public void setPlayerInfoString(@NotNull World world, String player, String node, String value) {
        this.setPlayerInfoString(world.getName(), player, node, value);
    }

    /**
     * Sets the player info string value of a player.
     *
     * @param player The player whose player info string value is being set.
     * @param node   The node whose player info string value is being set.
     * @param value  The value to set.
     */
    public void setPlayerInfoString(Player player, String node, String value) {
        this.setPlayerInfoString(player.getWorld().getName(), player, node, value);
    }

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
     * Retrieves the group info string value of a group in a specific world.
     *
     * @param world        The world in which to look up the group info string value.
     * @param group        The group whose group info string value is being queried.
     * @param node         The node whose group info string value is being queried.
     * @param defaultValue The default value to return if the group info string value is not found.
     * @return The group info string value of the specified group in the specified world.
     */
    public String getGroupInfoString(@NotNull World world, String group, String node, String defaultValue) {
        return this.getGroupInfoString(world.getName(), group, node, defaultValue);
    }

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
     * Sets the group info string value of a group in a specific world.
     *
     * @param world The world in which to set the group info string value.
     * @param group The group whose group info string value is being set.
     * @param node  The node whose group info string value is being set.
     * @param value The value to set.
     */
    public void setGroupInfoString(@NotNull World world, String group, String node, String value) {
        this.setGroupInfoString(world.getName(), group, node, value);
    }

    /**
     * Checks if a player is in a specified group in a specific world.
     *
     * @param world  The world in which to check.
     * @param player The player to check.
     * @param group  The group to check.
     * @return Whether or not the player is in the specified group in the specified world.
     */
    public boolean playerInGroup(String world, OfflinePlayer player, String group) {
        return this.permission.playerInGroup(world, player, group);
    }

    /**
     * Checks if a player is in a specified group in a specific world.
     *
     * @param world  The world in which to check.
     * @param player The player to check.
     * @param group  The group to check.
     * @return Whether or not the player is in the specified group in the specified world.
     * @deprecated Use {@link #playerInGroup(String, OfflinePlayer, String)} instead.
     */
    @Deprecated
    public boolean playerInGroup(String world, String player, String group) {
        return this.permission.playerInGroup(world, player, group);
    }

    /**
     * Checks if a player is in a specified group in a specific world.
     *
     * @param world  The world in which to check.
     * @param player The player to check.
     * @param group  The group to check.
     * @return Whether or not the player is in the specified group in the specified world.
     * @deprecated Use {@link #playerInGroup(String, OfflinePlayer, String)} instead.
     */
    @Deprecated
    public boolean playerInGroup(@NotNull World world, String player, String group) {
        return this.playerInGroup(world.getName(), player, group);
    }

    /**
     * Checks if a player is in a specified group.
     *
     * @param player The player to check.
     * @param group  The group to check.
     * @return Whether or not the player is in the specified group.
     */
    public boolean playerInGroup(Player player, String group) {
        return this.playerInGroup(player.getWorld().getName(), player, group);
    }

    /**
     * Gets all groups that a player is in while in a specified world.
     *
     * @param world  The world in which to check.
     * @param player The player to check.
     * @return An array of all groups that the player is in while in the specified world.
     */
    public String[] getPlayerGroups(String world, OfflinePlayer player) {
        return this.permission.getPlayerGroups(world, player);
    }

    /**
     * Gets all groups that a player is in while in a specified world.
     *
     * @param world  The world in which to check.
     * @param player The player to check.
     * @return An array of all groups that the player is in while in the specified world.
     * @deprecated Use {@link #getPlayerGroups(String, OfflinePlayer)} instead.
     */
    @Deprecated
    public String[] getPlayerGroups(String world, String player) {
        return this.permission.getPlayerGroups(world, player);
    }

    /**
     * Gets all groups that a player is in while in a specified world.
     *
     * @param world  The world in which to check.
     * @param player The player to check.
     * @return An array of all groups that the player is in while in the specified world.
     * @deprecated Use {@link #getPlayerGroups(String, OfflinePlayer)} instead.
     */
    @Deprecated
    public String[] getPlayerGroups(@NotNull World world, String player) {
        return this.getPlayerGroups(world.getName(), player);
    }

    /**
     * Gets all groups that a player is in.
     *
     * @param player The player to check.
     * @return An array of all groups that the player is in.
     */
    public String[] getPlayerGroups(Player player) {
        return this.getPlayerGroups(player.getWorld().getName(), player);
    }

    /**
     * Gets the primary group of a player in a specified world.
     *
     * @param world  The world in which to check.
     * @param player The player to check.
     * @return The primary group of the player in the specified world.
     */
    public String getPrimaryGroup(String world, OfflinePlayer player) {
        return this.permission.getPrimaryGroup(world, player);
    }

    /**
     * Gets the primary group of a player in a specified world.
     *
     * @param world  The world in which to check.
     * @param player The player to check.
     * @return The primary group of the player in the specified world.
     * @deprecated Use {@link #getPrimaryGroup(String, OfflinePlayer)} instead.
     */
    @Deprecated
    public String getPrimaryGroup(String world, String player) {
        return this.permission.getPrimaryGroup(world, player);
    }

    /**
     * Gets the primary group of a player in a specified world.
     *
     * @param world  The world in which to check.
     * @param player The player to check.
     * @return The primary group of the player in the specified world.
     * @deprecated Use {@link #getPrimaryGroup(String, OfflinePlayer)} instead.
     */
    @Deprecated
    public String getPrimaryGroup(@NotNull World world, String player) {
        return this.getPrimaryGroup(world.getName(), player);
    }

    /**
     * Gets the primary group of a player.
     *
     * @param player The player to check.
     * @return The primary group of the player.
     */
    public String getPrimaryGroup(Player player) {
        return this.getPrimaryGroup(player.getWorld().getName(), player);
    }

    /**
     * Gets all registered groups.
     *
     * @return An array of all registered groups.
     */
    public String[] getGroups() {
        return this.permission.getGroups();
    }
}
