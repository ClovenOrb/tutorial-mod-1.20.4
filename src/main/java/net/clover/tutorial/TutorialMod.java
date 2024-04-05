package net.clover.tutorial;

import net.clover.tutorial.block.ModBlocks;
import net.clover.tutorial.block.entity.ModBlockEntities;
import net.clover.tutorial.entity.ModEntities;
import net.clover.tutorial.entity.custom.PorcupineEntity;
import net.clover.tutorial.item.ModItemGroups;
import net.clover.tutorial.item.ModItems;
import net.clover.tutorial.recipe.ModRecipes;
import net.clover.tutorial.screen.ModScreenHandlers;
import net.clover.tutorial.sound.ModSounds;
import net.clover.tutorial.util.ModCustomTrades;
import net.clover.tutorial.util.ModLootTableModifiers;
import net.clover.tutorial.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModLootTableModifiers.modifyLootTables();
		ModCustomTrades.registerCustomTrades();

		ModVillagers.registerVillagers();
		ModSounds.registerSounds();
		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();

		ModRecipes.registerRecipes();

		FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUETTE, 200);

		FabricDefaultAttributeRegistry.register(ModEntities.PORCUPINE, PorcupineEntity.createPorcupineAttributes());
	}
}