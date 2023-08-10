package me.gamingoninsulin.automate;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

public class Automate extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example

        }
        NamespacedKey categoryId = new NamespacedKey(this, "cool_category");
        CustomItemStack categoryItem = new CustomItemStack(Material.DIAMOND, "&4Our very cool Category");

        // Our custom Category
        ItemGroup itemGroup = new ItemGroup(categoryId, categoryItem);

        // The custom item for our SlimefunItem
        SlimefunItemStack itemStack = new SlimefunItemStack("MY_ADDON_ITEM", Material.EMERALD, "&aPretty cool Emerald", "", "&7This is awesome");

        // A 3x3 shape representing our recipe
        ItemStack[] recipe = {
                new ItemStack(Material.DIAMOND),    null,                               new ItemStack(Material.DIAMOND),
                null,                               SlimefunItems.CARBONADO,            null,
                new ItemStack(Material.DIAMOND),    null,                               new ItemStack(Material.DIAMOND)
        };

        SlimefunItem Item = new SlimefunItem(itemGroup, itemStack, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
        Item.register(this);
        // Our item is now registered


        /* seasonal month
            Month month = Month.JAN; // This is any enum from java.time.Month.
            SeasonalItemGroup group = new SeasonalItemGroup(categoryId, categoryItem, tier, month);
         */

        /* Locked item group
            // This item group will require `parentItemGroupA` and `parentItemGroupB` to be fully unlocked.
            LockedItemGroup category = new LockedItemGroup(categoryId, categoryItem, tier, parentItemGroupA.getKey(), parentItemGroupB.getKey());
         */


        // Our item is now registered
    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return "https://github.com/gamingoninsulin/automate/issues";
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * You will need to return a reference to your Plugin here.
         * If you are using your main class for this, simply return "this".
         */
        return this;
    }

}
