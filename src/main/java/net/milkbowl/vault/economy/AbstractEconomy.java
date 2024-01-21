package net.milkbowl.vault.economy;

import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

/**
 * Abstract class for Vault's Economy API.
 *
 * @author Foulest
 * @project Vault
 */
@SuppressWarnings({"deprecation", "unused"})
public abstract class AbstractEconomy implements Economy {

    /**
     * Checks if the specified player has an account.
     *
     * @param player The player to check.
     * @return Whether the player has an account.
     */
    public boolean hasAccount(@NotNull OfflinePlayer player) {
        return player.getName() != null && this.hasAccount(player.getName());
    }

    /**
     * Checks if the specified player has an account in the specified world.
     *
     * @param player    The player to check.
     * @param worldName The world to check.
     * @return Whether the player has an account in the specified world.
     */
    public boolean hasAccount(@NotNull OfflinePlayer player, String worldName) {
        return player.getName() != null && this.hasAccount(player.getName(), worldName);
    }

    /**
     * Gets the balance of the specified player.
     *
     * @param player The player to get the balance of.
     * @return The player's balance.
     */
    public double getBalance(@NotNull OfflinePlayer player) {
        return this.getBalance(player.getName());
    }

    /**
     * Gets the balance of the specified player in the specified world.
     *
     * @param player The player to get the balance of.
     * @param world  The world to get the balance of.
     * @return The player's balance in the specified world.
     */
    public double getBalance(@NotNull OfflinePlayer player, String world) {
        return this.getBalance(player.getName(), world);
    }

    /**
     * Checks if the specified player has the specified amount.
     *
     * @param player The player to check.
     * @param amount The amount to check.
     * @return Whether the player has the specified amount.
     */
    public boolean has(@NotNull OfflinePlayer player, double amount) {
        return player.getName() != null && this.has(player.getName(), amount);
    }

    /**
     * Checks if the specified player has the specified amount in the specified world.
     *
     * @param player    The player to check.
     * @param worldName The world to check.
     * @param amount    The amount to check.
     * @return Whether the player has the specified amount in the specified world.
     */
    public boolean has(@NotNull OfflinePlayer player, String worldName, double amount) {
        return player.getName() != null && this.has(player.getName(), worldName, amount);
    }

    /**
     * Withdraws the specified amount from the specified player.
     *
     * @param player The player to withdraw from.
     * @param amount The amount to withdraw.
     * @return The response of the transaction.
     */
    public EconomyResponse withdrawPlayer(@NotNull OfflinePlayer player, double amount) {
        return this.withdrawPlayer(player.getName(), amount);
    }

    /**
     * Withdraws the specified amount from the specified player in the specified world.
     *
     * @param player    The player to withdraw from.
     * @param worldName The world to withdraw from.
     * @param amount    The amount to withdraw.
     * @return The response of the transaction.
     */
    public EconomyResponse withdrawPlayer(@NotNull OfflinePlayer player, String worldName, double amount) {
        return this.withdrawPlayer(player.getName(), worldName, amount);
    }

    /**
     * Deposits the specified amount to the specified player.
     *
     * @param player The player to deposit to.
     * @param amount The amount to deposit.
     * @return The response of the transaction.
     */
    public EconomyResponse depositPlayer(@NotNull OfflinePlayer player, double amount) {
        return this.depositPlayer(player.getName(), amount);
    }

    /**
     * Deposits the specified amount to the specified player in the specified world.
     *
     * @param player    The player to deposit to.
     * @param worldName The world to deposit to.
     * @param amount    The amount to deposit.
     * @return The response of the transaction.
     */
    public EconomyResponse depositPlayer(@NotNull OfflinePlayer player, String worldName, double amount) {
        return this.depositPlayer(player.getName(), worldName, amount);
    }

    /**
     * Creates a bank with the specified name.
     *
     * @param name   The name of the bank.
     * @param player The player to create the bank for.
     * @return The response of the transaction.
     */
    public EconomyResponse createBank(String name, @NotNull OfflinePlayer player) {
        return this.createBank(name, player.getName());
    }

    /**
     * Checks if the specified player is the owner of the specified bank.
     *
     * @param name   The name of the bank.
     * @param player The player to check.
     * @return Whether the player is the owner of the bank.
     */
    public EconomyResponse isBankOwner(String name, @NotNull OfflinePlayer player) {
        return this.isBankOwner(name, player.getName());
    }

    /**
     * Checks if the specified player is a member of the specified bank.
     *
     * @param name   The name of the bank.
     * @param player The player to check.
     * @return Whether the player is a member of the bank.
     */
    public EconomyResponse isBankMember(String name, @NotNull OfflinePlayer player) {
        return this.isBankMember(name, player.getName());
    }

    /**
     * Creates an account for the specified player.
     *
     * @param player The player to create the account for.
     * @return The bank's balance.
     */
    public boolean createPlayerAccount(@NotNull OfflinePlayer player) {
        return this.createPlayerAccount(player.getName());
    }

    /**
     * Creates an account for the specified player in the specified world.
     *
     * @param player    The player to create the account for.
     * @param worldName The world to create the account in.
     * @return The bank's balance.
     */
    public boolean createPlayerAccount(@NotNull OfflinePlayer player, String worldName) {
        return this.createPlayerAccount(player.getName(), worldName);
    }
}
