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

import net.milkbowl.vault.util.ConstantUtil;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * Vault's SuperPerms implementation; the default permissions system.
 *
 * @author Foulest
 */
public class SuperPerms extends Permission {

    public SuperPerms(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public @NotNull String getName() {
        return "SuperPerms";
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean playerHas(@NotNull UUID uuid, @NotNull String permission) {
        @Nullable Player player = plugin.getServer().getPlayer(uuid);
        return player != null && player.hasPermission(permission);
    }

    @Override
    public boolean playerAdd(UUID uuid, String permission) {
        return false;
    }

    @Override
    public boolean playerRemove(UUID uuid, String permission) {
        return false;
    }

    @Override
    public boolean groupHas(String group, String permission) {
        @NotNull String name = getName();
        throw new UnsupportedOperationException(name + ConstantUtil.NO_GROUP_PERMISSIONS);
    }

    @Override
    public boolean groupAdd(String group, String permission) {
        @NotNull String name = getName();
        throw new UnsupportedOperationException(name + ConstantUtil.NO_GROUP_PERMISSIONS);
    }

    @Override
    public boolean groupRemove(String group, String permission) {
        @NotNull String name = getName();
        throw new UnsupportedOperationException(name + ConstantUtil.NO_GROUP_PERMISSIONS);
    }

    @Override
    public boolean playerInGroup(@NotNull UUID uuid, String group) {
        return playerHas(uuid, "groups." + group);
    }

    @Override
    public boolean playerAddGroup(UUID uuid, String group) {
        @NotNull String name = getName();
        throw new UnsupportedOperationException(name + ConstantUtil.NO_GROUP_PERMISSIONS);
    }

    @Override
    public boolean playerRemoveGroup(UUID uuid, String group) {
        @NotNull String name = getName();
        throw new UnsupportedOperationException(name + ConstantUtil.NO_GROUP_PERMISSIONS);
    }

    @Override
    public String[] getPlayerGroups(UUID uuid) {
        @NotNull String name = getName();
        throw new UnsupportedOperationException(name + ConstantUtil.NO_GROUP_PERMISSIONS);
    }

    @Override
    public String getPrimaryGroup(UUID uuid) {
        @NotNull String name = getName();
        throw new UnsupportedOperationException(name + ConstantUtil.NO_GROUP_PERMISSIONS);
    }

    @Override
    public String @NotNull [] getGroups() {
        return new String[0];
    }

    @Override
    public boolean hasSuperPermsCompat() {
        return true;
    }

    @Override
    public boolean hasGroupSupport() {
        return false;
    }
}
