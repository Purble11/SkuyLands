package com.purble.skuylands.init;

import java.util.ArrayList;
import java.util.List;

import com.purble.skuylands.items.LEAOPED_APPLE;
import com.purble.skuylands.items.LEAOP_ARMOR;
import com.purble.skuylands.items.LEAOP_ARROW;
import com.purble.skuylands.items.LEAOP_INGOT;
import com.purble.skuylands.items.UNKNOWN_LEAOP_KEY;
import com.purble.skuylands.items.tools.LEAOP_AXE;
import com.purble.skuylands.items.tools.LEAOP_BOW;
import com.purble.skuylands.items.tools.LEAOP_HOE;
import com.purble.skuylands.items.tools.LEAOP_PICKAXE;
import com.purble.skuylands.items.tools.LEAOP_SHOVEL;
import com.purble.skuylands.items.tools.LEAOP_SWORD;
import com.purble.skuylands.util.Referance;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ItemInit {
	public static final List<Item> ITEMS = new ArrayList<>();
	
	//I am using .toLowerCase() cuz i am lazy
	public static final ArmorMaterial ARMOR_LEOP = EnumHelper.addArmorMaterial("ARMOR_LEOP".toLowerCase(), Referance.MOD_ID + ":leaop", 6000, new int[] {3, 6, 7, 4}, 100, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F); 
	public static final ToolMaterial TOOL_LEAOP = EnumHelper.addToolMaterial("TOOL_LEAOP".toLowerCase(), 30, 6000, 38.5F, 1, 100);
	
	public static final Item LEAOP_INGOT = new LEAOP_INGOT("LEAOP_INGOT".toLowerCase());
	public static final Item UNKNOWN_LEAOP_KEY = new UNKNOWN_LEAOP_KEY("UNKNOWN_LEAOP_KEY".toLowerCase());
	
	public static final Item LEAOPED_APPLE = new LEAOPED_APPLE("LEAOPED_APPLE".toLowerCase(), 20, 15.5F, false);
	
	public static final Item LEAOP_HELMET = new LEAOP_ARMOR("LEAOP_HELMET".toLowerCase(), 1, ARMOR_LEOP, EntityEquipmentSlot.HEAD);
	public static final Item LEAOP_CHESTPLATE = new LEAOP_ARMOR("LEAOP_CHESTPLATE".toLowerCase(), 1, ARMOR_LEOP, EntityEquipmentSlot.CHEST);
	public static final Item LEAOP_LEGGINGS = new LEAOP_ARMOR("LEAOP_LEGGINGS".toLowerCase(), 2, ARMOR_LEOP, EntityEquipmentSlot.LEGS);
	public static final Item LEAOP_BOOTS = new LEAOP_ARMOR("LEAOP_BOOTS".toLowerCase(), 1, ARMOR_LEOP, EntityEquipmentSlot.FEET);
	
	public static final Item LEAOP_SWORD = new LEAOP_SWORD("LEAOP_SWORD".toLowerCase(), TOOL_LEAOP);
	public static final Item LEAOP_PICKAXE = new LEAOP_PICKAXE("LEAOP_PICKAXE".toLowerCase(), TOOL_LEAOP);
	public static final Item LEAOP_AXE = new LEAOP_AXE("LEAOP_AXE".toLowerCase(), TOOL_LEAOP);
	public static final Item LEAOP_SHOVEL = new LEAOP_SHOVEL("LEAOP_SHOVEL".toLowerCase(), TOOL_LEAOP);
	public static final Item LEAOP_HOE = new LEAOP_HOE("LEAOP_HOE".toLowerCase(), TOOL_LEAOP);
	
	public static final Item LEAOP_BOW = new LEAOP_BOW("LEAOP_BOW".toLowerCase());
	public static final Item LEAOP_ARROW = new LEAOP_ARROW("LEAOP_ARROW".toLowerCase());
}
