package net.milkbowl.vault.economy;

import org.bukkit.OfflinePlayer;

import java.util.List;

/**
 * Interface for Vault's Economy API.
 *
 * @author Foulest
 * @project Vault
 */
@SuppressWarnings({"unused", "DeprecatedIsStillUsed"})
public interface Economy {

    /**
     * Checks if the economy system is enabled.
     *
     * @return Whether the economy system is enabled.
     */
    boolean isEnabled();

    /**
     * Gets the name of the economy system.
     *
     * @return Name of the economy system.
     */
    String getName();

    /**
     * Checks if the economy system supports banks.
     *
     * @return Whether the economy system supports banks.
     */
    boolean hasBankSupport();

    /**
     * Gets the fractional digits for the economy system.
     *
     * @return Fractional digits for the economy system.
     */
    int fractionalDigits();

    /**
     * Gets the format for the economy system.
     *
     * @param amount Amount to format.
     * @return Format for the economy system.
     */
    String format(double amount);

    /**
     * Gets the currency name for the economy system.
     *
     * @return Currency name for the economy system.
     */
    String currencyNamePlural();

    /**
     * Gets the currency name for the economy system.
     *
     * @return Currency name for the economy system.
     */
    String currencyNameSingular();

    /**
     * Checks if the given player has an account.
     *
     * @param player Player name to check.
     * @return Whether the player has an account.
     * @deprecated Use {@link #hasAccount(OfflinePlayer)} instead.
     */
    @Deprecated
    boolean hasAccount(String player);

    /**
     * Checks if the given player has an account.
     *
     * @param player Player to check.
     * @return Whether the player has an account.
     */
    boolean hasAccount(OfflinePlayer player);

    /**
     * Checks if the given player has an account on the given world.
     *
     * @param player    Player name to check.
     * @param worldName Name of the world to check.
     * @return Whether the player has an account on the given world.
     * @deprecated Use {@link #hasAccount(OfflinePlayer, String)} instead.
     */
    @Deprecated
    boolean hasAccount(String player, String worldName);

    /**
     * Checks if the given player has an account on the given world.
     *
     * @param player    Player to check.
     * @param worldName Name of the world to check.
     * @return Whether the player has an account on the given world.
     */
    boolean hasAccount(OfflinePlayer player, String worldName);

    /**
     * Gets the balance of the given player.
     *
     * @param player Player name to check.
     * @return Balance of the given player.
     * @deprecated Use {@link #getBalance(OfflinePlayer)} instead.
     */
    @Deprecated
    double getBalance(String player);

    /**
     * Gets the balance of the given player.
     *
     * @param player Player to check.
     * @return Balance of the given player.
     */
    double getBalance(OfflinePlayer player);

    /**
     * Gets the balance of the given player on the given world.
     *
     * @param player    Player name to check.
     * @param worldName Name of the world to check.
     * @return Balance of the given player on the given world.
     * @deprecated Use {@link #getBalance(OfflinePlayer, String)} instead.
     */
    @Deprecated
    double getBalance(String player, String worldName);

    /**
     * Gets the balance of the given player on the given world.
     *
     * @param player    Player to check.
     * @param worldName Name of the world to check.
     * @return Balance of the given player on the given world.
     */
    double getBalance(OfflinePlayer player, String worldName);

    /**
     * Checks if the given player has at least the given amount.
     *
     * @param player Player name to check.
     * @param amount Amount to check.
     * @return Whether the player has at least the given amount.
     * @deprecated Use {@link #has(OfflinePlayer, double)} instead.
     */
    @Deprecated
    boolean has(String player, double amount);

    /**
     * Checks if the given player has at least the given amount.
     *
     * @param player Player to check.
     * @param amount Amount to check.
     * @return Whether the player has at least the given amount.
     */
    boolean has(OfflinePlayer player, double amount);

    /**
     * Checks if the given player has at least the given amount on the given world.
     *
     * @param player    Player name to check.
     * @param worldName Name of the world to check.
     * @param amount    Amount to check.
     * @return Whether the player has at least the given amount on the given world.
     * @deprecated Use {@link #has(OfflinePlayer, String, double)} instead.
     */
    @Deprecated
    boolean has(String player, String worldName, double amount);

    /**
     * Checks if the given player has at least the given amount on the given world.
     *
     * @param player    Player to check.
     * @param worldName Name of the world to check.
     * @param amount    Amount to check.
     * @return Whether the player has at least the given amount on the given world.
     */
    boolean has(OfflinePlayer player, String worldName, double amount);

    /**
     * Withdraws the given amount from the given player.
     *
     * @param player Player name to withdraw from.
     * @param amount Amount to withdraw.
     * @return Response object for the transaction.
     * @deprecated Use {@link #withdrawPlayer(OfflinePlayer, double)} instead.
     */
    @Deprecated
    EconomyResponse withdrawPlayer(String player, double amount);

    /**
     * Withdraws the given amount from the given player.
     *
     * @param player Player to withdraw from.
     * @param amount Amount to withdraw.
     * @return Response object for the transaction.
     */
    EconomyResponse withdrawPlayer(OfflinePlayer player, double amount);

    /**
     * Withdraws the given amount from the given player on the given world.
     *
     * @param player    Player name to withdraw from.
     * @param worldName Name of the world to withdraw from.
     * @param amount    Amount to withdraw.
     * @return Response object for the transaction.
     * @deprecated Use {@link #withdrawPlayer(OfflinePlayer, String, double)} instead.
     */
    @Deprecated
    EconomyResponse withdrawPlayer(String player, String worldName, double amount);

