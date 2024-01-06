package net.milkbowl.vault.economy;

import org.bukkit.OfflinePlayer;

import java.util.List;

@SuppressWarnings({"DeprecatedIsStillUsed", "unused"})
public interface Economy {

    boolean isEnabled();

    String getName();

    boolean hasBankSupport();

    int fractionalDigits();

    String format(double amount);

    String currencyNamePlural();

    String currencyNameSingular();

    @Deprecated
    boolean hasAccount(String player);

    boolean hasAccount(OfflinePlayer player);

    @Deprecated
    boolean hasAccount(String player, String worldName);

    boolean hasAccount(OfflinePlayer player, String worldName);

    @Deprecated
    double getBalance(String player);

    double getBalance(OfflinePlayer player);

    @Deprecated
    double getBalance(String player, String worldName);

    double getBalance(OfflinePlayer player, String worldName);

    @Deprecated
    boolean has(String player, double amount);

    boolean has(OfflinePlayer player, double amount);

    @Deprecated
    boolean has(String player, String worldName, double amount);

    boolean has(OfflinePlayer player, String worldName, double amount);

    @Deprecated
    EconomyResponse withdrawPlayer(String player, double amount);

    EconomyResponse withdrawPlayer(OfflinePlayer player, double amount);

    @Deprecated
    EconomyResponse withdrawPlayer(String player, String worldName, double amount);

    EconomyResponse withdrawPlayer(OfflinePlayer player, String worldName, double amount);

    @Deprecated
    EconomyResponse depositPlayer(String player, double amount);

    EconomyResponse depositPlayer(OfflinePlayer player, double amount);

    @Deprecated
    EconomyResponse depositPlayer(String player, String worldName, double amount);

    EconomyResponse depositPlayer(OfflinePlayer player, String worldName, double amount);

    @Deprecated
    EconomyResponse createBank(String name, String player);

    EconomyResponse createBank(String name, OfflinePlayer player);

    EconomyResponse deleteBank(String name);

    EconomyResponse bankBalance(String name);

    EconomyResponse bankHas(String name, double amount);

    EconomyResponse bankWithdraw(String name, double amount);

    EconomyResponse bankDeposit(String name, double amount);

    @Deprecated
    EconomyResponse isBankOwner(String name, String player);

    EconomyResponse isBankOwner(String name, OfflinePlayer player);

    @Deprecated
    EconomyResponse isBankMember(String name, String player);

    EconomyResponse isBankMember(String name, OfflinePlayer player);

    List<String> getBanks();

    @Deprecated
    boolean createPlayerAccount(String player);

    boolean createPlayerAccount(OfflinePlayer player);

    @Deprecated
    boolean createPlayerAccount(String player, String worldName);

    boolean createPlayerAccount(OfflinePlayer player, String worldName);
}
