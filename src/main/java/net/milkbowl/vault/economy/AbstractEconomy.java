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
package net.milkbowl.vault.economy;

import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * Deprecated abstract class for Vault's Economy API.
 * Some plugins may still use this class, so it is kept for compatibility.
 *
 * @author Foulest
 */
@SuppressWarnings({"deprecation", "unused"})
public abstract class AbstractEconomy implements Economy {

    @Override
    public boolean hasAccount(@NotNull OfflinePlayer player) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return hasAccount(uniqueId);
    }

    @Override
    public boolean hasAccount(@NotNull OfflinePlayer player, String worldName) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return hasAccount(uniqueId, worldName);
    }

    @Override
    public double getBalance(@NotNull OfflinePlayer player) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return getBalance(uniqueId);
    }

    @Override
    public double getBalance(@NotNull OfflinePlayer player, String world) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return getBalance(uniqueId, world);
    }

    @Override
    public boolean has(@NotNull OfflinePlayer player, double amount) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return has(uniqueId, amount);
    }

    @Override
    public boolean has(@NotNull OfflinePlayer player, String worldName, double amount) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return has(uniqueId, worldName, amount);
    }

    @Override
    public EconomyResponse withdrawPlayer(@NotNull OfflinePlayer player, double amount) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return withdrawPlayer(uniqueId, amount);
    }

    @Override
    public EconomyResponse withdrawPlayer(@NotNull OfflinePlayer player, String worldName, double amount) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return withdrawPlayer(uniqueId, worldName, amount);
    }

    @Override
    public EconomyResponse depositPlayer(@NotNull OfflinePlayer player, double amount) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return depositPlayer(uniqueId, amount);
    }

    @Override
    public EconomyResponse depositPlayer(@NotNull OfflinePlayer player, String worldName, double amount) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return depositPlayer(uniqueId, worldName, amount);
    }

    @Override
    public EconomyResponse createBank(String name, @NotNull OfflinePlayer player) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return createBank(name, uniqueId);
    }

    @Override
    public EconomyResponse isBankOwner(String name, @NotNull OfflinePlayer player) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return isBankOwner(name, uniqueId);
    }

    @Override
    public EconomyResponse isBankMember(String name, @NotNull OfflinePlayer player) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return isBankMember(name, uniqueId);
    }

    @Override
    public boolean createPlayerAccount(@NotNull OfflinePlayer player) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return createPlayerAccount(uniqueId);
    }

    @Override
    public boolean createPlayerAccount(@NotNull OfflinePlayer player, String worldName) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return createPlayerAccount(uniqueId, worldName);
    }
}
