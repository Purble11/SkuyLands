package com.purble.skuylands.util.handlers;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.commands.killme.CommandKillMe;
import com.purble.skuylands.init.BiomeInit;
import com.purble.skuylands.init.BlockInit;
import com.purble.skuylands.init.EnchantmentInit;
import com.purble.skuylands.init.EntityInit;
import com.purble.skuylands.init.ItemInit;
import com.purble.skuylands.init.PotionInit;
import com.purble.skuylands.recipes.SmeltingRecipes;
import com.purble.skuylands.world.gen.WorldGenCustomStructures;
import com.purble.skuylands.world.gen.WorldGenOres;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class RegistryHandler {
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLeaedTable.class, new RenderLeaedTable());
	}
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void onModelRegiser(ModelRegistryEvent event) {
		RenderHandler.registerEntityRenders();
		//SkuyLands.proxy.registerItemRenderer(Item.getItemFromBlock(BlockInit.LEAED_TABLE), 0, "inventory");
		for(Item item : ItemInit.ITEMS) {
			SkuyLands.proxy.registerItemRenderer(item, 0, "inventory");
		}
		
		for(Block block : BlockInit.BLOCKS) {
			SkuyLands.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, "inventory");
		}
	}
	
	@SubscribeEvent
	public static void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
		event.getRegistry().registerAll(EnchantmentInit.ENCHANTMENTS.toArray(new Enchantment[0]));
	}
	
	public static void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
		EventHandler.registerEvents();
		SoundsHandler.registerSounds();
		EntityInit.registerEntities();
		ConfigHandler.registerConfig(event);
		LootTableHandler.registerLootTables();
		PotionInit.registerPotions();
	}
	
	public static void init() {
		SmeltingRecipes.init();
		GameRegistry.registerWorldGenerator(new WorldGenOres(), 4);
		BiomeInit.registerBiomes();
		SkuyLands.proxy.render();
	}
	
	public static void postInit() {
	}
	
	public static void serverRegistries(FMLServerStartingEvent event) {
		event.registerServerCommand(new CommandKillMe());
	}
}