    /**
     * Withdraws the given amount from the given player on the given world.
     *
     * @param player    Player to withdraw from.
     * @param worldName Name of the world to withdraw from.
     * @param amount    Amount to withdraw.
     * @return Response object for the transaction.
     */
    EconomyResponse withdrawPlayer(OfflinePlayer player, String worldName, double amount);

    /**
     * Deposits the given amount to the given player.
     *
     * @param player Player name to deposit to.
     * @param amount Amount to deposit.
     * @return Response object for the transaction.
     * @deprecated Use {@link #depositPlayer(OfflinePlayer, double)} instead.
     */
    @Deprecated
    EconomyResponse depositPlayer(String player, double amount);

    /**
     * Deposits the given amount to the given player.
     *
     * @param player Player to deposit to.
     * @param amount Amount to deposit.
     * @return Response object for the transaction.
     */
    EconomyResponse depositPlayer(OfflinePlayer player, double amount);

    /**
     * Deposits the given amount to the given player on the given world.
     *
     * @param player    Player name to deposit to.
     * @param worldName Name of the world to deposit to.
     * @param amount    Amount to deposit.
     * @return Response object for the transaction.
     * @deprecated Use {@link #depositPlayer(OfflinePlayer, String, double)} instead.
     */
    @Deprecated
    EconomyResponse depositPlayer(String player, String worldName, double amount);

    /**
     * Deposits the given amount to the given player on the given world.
     *
     * @param player    Player to deposit to.
     * @param worldName Name of the world to deposit to.
     * @param amount    Amount to deposit.
     * @return Response object for the transaction.
     */
    EconomyResponse depositPlayer(OfflinePlayer player, String worldName, double amount);

    /**
     * Creates a bank with the given name and owner.
     *
     * @param name   Name of the bank.
     * @param player Owner of the bank.
     * @return Response object for the transaction.
     * @deprecated Use {@link #createBank(String, OfflinePlayer)} instead.
     */
    @Deprecated
    EconomyResponse createBank(String name, String player);

    /**
     * Creates a bank with the given name and owner.
     *
     * @param name   Name of the bank.
     * @param player Owner of the bank.
     * @return Response object for the transaction.
     */
    EconomyResponse createBank(String name, OfflinePlayer player);

    /**
     * Deletes the bank with the given name.
     *
     * @param name Name of the bank.
     * @return Response object for the transaction.
     */
    EconomyResponse deleteBank(String name);

    /**
     * Gets the balance of the given bank.
     *
     * @param name Name of the bank.
     * @return Response object for the transaction.
     */
    EconomyResponse bankBalance(String name);

    /**
     * Checks if the given bank has at least the given amount.
     *
     * @param name   Name of the bank.
     * @param amount Amount to check.
     * @return Response object for the transaction.
     */
    EconomyResponse bankHas(String name, double amount);

    /**
     * Withdraws the given amount from the given bank.
     *
     * @param name   Name of the bank.
     * @param amount Amount to withdraw.
     * @return Response object for the transaction.
     */
    EconomyResponse bankWithdraw(String name, double amount);

    /**
     * Deposits the given amount to the given bank.
     *
     * @param name   Name of the bank.
     * @param amount Amount to deposit.
     * @return Response object for the transaction.
     */
    EconomyResponse bankDeposit(String name, double amount);

    /**
     * Checks if the given player is the owner of the given bank.
     *
     * @param name   Name of the bank.
     * @param player Player name to check.
     * @return Response object for the transaction.
     * @deprecated Use {@link #isBankOwner(String, OfflinePlayer)} instead.
     */
    @Deprecated
    EconomyResponse isBankOwner(String name, String player);

    /**
     * Checks if the given player is the owner of the given bank.
     *
     * @param name   Name of the bank.
     * @param player Player to check.
     * @return Response object for the transaction.
     */
    EconomyResponse isBankOwner(String name, OfflinePlayer player);

    /**
     * Checks if the given player is a member of the given bank.
     *
     * @param name   Name of the bank.
     * @param player Player name to check.
     * @return Response object for the transaction.
     * @deprecated Use {@link #isBankMember(String, OfflinePlayer)} instead.
     */
    @Deprecated
    EconomyResponse isBankMember(String name, String player);

    /**
     * Checks if the given player is a member of the given bank.
     *
     * @param name   Name of the bank.
     * @param player Player to check.
     * @return Response object for the transaction.
     */
    EconomyResponse isBankMember(String name, OfflinePlayer player);

    /**
     * Gets a list of all banks.
     *
     * @return List of all banks.
     */
    List<String> getBanks();

    /**
     * Creates an account for the given player.
     *
     * @param player Player name to create an account for.
     * @return Whether the account was created.
     * @deprecated Use {@link #createPlayerAccount(OfflinePlayer)} instead.
     */
    @Deprecated
    boolean createPlayerAccount(String player);

    /**
     * Creates an account for the given player.
     *
     * @param player Player to create an account for.
     * @return Whether the account was created.
     */
    boolean createPlayerAccount(OfflinePlayer player);

    /**
     * Creates an account for the given player on the given world.
     *
     * @param player    Player name to create an account for.
     * @param worldName Name of the world to create an account for.
     * @return Whether the account was created.
     * @deprecated Use {@link #createPlayerAccount(OfflinePlayer, String)} instead.
     */
    @Deprecated
    boolean createPlayerAccount(String player, String worldName);

    /**
     * Creates an account for the given player on the given world.
     *
     * @param player    Player to create an account for.
     * @param worldName Name of the world to create an account for.
     * @return Whether the account was created.
     */
    boolean createPlayerAccount(OfflinePlayer player, String worldName);
}
