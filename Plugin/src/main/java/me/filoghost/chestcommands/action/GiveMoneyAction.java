/*
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program. If not, see <https://www.gnu.org/licenses/>.
 */
package me.filoghost.chestcommands.action;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.filoghost.chestcommands.parser.ParseException;
import me.filoghost.chestcommands.hook.VaultEconomyHook;
import me.filoghost.chestcommands.parser.NumberParser;

public class GiveMoneyAction extends Action {

	private double moneyToGive;

	public GiveMoneyAction(String action) {
		try {
			moneyToGive = NumberParser.getStrictlyPositiveDouble(action);
		} catch (ParseException e) {
			disable(ChatColor.RED + "Invalid money amount: " + action);
		}
	}

	@Override
	protected void executeInner(Player player) {
		if (VaultEconomyHook.INSTANCE.isEnabled()) {
			VaultEconomyHook.giveMoney(player, moneyToGive);
		} else {
			player.sendMessage(ChatColor.RED + "Vault with a compatible economy plugin not found. Please inform the staff.");
		}
	}

}
