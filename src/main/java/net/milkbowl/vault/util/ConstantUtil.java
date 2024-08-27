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
package net.milkbowl.vault.util;

import lombok.experimental.UtilityClass;

/**
 * Utility class for constants.
 *
 * @author Foulest
 */
@UtilityClass
public class ConstantUtil {

    /**
     * Constant for when a player has no permission.
     */
    public final String NO_PERMISSION = "&cNo permission.";

    /**
     * Constant for when a permission system does not support offline player permissions.
     */
    public final String NO_TRANSIENT_PERMISSIONS = " does not support offline player transient permissions.";

    /**
     * Constant for when a permission system has no group permissions.
     */
    public final String NO_GROUP_PERMISSIONS = " has no group permissions.";

    /**
     * Constant for when a tab completer is unable to be registered.
     */
    public final String UNABLE_TO_REGISTER_TAB_COMPLETER = "Unable to register tab completer: ";
}
