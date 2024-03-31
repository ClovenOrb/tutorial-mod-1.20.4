package net.clover.tutorial.util;

import net.clover.tutorial.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.loot.LootManager;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModLootTableModifiers {
    private static final Identifier JUNGLE_TEMPLE_ID =
            new Identifier("minecraft", "chests/jungle_temple");
    private static final Identifier CREEPER_ID =
            new Identifier("minecraft", "entities/creeper");

    private static final Identifier SUSPICIOUS_SAND_ID =
            new Identifier("minecraft", "archaeology/desert_pyramid");

    public static void modifyLootTables(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(JUNGLE_TEMPLE_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) //Drop rate as decimal 0-1
                        .with(ItemEntry.builder(ModItems.METAL_DETECTOR)) //Item in table
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build()); //Quantity to "drop"

                tableBuilder.pool(poolBuilder.build());
            }
            if(CREEPER_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.85f)) //Drop rate as decimal 0-1
                        .with(ItemEntry.builder(ModItems.COAL_BRIQUETTE)) //Item in table
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build()); //Quantity to "drop"

                tableBuilder.pool(poolBuilder.build());
            }

            /*if(SUSPICIOUS_SAND_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .with(ItemEntry.builder(ModItems.METAL_DETECTOR));
                tableBuilder.pool(poolBuilder.build());*
            }*/
            //Suspicious sand is fucked. Waiting until further into tutorial to fix
        });

        /*LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {
            if(SUSPICIOUS_SAND_ID.equals(id)){
                List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));
            }

            return null;
        });*/
    }
}
