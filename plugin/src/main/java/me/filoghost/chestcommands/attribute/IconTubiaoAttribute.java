/*
 * Copyright (C) filoghost and contributors
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package me.filoghost.chestcommands.attribute;

import me.filoghost.chestcommands.icon.InternalConfigurableIcon;

public class IconTubiaoAttribute implements IconAttribute {

    private final String icon;

    public IconTubiaoAttribute(String icon, AttributeErrorHandler errorHandler) {
        this.icon =icon;
    }


    @Override
    public void apply(InternalConfigurableIcon icon) {
        icon.setIcon(this.icon);
    }

}
